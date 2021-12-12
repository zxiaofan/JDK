/*
 * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.org.apache.xml.internal.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a safe thread that does not inherit thread-locals and runs only
 * once.
 */
public class SafeThread extends Thread {
    private volatile boolean ran = false;

    private static final AtomicInteger threadNumber = new AtomicInteger(1);
    private static String threadName() {
        return "SafeThread-" + threadNumber.getAndIncrement();
    }

    public SafeThread(Runnable target) {
        this(null, target, threadName());
    }

    public SafeThread(Runnable target, String name) {
        this(null, target, name);
    }

    public SafeThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name, 0, false);
    }

    public final void run() {
        if (Thread.currentThread() != this) {
            throw new IllegalStateException("The run() method in a"
                    + " SafeThread cannot be called from another thread.");
        }
        synchronized (this) {
            if (!ran) {
                ran = true;
            } else {
                throw new IllegalStateException("The run() method in a"
                        + " SafeThread cannot be called more than once.");
            }
        }
        super.run();
    }
}
