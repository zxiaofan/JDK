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
package com.sun.glass.ui;

import java.lang.annotation.Native;

/**
 * A high-resolution timer.
 *
 * An application may either override its run() method, or pass a Runnable
 * object to the constructor of the Timer class.
 * <p>
 * The run() method may be invoked on a thread other than the UI thread. If
 * a developer wants to process timer events on the UI thread, they can use
 * the Application.invokeLater/invokeAndWait() API.
 */
public abstract class Timer {

    @Native private final static double UNSET_PERIOD = -1.0; // 0 is valid value, so can't use it here
    @Native private final static double SET_PERIOD   = -2.0; // token value for vsync timer

    private final Runnable runnable;
    private long ptr;
    private double period = UNSET_PERIOD;

    protected abstract long _start(Runnable runnable);
    protected abstract long _start(Runnable runnable, int period);
    protected abstract void _stop(long timer);

    /**
     * Constructs a new timer.
     *
     * If the application overrides the Timer.run(), it should call super.run()
     * in order to run the runnable passed to the constructor.
     */
    protected Timer(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("runnable shouldn't be null");
        }
        this.runnable = runnable;
    }

    /**
     * Returns the minimum timer period supported by the native system.
     */
    public static int getMinPeriod() {
        return Application.GetApplication().staticTimer_getMinPeriod();
    }

    /**
     * Returns the maximum timer period supported by the native system.
     */
    public static int getMaxPeriod() {
        return Application.GetApplication().staticTimer_getMaxPeriod();
    }

    /**
     * Starts the timer.
     * The period must be in the range getMinPeriod() .. getMaxPeriod().
     * If the timer is currently started, it gets stopped before re-starting.
     * If starting the timer fails, the RuntimeException is thrown.
     */
    public synchronized void start(int period) {
        if (period < getMinPeriod() || period > getMaxPeriod()) {
            throw new IllegalArgumentException("period is out of range");
        }

        if (this.ptr != 0L) {
            stop();
        }

        this.ptr = _start(this.runnable, period);
        if (this.ptr == 0L) {
            this.period = UNSET_PERIOD;
            throw new RuntimeException("Failed to start the timer");
        } else {
            this.period = (double)period;
        }
    }

    /**
     * Start a vsync-based timer if the system supports it.
     *
     * A RuntimeException is thrown if the system does not support
     * vsync-based timer or if there was an issue starting the timer.
     */
    public synchronized void start() {
        if (this.ptr != 0L) {
            stop();
        }

        this.ptr = _start(this.runnable);
        if (this.ptr == 0L) {
            this.period = UNSET_PERIOD;
            throw new RuntimeException("Failed to start the timer");
        } else {
            this.period = SET_PERIOD;
        }
    }

    /**
     * Stops the timer.  If a vsync-based timer is stopped, all of the
     * vsync timers currently running will be stopped.
     */
    public synchronized void stop() {
        if (this.ptr != 0L) {
            _stop(this.ptr);
            this.ptr = 0L;
            this.period = UNSET_PERIOD;
        }
    }

    /**
     * Returns true if the timer is currently running
     * (convenience API: might not need it)
     */
    public synchronized boolean isRunning() {
        return (this.period != UNSET_PERIOD);
    }
}
