/*
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.ref;

import jdk.internal.misc.InnocuousThread;

import java.lang.ref.Cleaner;
import java.util.concurrent.ThreadFactory;

/**
 * CleanerFactory provides a Cleaner for use within system modules.
 * The cleaner is created on the first reference to the CleanerFactory.
 */
public final class CleanerFactory {

    /* The common Cleaner. */
    private static final Cleaner commonCleaner = Cleaner.create(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return InnocuousThread.newSystemThread("Common-Cleaner",
                    r, Thread.MAX_PRIORITY - 2);
        }
    });

    /**
     * Cleaner for use within system modules.
     *
     * This Cleaner will run on a thread whose context class loader
     * is {@code null}. The system cleaning action to perform in
     * this Cleaner should handle a {@code null} context class loader.
     *
     * @return a Cleaner for use within system modules
     */
    public static Cleaner cleaner() {
        return commonCleaner;
    }
}
