/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http.common;

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/**
 * Maintains subscription counter and provides primitives for:
 * - accessing window
 * - reducing window when delivering items externally
 * - resume delivery when window was zero previously
 */
public class SubscriptionBase implements Flow.Subscription {

    final Demand demand = new Demand();

    final SequentialScheduler scheduler; // when window was zero and is opened, run this
    final Runnable cancelAction; // when subscription cancelled, run this
    final AtomicBoolean cancelled;
    final Consumer<Throwable> onError;

    public SubscriptionBase(SequentialScheduler scheduler, Runnable cancelAction) {
        this(scheduler, cancelAction, null);
    }

    public SubscriptionBase(SequentialScheduler scheduler,
                            Runnable cancelAction,
                            Consumer<Throwable> onError) {
        this.scheduler = scheduler;
        this.cancelAction = cancelAction;
        this.cancelled = new AtomicBoolean(false);
        this.onError = onError;
    }

    @Override
    public void request(long n) {
        try {
            if (demand.increase(n))
                scheduler.runOrSchedule();
        } catch(Throwable t) {
            if (onError != null) {
                if (cancelled.getAndSet(true))
                    return;
                onError.accept(t);
            } else throw t;
        }
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
