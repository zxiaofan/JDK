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

package com.sun.javafx.tk.quantum;

import com.sun.javafx.tk.Toolkit;
import com.sun.prism.impl.PrismSettings;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Class containing implementation for logging, and performance tracking.
 */
abstract class PerformanceTrackerHelper {

    private static final PerformanceTrackerHelper instance = createInstance();

    public static PerformanceTrackerHelper getInstance() {
        return instance;
    }

    private PerformanceTrackerHelper() {
    }

    private static PerformanceTrackerHelper createInstance() {
        PerformanceTrackerHelper trackerImpl = AccessController.doPrivileged(
                new PrivilegedAction<PerformanceTrackerHelper>() {

                    @Override
                    public PerformanceTrackerHelper run() {
                        try {
                            if (PrismSettings.perfLog != null) {
                                final PerformanceTrackerHelper trackerImpl =
                                        new PerformanceTrackerDefaultImpl();

                                if (PrismSettings.perfLogExitFlush) {
                                    Runtime.getRuntime().addShutdownHook(
                                            new Thread() {

                                                @Override
                                                public void run() {
                                                    trackerImpl.outputLog();
                                                }
                                            });
                                }

                                return trackerImpl;
                            }
                        } catch (Throwable t) {
                        }

                        return null;
                    }
                });

        if (trackerImpl == null) {
            trackerImpl = new PerformanceTrackerDummyImpl();
        }

        return trackerImpl;
    }

    public abstract void logEvent(final String s);

    public abstract void outputLog();

    public abstract boolean isPerfLoggingEnabled();

    public final long nanoTime() {
        return Toolkit.getToolkit().getMasterTimer().nanos();
    }

    private static final class PerformanceTrackerDefaultImpl
            extends PerformanceTrackerHelper {
        private long firstTime;
        private long lastTime;

        @Override
        public void logEvent(final String s) {
            final long time = System.currentTimeMillis();
            if (firstTime == 0) {
                firstTime = time;
            }
            PerformanceLogger.setTime("JavaFX> " + s + " ("
                        + (time - firstTime) + "ms total, "
                        + (time - lastTime) + "ms)");
            lastTime = time;
        }

        @Override
        public void outputLog() {

            logLaunchTime();

            // Output the log
            PerformanceLogger.outputLog();
        }

        @Override
        public boolean isPerfLoggingEnabled() {
            return true;
        }

        private void logLaunchTime() {
            try {
                // Attempt to log launchTime, if not set already
                if (PerformanceLogger.getStartTime() <= 0) {
                    // Standalone apps record launch time as sysprop
                    String launchTimeString = AccessController.doPrivileged(
                            (PrivilegedAction<String>) () -> System.getProperty("launchTime"));

                    if (launchTimeString != null
                            && !launchTimeString.equals("")) {
                        long launchTime = Long.parseLong(launchTimeString);
                        PerformanceLogger.setStartTime("LaunchTime", launchTime);
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    private static final class PerformanceTrackerDummyImpl
            extends PerformanceTrackerHelper {
        @Override
        public void logEvent(final String s) {
        }

        @Override
        public void outputLog() {
        }

        @Override
        public boolean isPerfLoggingEnabled() {
            return false;
        }
    }
}
