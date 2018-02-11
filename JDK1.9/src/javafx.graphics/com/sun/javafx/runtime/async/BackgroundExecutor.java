/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.runtime.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorSingleton
 *
 */
public class BackgroundExecutor {
    private static ExecutorService instance;
    private static ScheduledExecutorService timerInstance;

    private BackgroundExecutor() {
        // not instantiable
    }

    public static synchronized ExecutorService getExecutor() {
        if (instance == null) {
            instance = Executors.newCachedThreadPool(r -> {
                Thread t = new Thread(r);
                t.setPriority(Thread.MIN_PRIORITY);
                return t;
            });
            ((ThreadPoolExecutor) instance).setKeepAliveTime(1, TimeUnit.SECONDS);
        }

        return instance;
    }

    public static synchronized ScheduledExecutorService getTimer() {
        if (timerInstance == null) {
            // @@@ Here's where we load the configuration and such
            timerInstance = new ScheduledThreadPoolExecutor(1,
                    r -> {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }
            );
        }

        return timerInstance;
    }

    private static synchronized void shutdown() {
        if (instance != null) {
            instance.shutdown();
            instance = null;
        }
        if (timerInstance != null) {
            timerInstance.shutdown();
            timerInstance= null;
        }
    }
}
