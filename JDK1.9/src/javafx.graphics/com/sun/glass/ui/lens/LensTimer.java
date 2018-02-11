/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.lens;

import com.sun.glass.ui.Timer;

/**
 * Lens implementation class for Timer.
 */
final class LensTimer extends Timer {
    static java.util.Timer timer;
    private java.util.TimerTask task;

    protected LensTimer(final Runnable runnable) {
        super(runnable);
    }

    static int getMinPeriod_impl() {
        return 0;
    }

    static int getMaxPeriod_impl() {
        return 1000000;
    }

    @Override protected long _start(final Runnable runnable, int period) {
        if (timer == null) {
            timer = new java.util.Timer(true);
        }

        task = new java.util.TimerTask() {

            @Override
            public void run() {
                runnable.run();
            }
        };

        timer.schedule(task, 0, (long)period);
        return 1; // need something non-zero to denote success.
    }

    @Override protected long _start(Runnable runnable) {
        throw new RuntimeException("vsync timer not supported");
    }

    @Override protected void _stop(long timer) {
        if (task != null) {
            task.cancel();
            task = null;
        }
    }
}

