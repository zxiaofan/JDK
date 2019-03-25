/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.test;

public final class WhiteBox {

    private static boolean writeAllObjectSamples;

    /**
     * If OldObjectSample event is enabled, calling this method
     * ensures that all object samples are written, including short-lived objects.
     * Purpose of this method is to increase determinism in tests.
     *
     * @param writeAllObjectSamples if all samples should be written or not
     *
     */
    public static void setWriteAllObjectSamples(boolean writeAllSamples) {
        writeAllObjectSamples = writeAllSamples;
    }

    public static boolean getWriteAllObjectSamples() {
        return writeAllObjectSamples;
    }

}
