/*
 * Copyright (c) 2002, 2005, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d;

/**
 * This class is the default DisposerRecord implementation which
 * holds pointers to the native disposal method and the data to be disposed.
 */
public class DefaultDisposerRecord implements DisposerRecord {
    private long dataPointer;
    private long disposerMethodPointer;

    public DefaultDisposerRecord(long  disposerMethodPointer, long dataPointer) {
        this.disposerMethodPointer = disposerMethodPointer;
        this.dataPointer = dataPointer;
    }

    public void dispose() {
        invokeNativeDispose(disposerMethodPointer,
                            dataPointer);
    }

    public long getDataPointer() {
        return dataPointer;
    }

    public long getDisposerMethodPointer() {
        return disposerMethodPointer;
    }

    public static native void invokeNativeDispose(long disposerMethodPointer,
                                                  long dataPointer);
}
