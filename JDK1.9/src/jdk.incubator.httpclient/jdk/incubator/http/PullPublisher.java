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

import java.util.Iterator;
import java.util.concurrent.Flow;

/**
 * A Publisher that is expected to run in same thread as subscriber.
 * Items are obtained from Iterable. Each new subscription gets a new Iterator.
 */
class PullPublisher<T> implements Flow.Publisher<T> {

    private final Iterable<T> iterable;

    PullPublisher(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new Subscription(subscriber, iterable.iterator()));
    }

    private class Subscription implements Flow.Subscription {

        private final Flow.Subscriber<? super T> subscriber;
        private final Iterator<T> iter;
        private boolean done = false;
        private long demand = 0;
        private int recursion = 0;

        Subscription(Flow.Subscriber<? super T> subscriber, Iterator<T> iter) {
            this.subscriber = subscriber;
            this.iter = iter;
        }

        @Override
        public void request(long n) {
            if (done) {
                subscriber.onError(new IllegalArgumentException("request(" + n + ")"));
            }
            demand += n;
            recursion ++;
            if (recursion > 1) {
                return;
            }
            while (demand > 0) {
                done = !iter.hasNext();
                if (done) {
                    subscriber.onComplete();
                    recursion --;
                    return;
                }
                subscriber.onNext(iter.next());
                demand --;
            }
        }

        @Override
        public void cancel() {
            done = true;
        }

    }
}
