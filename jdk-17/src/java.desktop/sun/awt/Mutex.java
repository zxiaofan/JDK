/*
 * Copyright (c) 1999, 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

public class Mutex {
    private boolean locked;
    private Thread owner;

    public synchronized void lock() {
        if (locked && Thread.currentThread() == owner) {
            throw new IllegalMonitorStateException();
        }
        do {
            if (!locked) {
                locked = true;
                owner = Thread.currentThread();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // try again
                }
            }
        } while (owner != Thread.currentThread());
    }

    public synchronized void unlock() {
        if (Thread.currentThread() != owner) {
            throw new IllegalMonitorStateException();
        }
        owner = null;
        locked = false;
        notify();
    }

    protected boolean isOwned() {
        return (locked && Thread.currentThread() == owner);
    }
}
