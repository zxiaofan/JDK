/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.net.SocketPermission;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.Executor;
import jdk.internal.misc.InnocuousThread;

/**
 * Wraps the supplied user Executor
 *
 * when a Security manager set, the correct access control context is used to execute task
 *
 * The access control context is captured at creation time of this object
 */
class ExecutorWrapper {

    final Executor userExecutor; // the undeerlying executor provided by user
    final Executor executor; // the executur which wraps the user's one
    final AccessControlContext acc;
    final ClassLoader ccl;

    public ExecutorWrapper(Executor userExecutor, AccessControlContext acc) {
        this.userExecutor = userExecutor;
        this.acc = acc;
        this.ccl = getCCL();
        if (System.getSecurityManager() == null) {
            this.executor = userExecutor;
        } else {
            this.executor = this::run;
        }
    }

    private ClassLoader getCCL() {
        return AccessController.doPrivileged(
            (PrivilegedAction<ClassLoader>) () -> {
                return Thread.currentThread().getContextClassLoader();
            }
        );
    }

    /**
     * This is only used for the default HttpClient to deal with
     * different application contexts that might be using it.
     * The default client uses InnocuousThreads in its Executor.
     */
    private void prepareThread() {
        final Thread me = Thread.currentThread();
        if (!(me instanceof InnocuousThread))
            return;
        InnocuousThread innocuousMe = (InnocuousThread)me;

        AccessController.doPrivileged(
            (PrivilegedAction<Void>) () -> {
                innocuousMe.setContextClassLoader(ccl);
                innocuousMe.eraseThreadLocals();
                return null;
            }
        );
    }


    void run(Runnable r) {
        prepareThread();
        try {
            userExecutor.execute(r); // all throwables must be caught
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public Executor userExecutor() {
        return userExecutor;
    }

    public Executor executor() {
        return executor;
    }
}
