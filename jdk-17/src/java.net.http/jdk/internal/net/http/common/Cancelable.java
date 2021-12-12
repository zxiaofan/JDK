/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

/**
 * A functional interface that allows to request cancellation
 * of a task - which may or may not have already started.
 */
@FunctionalInterface
public interface Cancelable {
    /**
     * Attempts to cancel execution of a task.  This attempt may not
     * succeed if the task has already completed, has already been cancelled,
     * or could not be cancelled for some other reason.
     *
     * @param mayInterruptIfRunning {@code true} if an attempt to stop the
     * task should be made even if the task has already started; otherwise,
     * in-progress tasks are allowed to complete.
     *
     * @return {@code false} if the task could not be cancelled,
     * typically because it has already completed normally;
     * {@code true} otherwise
     */
    boolean cancel(boolean mayInterruptIfRunning);
}
