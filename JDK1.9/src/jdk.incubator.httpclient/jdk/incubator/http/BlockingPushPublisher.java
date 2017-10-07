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

package jdk.incubator.http;

import java.util.Optional;
import java.util.concurrent.Flow;
import jdk.incubator.http.internal.common.Log;

/**
 * A Publisher which is assumed to run in its own thread.
 *
 * acceptData() may therefore block while waiting for subscriber demand
 */
class BlockingPushPublisher<T> extends AbstractPushPublisher<T> {
    volatile Subscription subscription;
    volatile Flow.Subscriber<? super T> subscriber;
    volatile SubscriptionState state;
    long demand;

    @Override
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        state = SubscriptionState.OPENED;
        subscription = new Subscription(subscriber);
        subscriber.onSubscribe(subscription);
    }

    /**
     * Entry point for supplying items to publisher. This call will block
     * when no demand available.
     */
    @Override
    public void acceptData(Optional<T> item) throws InterruptedException {
        SubscriptionState s = this.state;

        // do not use switch(this.state): this.state could be null.
        if (s == SubscriptionState.CANCELLED) return;
        if (s == SubscriptionState.DONE) {
            throw new IllegalStateException("subscription complete");
        }

        if (!item.isPresent()) {
            subscriber.onComplete();
            this.state = SubscriptionState.DONE;
        } else {
            obtainPermit();
            if (this.state == SubscriptionState.CANCELLED) return;
            subscriber.onNext(item.get());
        }
    }

    /**
     * Terminates the publisher with given exception.
     */
    @Override
    public void acceptError(Throwable t) {
        if (this.state != SubscriptionState.OPENED) {
            Log.logError(t);
            return;
        }
        subscriber.onError(t);
        cancel();
    }

    private synchronized void obtainPermit() throws InterruptedException {
        while (demand == 0) {
            wait();
        }
        if (this.state == SubscriptionState.DONE) {
            throw new IllegalStateException("subscription complete");
        }
        demand --;
    }

    synchronized void addPermits(long n) {
        long old = demand;
        demand += n;
        if (old == 0) {
            notifyAll();
        }
    }

    synchronized void cancel() {
        this.state = SubscriptionState.CANCELLED;
        notifyAll();
    }

    private class Subscription implements Flow.Subscription {

        Subscription(Flow.Subscriber<? super T> subscriber) {
            BlockingPushPublisher.this.subscriber = subscriber;
        }

        @Override
        public void request(long n) {
            addPermits(n);
        }

        @Override
        public void cancel() {
            BlockingPushPublisher.this.cancel();
        }
    }
}
