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

package com.sun.marlin;

public final class MarlinUtils {
    // Marlin logger
    private static final sun.util.logging.PlatformLogger LOG;

    static {
        if (MarlinConst.USE_LOGGER) {
            LOG = sun.util.logging.PlatformLogger.getLogger("prism.marlin");
        } else {
            LOG = null;
        }
    }

    private MarlinUtils() {
        // no-op
    }

    public static void logInfo(final String msg) {
        if (MarlinConst.USE_LOGGER) {
            LOG.info(msg);
        } else if (MarlinConst.ENABLE_LOGS) {
            System.out.print("INFO: ");
            System.out.println(msg);
        }
    }

    public static void logException(final String msg, final Throwable th) {
        if (MarlinConst.USE_LOGGER) {
            LOG.warning(msg, th);
        } else if (MarlinConst.ENABLE_LOGS) {
            System.out.print("WARNING: ");
            System.out.println(msg);
            th.printStackTrace(System.err);
        }
    }

    // From sun.awt.util.ThreadGroupUtils

    /**
     * Returns a root thread group.
     * Should be called with {@link sun.security.util.SecurityConstants#MODIFY_THREADGROUP_PERMISSION}
     *
     * @return a root {@code ThreadGroup}
     */
    public static ThreadGroup getRootThreadGroup() {
        ThreadGroup currentTG = Thread.currentThread().getThreadGroup();
        ThreadGroup parentTG = currentTG.getParent();
        while (parentTG != null) {
            currentTG = parentTG;
            parentTG = currentTG.getParent();
        }
        return currentTG;
    }

    // JavaFX specific Cleaner for Marlin-FX:
    // Module issue with jdk.internal.ref.Cleaner
    private final static java.lang.ref.Cleaner cleaner
        = java.lang.ref.Cleaner.create();

    static java.lang.ref.Cleaner getCleaner() {
        return cleaner;
    }
/*
    static jdk.internal.ref.Cleaner getCleaner() {
        return jdk.internal.ref.CleanerFactory.cleaner();
    }
*/
}
