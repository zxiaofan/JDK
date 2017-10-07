/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.util.Duration;

/**
 * This {@code Transition} executes an {@link Animation#onFinished} at the end of its
 * {@link #duration}.
 *
 * <p>
 * Code Segment Example:
 * </p>
 *
 * <pre>
 * <code>
 * import javafx.scene.shape.*;
 * import javafx.animation.*;
 *
 * ...
 *
 *     Rectangle rect = new Rectangle (100, 40, 100, 100);
 *     rect.setArcHeight(50);
 *     rect.setArcWidth(50);
 *     rect.setFill(Color.VIOLET);
 *
 *     RotateTransition rt = new RotateTransition(Duration.millis(3000), rect);
 *     rt.setByAngle(180);
 *     rt.setCycleCount(4f);
 *     rt.setAutoReverse(true);
 *     SequentialTransition seqTransition = new SequentialTransition (
 *         new PauseTransition(Duration.millis(1000)), // wait a second
 *         rt
 *     );
 *     seqTransition.play();
 *
 * ...
 *
 * </code>
 * </pre>
 *
 * @see Transition
 * @see Animation
 *
 * @since JavaFX 2.0
 */
public final class PauseTransition extends Transition {

    /**
     * The duration of this {@code Transition}.
     * <p>
     * It is not possible to change the {@code duration} of a running
     * {@code PauseTransition}. If the value of {@code duration} is changed for a
     * running {@code PauseTransition}, the animation has to be stopped and started again to
     * pick up the new value.
     * <p>
     * Note: While the unit of {@code duration} is a millisecond, the
     * granularity depends on the underlying operating system and will in
     * general be larger. For example animations on desktop systems usually run
     * with a maximum of 60fps which gives a granularity of ~17 ms.
     *
     * Setting duration to value lower than {@link Duration#ZERO} will result
     * in {@link IllegalArgumentException}.
     *
     * @defaultValue 400ms
     */
    private ObjectProperty<Duration> duration;
    private static final Duration DEFAULT_DURATION = Duration.millis(400);

    public final void setDuration(Duration value) {
        if ((duration != null) || (!DEFAULT_DURATION.equals(value))) {
            durationProperty().set(value);
        }
    }

    public final Duration getDuration() {
        return (duration == null)? DEFAULT_DURATION : duration.get();
    }

    public final ObjectProperty<Duration> durationProperty() {
        if (duration == null) {
            duration = new ObjectPropertyBase<Duration>(DEFAULT_DURATION) {

                @Override
                public void invalidated() {
                    try {
                        setCycleDuration(getDuration());
                    } catch (IllegalArgumentException e) {
                        if (isBound()) {
                            unbind();
                        }
                        set(getCycleDuration());
                        throw e;
                    }
                }

                @Override
                public Object getBean() {
                    return PauseTransition.this;
                }

                @Override
                public String getName() {
                    return "duration";
                }
            };
        }
        return duration;
    }

    /**
     * The constructor of {@code PauseTransition}.
     *
     * @param duration
     *            The duration of the {@code PauseTransition}
     */
    public PauseTransition(Duration duration) {
        setDuration(duration);
        setCycleDuration(duration);
    }

    /**
     * The constructor of {@code PauseTransition}
     */
    public PauseTransition() {
        this(DEFAULT_DURATION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void interpolate(double frac) {
        // no-op
    }
}
