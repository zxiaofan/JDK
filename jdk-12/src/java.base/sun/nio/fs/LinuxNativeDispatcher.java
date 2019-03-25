/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.fs;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Linux specific system calls.
 */

class LinuxNativeDispatcher extends UnixNativeDispatcher {
    private LinuxNativeDispatcher() { }

   /**
    * FILE *setmntent(const char *filename, const char *type);
    */
    static long setmntent(byte[] filename, byte[] type) throws UnixException {
        NativeBuffer pathBuffer = NativeBuffers.asNativeBuffer(filename);
        NativeBuffer typeBuffer = NativeBuffers.asNativeBuffer(type);
        try {
            return setmntent0(pathBuffer.address(), typeBuffer.address());
        } finally {
            typeBuffer.release();
            pathBuffer.release();
        }
    }
    private static native long setmntent0(long pathAddress, long typeAddress)
        throws UnixException;

    /**
     * int getmntent(FILE *fp, struct mnttab *mp, int len);
     */
    static native int getmntent(long fp, UnixMountEntry entry)
        throws UnixException;

    /**
     * int endmntent(FILE* filep);
     */
    static native void endmntent(long stream) throws UnixException;

    /**
     * ssize_t fgetxattr(int filedes, const char *name, void *value, size_t size);
     */
    static int fgetxattr(int filedes, byte[] name, long valueAddress,
                         int valueLen) throws UnixException
    {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(name);
        try {
            return fgetxattr0(filedes, buffer.address(), valueAddress, valueLen);
        } finally {
            buffer.release();
        }
    }

    private static native int fgetxattr0(int filedes, long nameAddress,
        long valueAddress, int valueLen) throws UnixException;

    /**
     *  fsetxattr(int filedes, const char *name, const void *value, size_t size, int flags);
     */
    static void fsetxattr(int filedes, byte[] name, long valueAddress,
        int valueLen) throws UnixException
    {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(name);
        try {
            fsetxattr0(filedes, buffer.address(), valueAddress, valueLen);
        } finally {
            buffer.release();
        }
    }

    private static native void fsetxattr0(int filedes, long nameAddress,
        long valueAddress, int valueLen) throws UnixException;

    /**
     * fremovexattr(int filedes, const char *name);
     */
    static void fremovexattr(int filedes, byte[] name) throws UnixException {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(name);
        try {
            fremovexattr0(filedes, buffer.address());
        } finally {
            buffer.release();
        }
    }

    private static native void fremovexattr0(int filedes, long nameAddress)
        throws UnixException;

    /**
     * size_t flistxattr(int filedes, const char *list, size_t size)
     */
    static native int flistxattr(int filedes, long listAddress, int size)
        throws UnixException;

    // initialize
    private static native void init();

    static {
        AccessController.doPrivileged(new PrivilegedAction<>() {
            public Void run() {
                System.loadLibrary("nio");
                return null;
        }});
        init();
    }
}
