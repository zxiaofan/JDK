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
 *
 *
 */

package jdk.incubator.http.internal.common;

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Maintains subscription counter and provides primitives for
 * - accessing window
 * - reducing window when delivering items externally
 * - resume delivery when window was zero previously
 *
 * @author mimcmah
 */
public class SubscriptionBase implements Flow.Subscription {

    final Demand demand = new Demand();

    final SequentialScheduler scheduler; // when window was zero and is opened, run this
    final Runnable cancelAction; // when subscription cancelled, run this
    final AtomicBoolean cancelled;

    public SubscriptionBase(SequentialScheduler scheduler, Runnable cancelAction) {
        this.scheduler = scheduler;
        this.cancelAction = cancelAction;
        this.cancelled = new AtomicBoolean(false);
    }

    @Override
    public void request(long n) {
        if (demand.increase(n))
            scheduler.runOrSchedule();
    }



    @Override
    public synchronized String toString() {
        return "SubscriptionBase: window = " + demand.get() +
                " cancelled = " + cancelled.toString();
    }

    /**
     * Returns true if the window was reduced by 1. In that case
     * items must be supplied to subscribers and the scheduler run
     * externally. If the window could not be reduced by 1, then false
     * is returned and the scheduler will run later when the window is updated.
     */
    public boolean tryDecrement() {
        return demand.tryDecrement();
    }

    public long window() {
        return demand.get();
    }

    @Override
    public void cancel() {
        if (cancelled.getAndSet(true))
            return;
        scheduler.stop();
        cancelAction.run();
    }
}
