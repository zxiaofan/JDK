/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.embed.swing;

import com.sun.javafx.application.PlatformImpl;
import com.sun.javafx.tk.Toolkit;
import java.awt.EventQueue;
import java.awt.SecondaryLoop;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.application.Platform;
import sun.awt.AWTAccessor;
import sun.awt.FwDispatcher;

public class SwingFXUtilsImpl {

    private static class FwSecondaryLoop implements SecondaryLoop {

        private final AtomicBoolean isRunning = new AtomicBoolean(false);

        @Override
        public boolean enter() {
            if (isRunning.compareAndSet(false, true)) {
                PlatformImpl.runAndWait(() -> {
                    Toolkit.getToolkit().enterNestedEventLoop(FwSecondaryLoop.this);
                });
                return true;
            }
            return false;
        }

        @Override
        public boolean exit() {
            if (isRunning.compareAndSet(true, false)) {
                PlatformImpl.runAndWait(() -> {
                    Toolkit.getToolkit().exitNestedEventLoop(FwSecondaryLoop.this, null);
                });
                return true;
            }
            return false;
        }
    }

    private static class FXDispatcher implements FwDispatcher {

        @Override
        public boolean isDispatchThread() {
            return Platform.isFxApplicationThread();
        }

        @Override
        public void scheduleDispatch(Runnable runnable) {
            Platform.runLater(runnable);
        }

        @Override
        public SecondaryLoop createSecondaryLoop() {
            return new FwSecondaryLoop();
        }
    }

    private static EventQueue getEventQueue() {
        return AccessController.doPrivileged(
                (PrivilegedAction<EventQueue>) () -> java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue());
    }

    //Called with reflection from PlatformImpl to avoid dependency
    public static void installFwEventQueue() {
        AWTAccessor.getEventQueueAccessor().setFwDispatcher(getEventQueue(), new FXDispatcher());
    }

    //Called with reflection from PlatformImpl to avoid dependency
    public static void removeFwEventQueue() {
        AWTAccessor.getEventQueueAccessor().setFwDispatcher(getEventQueue(), null);
    }
}
