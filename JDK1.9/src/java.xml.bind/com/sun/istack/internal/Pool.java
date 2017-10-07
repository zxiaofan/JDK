/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.istack.internal;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.lang.ref.WeakReference;

/**
 * Pool of reusable objects that are indistinguishable from each other,
 * such as JAXB marshallers.
 *
 * @author Kohsuke Kawaguchi
 */
public interface Pool<T> {

    /**
     * Gets a new object from the pool.
     *
     * <p>
     * If no object is available in the pool, this method creates a new one.
     */
    @NotNull T take();

    /**
     * Returns an object back to the pool.
     */
    void recycle(@NotNull T t);

    /**
     * Default implementation that uses {@link ConcurrentLinkedQueue}
     * as the data store.
     *
     * <h2>Note for Implementors</h2>
     * <p>
     * Don't rely on the fact that this class extends from {@link ConcurrentLinkedQueue}.
     */
    public abstract class Impl<T> implements Pool<T> {

        private volatile WeakReference<ConcurrentLinkedQueue<T>> queue;

        /**
         * Gets a new object from the pool.
         *
         * <p>
         * If no object is available in the pool, this method creates a new one.
         *
         * @return
         *      always non-null.
         */
        public final @NotNull T take() {
            T t = getQueue().poll();
            if(t==null) {
                return create();
            }
            return t;
        }

        /**
         * Returns an object back to the pool.
         */
        public final void recycle(T t) {
            getQueue().offer(t);
        }

        private ConcurrentLinkedQueue<T> getQueue() {
            WeakReference<ConcurrentLinkedQueue<T>> q = queue;
            if (q != null) {
                ConcurrentLinkedQueue<T> d = q.get();
                if (d != null) {
                    return d;
                }
            }
            // overwrite the queue
            ConcurrentLinkedQueue<T> d = new ConcurrentLinkedQueue<T>();
            queue = new WeakReference<ConcurrentLinkedQueue<T>>(d);

            return d;
        }

        /**
         * Creates a new instance of object.
         *
         * <p>
         * This method is used when someone wants to
         * {@link #take() take} an object from an empty pool.
         *
         * <p>
         * Also note that multiple threads may call this method
         * concurrently.
         */
        protected abstract @NotNull T create();
    }
}
