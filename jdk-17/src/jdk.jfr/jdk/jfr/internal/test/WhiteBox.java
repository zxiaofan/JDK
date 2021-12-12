/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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
    private static boolean skipBFS;

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

    /**
     * If OldObjectSample event is enabled, calling this method
     * ensures that BFS is not used when searching for path to GC root.
     * Purpose of this method is to trigger code paths that are
     * hard to provoke reliably in testing.
     *
     * @param skipBFS if only DFS should be used
     */
    public static void setSkipBFS(boolean skip) {
        skipBFS = skip;
    }

    public static boolean getSkipBFS() {
        return skipBFS;
    }
}
