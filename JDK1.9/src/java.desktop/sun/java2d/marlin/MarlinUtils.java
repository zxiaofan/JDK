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

package sun.java2d.marlin;


public final class MarlinUtils {
    // Marlin logger
    private static final sun.util.logging.PlatformLogger LOG;

    static {
        if (MarlinConst.USE_LOGGER) {
            LOG = sun.util.logging.PlatformLogger.getLogger("sun.java2d.marlin");
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
}
