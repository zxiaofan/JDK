/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.ProtectionDomain;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A thread that has no permissions, is not a member of any user-defined
 * ThreadGroup and supports the ability to erase ThreadLocals.
 */
public final class InnocuousThread extends Thread {
    private static final jdk.internal.misc.Unsafe UNSAFE;
    private static final long THREAD_LOCALS;
    private static final long INHERITABLE_THREAD_LOCALS;
    private static final ThreadGroup INNOCUOUSTHREADGROUP;
    private static final AccessControlContext ACC;
    private static final long INHERITEDACCESSCONTROLCONTEXT;
    private static final long CONTEXTCLASSLOADER;

    private static final AtomicInteger threadNumber = new AtomicInteger(1);
    private static String newName() {
        return "InnocuousThread-" + threadNumber.getAndIncrement();
    }

    /**
     * Returns a new InnocuousThread with an auto-generated thread name
     * and its context class loader is set to the system class loader.
     */
    public static Thread newThread(Runnable target) {
        return newThread(newName(), target);
    }

    /**
     * Returns a new InnocuousThread with its context class loader
     * set to the system class loader.
     */
    public static Thread newThread(String name, Runnable target) {
        return new InnocuousThread(INNOCUOUSTHREADGROUP,
                                   target,
                                   name,
                                   ClassLoader.getSystemClassLoader());
    }

    /**
     * Returns a new InnocuousThread with an auto-generated thread name.
     * Its context class loader is set to null.
     */
    public static Thread newSystemThread(Runnable target) {
        return newSystemThread(newName(), target);
    }

    /**
     * Returns a new InnocuousThread with null context class loader.
     */
    public static Thread newSystemThread(String name, Runnable target) {
        return new InnocuousThread(INNOCUOUSTHREADGROUP,
                                   target, name, null);
    }

    private InnocuousThread(ThreadGroup group, Runnable target, String name, ClassLoader tccl) {
        super(group, target, name, 0L, false);
        UNSAFE.putObjectRelease(this, INHERITEDACCESSCONTROLCONTEXT, ACC);
        UNSAFE.putObjectRelease(this, CONTEXTCLASSLOADER, tccl);
    }

    @Override
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler x) {
        // silently fail
    }

    @Override
    public void setContextClassLoader(ClassLoader cl) {
        // Allow clearing of the TCCL to remove the reference to the system classloader.
        if (cl == null)
            super.setContextClassLoader(null);
        else
            throw new SecurityException("setContextClassLoader");
    }

    /**
     * Drops all thread locals (and inherited thread locals).
     */
    public final void eraseThreadLocals() {
        UNSAFE.putObject(this, THREAD_LOCALS, null);
        UNSAFE.putObject(this, INHERITABLE_THREAD_LOCALS, null);
    }

    // ensure run method is run only once
    private volatile boolean hasRun;

    @Override
    public void run() {
        if (Thread.currentThread() == this && !hasRun) {
            hasRun = true;
            super.run();
        }
    }

    // Use Unsafe to access Thread group and ThreadGroup parent fields
    static {
        try {
            ACC = new AccessControlContext(new ProtectionDomain[] {
                new ProtectionDomain(null, null)
            });

            // Find and use topmost ThreadGroup as parent of new group
            UNSAFE = jdk.internal.misc.Unsafe.getUnsafe();
            Class<?> tk = Thread.class;
            Class<?> gk = ThreadGroup.class;

            THREAD_LOCALS = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("threadLocals"));
            INHERITABLE_THREAD_LOCALS = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("inheritableThreadLocals"));
            INHERITEDACCESSCONTROLCONTEXT = UNSAFE.objectFieldOffset
                (tk.getDeclaredField("inheritedAccessControlContext"));
            CONTEXTCLASSLOADER = UNSAFE.objectFieldOffset
                (tk.getDeclaredField("contextClassLoader"));

            long tg = UNSAFE.objectFieldOffset(tk.getDeclaredField("group"));
            long gp = UNSAFE.objectFieldOffset(gk.getDeclaredField("parent"));
            ThreadGroup group = (ThreadGroup)
                UNSAFE.getObject(Thread.currentThread(), tg);

            while (group != null) {
                ThreadGroup parent = (ThreadGroup)UNSAFE.getObject(group, gp);
                if (parent == null)
                    break;
                group = parent;
            }
            final ThreadGroup root = group;
            INNOCUOUSTHREADGROUP = AccessController.doPrivileged(
                new PrivilegedAction<ThreadGroup>() {
                    @Override
                    public ThreadGroup run() {
                        return new ThreadGroup(root, "InnocuousThreadGroup");
                    }
                });
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
