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

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;

// Completes the subscription on first request. Never calls onNext()

class PseudoPublisher<T> implements Flow.Publisher<T> {

    private final Throwable throwable;

    PseudoPublisher() {
        this(null);
    }

    PseudoPublisher(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new Subscription(subscriber));
    }

    private class Subscription implements Flow.Subscription {

        private final Flow.Subscriber<? super T> subscriber;
        private final AtomicBoolean done = new AtomicBoolean();

        Subscription(Flow.Subscriber<? super T> subscriber) {
            this.subscriber = subscriber;
        }

        @Override
        public void request(long n) {
            if (done.compareAndSet(false, true)) {
                if (n > 0) {
                    if (throwable == null) {
                        subscriber.onComplete();
                    } else {
                        subscriber.onError(throwable);
                    }
                } else {
                    subscriber.onError(new IllegalArgumentException("request(" + n + ")"));
                }
            }
        }

        @Override
        public void cancel() {
            done.set(true);
        }

    }
}
