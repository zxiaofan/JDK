/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.util.concurrent;

/**
 * A delayed result-bearing action that can be cancelled.
 * Usually a scheduled future is the result of scheduling
 * a task with a {@link ScheduledExecutorService}.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <V> The result type returned by this Future
 */
public interface ScheduledFuture<V> extends Delayed, Future<V> {
}
