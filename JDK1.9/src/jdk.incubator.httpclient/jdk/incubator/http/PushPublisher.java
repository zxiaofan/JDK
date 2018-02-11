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
import java.util.function.Consumer;

/**
 * A single threaded Publisher which runs in same thread as subscriber.
 */
class PushPublisher<T> extends AbstractPushPublisher<T> {
    Subscription subscription;
    Flow.Subscriber<? super T> subscriber;
    SubscriptionState state;
    long demand;

    /**
     * Pushes/consumes the incoming objects.
     * The consumer blocks until subscriber ready to receive.
     */
    @Override
    public void acceptData(Optional<T> item) {
        SubscriptionState s = this.state;

        if (s == SubscriptionState.CANCELLED) return;
        if (s == SubscriptionState.DONE) {
            throw new IllegalStateException("subscription complete");
        }

        if (!item.isPresent()) {
            subscriber.onComplete();
            this.state = SubscriptionState.DONE;
            return;
        }
        if (demand == 0) {
            throw new IllegalStateException("demand == 0");
        }
        demand--;
        subscriber.onNext(item.get());
    }

    @Override
    public Consumer<Optional<T>> asDataConsumer() {
        return this::acceptData;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        subscription = new Subscription(subscriber);
        subscriber.onSubscribe(subscription);
    }

    private class Subscription implements Flow.Subscription {

        Subscription(Flow.Subscriber<? super T> subscriber) {
            PushPublisher.this.subscriber = subscriber;
        }

        @Override
        public void request(long n) {
            demand += n;
        }

        @Override
        public void cancel() {
            state = SubscriptionState.CANCELLED;
        }
    }

    @Override
    public void acceptError(Throwable t) {
        if (this.state == SubscriptionState.DONE) {
            throw new IllegalStateException("subscription complete");
        }
        this.state = SubscriptionState.CANCELLED;
        subscriber.onError(t);
    }
}
