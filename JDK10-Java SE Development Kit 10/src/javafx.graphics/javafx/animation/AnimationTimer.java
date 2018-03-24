/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javafx.animation;

import com.sun.javafx.tk.Toolkit;
import com.sun.scenario.animation.AbstractMasterTimer;
import com.sun.scenario.animation.shared.TimerReceiver;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * The class {@code AnimationTimer} allows to create a timer, that is called in
 * each frame while it is active.
 *
 * An extending class has to override the method {@link #handle(long)} which
 * will be called in every frame.
 *
 * The methods {@link AnimationTimer#start()} and {@link #stop()} allow to start
 * and stop the timer.
 *
 *
 * @since JavaFX 2.0
 */
public abstract class AnimationTimer {

    private class AnimationTimerReceiver implements TimerReceiver {
        @Override public void handle(final long now) {
            if (accessCtrlCtx == null) {
                throw new IllegalStateException("Error: AccessControlContext not captured");
            }

            AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
                AnimationTimer.this.handle(now);
                return null;
            }, accessCtrlCtx);
        }
    }

    private final AbstractMasterTimer timer;
    private final AnimationTimerReceiver timerReceiver = new AnimationTimerReceiver();
    private boolean active;

    // Access control context, captured in start()
    private AccessControlContext accessCtrlCtx = null;

    /**
     * Creates a new timer.
     */
    public AnimationTimer() {
        timer = Toolkit.getToolkit().getMasterTimer();
    }

    // For testing only
    AnimationTimer(AbstractMasterTimer timer) {
        this.timer = timer;
    }

    /**
     * This method needs to be overridden by extending classes. It is going to
     * be called in every frame while the {@code AnimationTimer} is active.
     *
     * @param now
     *            The timestamp of the current frame given in nanoseconds. This
     *            value will be the same for all {@code AnimationTimers} called
     *            during one frame.
     */
    public abstract void handle(long now);

    /**
     * Starts the {@code AnimationTimer}. Once it is started, the
     * {@link #handle(long)} method of this {@code AnimationTimer} will be
     * called in every frame.
     *
     * The {@code AnimationTimer} can be stopped by calling {@link #stop()}.
     */
    public void start() {
        if (!active) {
            // Capture the Access Control Context to be used during the animation pulse
            accessCtrlCtx = AccessController.getContext();
            timer.addAnimationTimer(timerReceiver);
            active = true;
        }
    }

    /**
     * Stops the {@code AnimationTimer}. It can be activated again by calling
     * {@link #start()}.
     */
    public void stop() {
        if (active) {
            timer.removeAnimationTimer(timerReceiver);
            active = false;
        }
    }
}
