/*
 * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Objects;
import java.util.concurrent.Executor;

/**
 * Executes tasks within a given access control context, and by a given executor.
 */
class PrivilegedExecutor implements Executor {

    /** The underlying executor. May be provided by the user. */
    final Executor executor;
    /** The ACC to execute the tasks within. */
    @SuppressWarnings("removal")
    final AccessControlContext acc;

    public PrivilegedExecutor(Executor executor, @SuppressWarnings("removal") AccessControlContext acc) {
        Objects.requireNonNull(executor);
        Objects.requireNonNull(acc);
        this.executor = executor;
        this.acc = acc;
    }

    private static class PrivilegedRunnable implements Runnable {
        private final Runnable r;
        @SuppressWarnings("removal")
        private final AccessControlContext acc;
        PrivilegedRunnable(Runnable r, @SuppressWarnings("removal") AccessControlContext acc) {
            this.r = r;
            this.acc = acc;
        }
        @SuppressWarnings("removal")
        @Override
        public void run() {
            PrivilegedAction<Void> pa = () -> { r.run(); return null; };
            AccessController.doPrivileged(pa, acc);
        }
    }

    @Override
    public void execute(Runnable r) {
        executor.execute(new PrivilegedRunnable(r, acc));
    }
}
