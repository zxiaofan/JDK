/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.pipe;

import java.lang.reflect.Constructor;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.ThreadFactory;

/**
 * Simple utility class to instantiate correct Thread instance
 * depending on Java version.
 *
 * @author miroslav.kos@oracle.com
 */
final class ThreadHelper {

    private static final String SAFE_THREAD_NAME = "sun.misc.ManagedLocalsThread";

    private static final ThreadFactory threadFactory;

    // no instantiating wanted
    private ThreadHelper() {
    }

    static {
        threadFactory = AccessController.doPrivileged(
                new PrivilegedAction<ThreadFactory> () {
                    @Override
                    public ThreadFactory run() {
                        // In order of preference
                        try {
                            try {
                                Class<Thread> cls = Thread.class;
                                Constructor<Thread> ctr = cls.getConstructor(
                                        ThreadGroup.class,
                                        Runnable.class,
                                        String.class,
                                        long.class,
                                        boolean.class);
                                return new JDK9ThreadFactory(ctr);
                            } catch (NoSuchMethodException ignored) {
                                // constructor newly added in Java SE 9
                            }
                            Class<?> cls = Class.forName(SAFE_THREAD_NAME);
                            Constructor<?> ctr = cls.getConstructor(Runnable.class);
                            return new SunMiscThreadFactory(ctr);
                        } catch (ClassNotFoundException | NoSuchMethodException ignored) {}
                        return new LegacyThreadFactory();
                    }
                }
        );
    }

    static Thread createNewThread(final Runnable r) {
        return threadFactory.newThread(r);
    }

    // A Thread factory backed by the Thread constructor that
    // suppresses inheriting of inheritable thread-locals.
    private static class JDK9ThreadFactory implements ThreadFactory {
        final Constructor<Thread> ctr;
        JDK9ThreadFactory(Constructor<Thread> ctr) { this.ctr = ctr; }
        @Override public Thread newThread(Runnable r) {
            try {
                return ctr.newInstance(null, r, "toBeReplaced", 0, false);
            } catch (ReflectiveOperationException x) {
                InternalError ie = new InternalError(x.getMessage());
                ie.initCause(ie);
                throw ie;
            }
        }
    }

    // A Thread factory backed by sun.misc.ManagedLocalsThread
    private static class SunMiscThreadFactory implements ThreadFactory {
        final Constructor<?> ctr;
        SunMiscThreadFactory(Constructor<?> ctr) { this.ctr = ctr; }
        @Override public Thread newThread(final Runnable r) {
            return AccessController.doPrivileged(
                    new PrivilegedAction<Thread>() {
                        @Override
                        public Thread run() {
                            try {
                                return (Thread) ctr.newInstance(r);
                            } catch (Exception e) {
                                return new Thread(r);
                            }
                        }
                    }
            );
        }
    }

    // A Thread factory backed by new Thread(Runnable)
    private static class LegacyThreadFactory implements ThreadFactory {
        @Override public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }
}
