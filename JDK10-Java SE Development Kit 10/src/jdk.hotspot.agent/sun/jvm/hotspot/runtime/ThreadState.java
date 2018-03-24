/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.runtime;

/** This is a type-safe enum mirroring the ThreadState enum in
 osThread.hpp. The conversion between the underlying ints
 and these values is done in OSThread. */

public class ThreadState {

    private String printVal;

    /** Memory has been allocated but not initialized */
    public static final ThreadState ALLOCATED = new ThreadState("allocated");
    /** The thread has been initialized but yet started */
    public static final ThreadState INITIALIZED = new ThreadState("initialized");
    /** Has been started and is runnable, but not necessarily running */
    public static final ThreadState RUNNABLE = new ThreadState("runnable");
    /** Waiting on a contended monitor lock */
    public static final ThreadState MONITOR_WAIT = new ThreadState("waiting for monitor entry");
    /** Waiting on a condition variable */
    public static final ThreadState CONDVAR_WAIT = new ThreadState("waiting on condition");
    /** Waiting on an Object.wait() call */
    public static final ThreadState OBJECT_WAIT = new ThreadState("in Object.wait()");
    /** Suspended at breakpoint */
    public static final ThreadState BREAKPOINTED = new ThreadState("at breakpoint");
    /** Thread.sleep() */
    public static final ThreadState SLEEPING = new ThreadState("sleeping");
    /** All done, but not reclaimed yet */
    public static final ThreadState ZOMBIE = new ThreadState("zombie");

    private ThreadState(String printVal){
        this.printVal = printVal;
    }

    public String getPrintVal() {
        return printVal;
    }
}
