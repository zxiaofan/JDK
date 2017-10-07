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

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

class DefaultPublisher<T> implements Flow.Publisher<T> {

    private final Supplier<Optional<T>> supplier;
    // this executor will be wrapped in another executor
    // which may override it and just run in the calling thread
    // if it knows the user call is blocking
    private final Executor executor;

    /**
     * Supplier returns non empty Optionals until final
     */
    DefaultPublisher(Supplier<Optional<T>> supplier, Executor executor) {
        this.supplier = supplier;
        this.executor = executor;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new Subscription(subscriber));
        } catch (RejectedExecutionException e) {
            subscriber.onError(new IllegalStateException(e));
        }
    }

    private class Subscription implements Flow.Subscription {

        private final Flow.Subscriber<? super T> subscriber;
        private final AtomicBoolean done = new AtomicBoolean();

        private final AtomicLong demand = new AtomicLong();

        private final Lock consumerLock = new ReentrantLock();
        private final Condition consumerAlarm = consumerLock.newCondition();

        Subscription(Flow.Subscriber<? super T> subscriber) {
            this.subscriber = subscriber;

            executor.execute(() -> {
                try {
                    while (!done.get()) {
                        consumerLock.lock();
                        try {
                            while (!done.get() && demand.get() == 0) {
                                consumerAlarm.await();
                            }
                        } finally {
                            consumerLock.unlock();
                        }

                        long nbItemsDemanded = demand.getAndSet(0);
                        for (long i = 0; i < nbItemsDemanded && !done.get(); i++) {
                            try {
                                Optional<T> item = Objects.requireNonNull(supplier.get());
                                if (item.isPresent()) {
                                    subscriber.onNext(item.get());
                                } else {
                                    if (done.compareAndSet(false, true)) {
                                        subscriber.onComplete();
                                    }
                                }
                            } catch (RuntimeException e) {
                                if (done.compareAndSet(false, true)) {
                                    subscriber.onError(e);
                                }
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    if (done.compareAndSet(false, true)) {
                        subscriber.onError(e);
                    }
                }
            });
        }

        @Override
        public void request(long n) {
            if (!done.get() && n > 0) {
                demand.updateAndGet(d -> (d + n > 0) ? d + n : Long.MAX_VALUE);
                wakeConsumer();
            } else if (done.compareAndSet(false, true)) {
                subscriber.onError(new IllegalArgumentException("request(" + n + ")"));
            }
        }

        @Override
        public void cancel() {
            done.set(true);
            wakeConsumer();
        }

        private void wakeConsumer() {
            consumerLock.lock();
            try {
                consumerAlarm.signal();
            } finally {
                consumerLock.unlock();
            }
        }

    }
}
