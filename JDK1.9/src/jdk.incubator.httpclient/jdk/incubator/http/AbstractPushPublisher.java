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
import java.util.concurrent.CompletionException;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

/**
 * A super class for PushPublisher implementation.
 */
abstract class AbstractPushPublisher<T> implements Flow.Publisher<T> {

    static enum SubscriptionState { OPENED, DONE, CANCELLED };

    public abstract void acceptData(Optional<T> item)
        throws InterruptedException;

    public abstract void acceptError(Throwable t);

    public Consumer<Optional<T>> asDataConsumer() {
        return this::consume;
    }

    void consume(Optional<T> item) {
        try {
            acceptData(item);
        } catch (InterruptedException x) {
            throw new CompletionException(x);
        }
    }

}
