/*
 * Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;

import jdk.internal.access.JavaIOFileDescriptorAccess;
import jdk.internal.access.SharedSecrets;

/**
 * Allows different platforms to call different native methods
 * for read and write operations.
 */

class SocketDispatcher extends NativeDispatcher {
    private static final JavaIOFileDescriptorAccess fdAccess =
            SharedSecrets.getJavaIOFileDescriptorAccess();

    SocketDispatcher() { }

    int read(FileDescriptor fd, long address, int len) throws IOException {
        return read0(fd, address, len);
    }

    long readv(FileDescriptor fd, long address, int len) throws IOException {
        return readv0(fd, address, len);
    }

    int write(FileDescriptor fd, long address, int len) throws IOException {
        return write0(fd, address, len);
    }

    long writev(FileDescriptor fd, long address, int len) throws IOException {
        return writev0(fd, address, len);
    }

    void preClose(FileDescriptor fd) throws IOException {
        throw new UnsupportedOperationException();
    }

    void close(FileDescriptor fd) throws IOException {
        invalidateAndClose(fd);
    }

    static void invalidateAndClose(FileDescriptor fd) throws IOException {
        assert fd.valid();
        int fdVal = fdAccess.get(fd);
        fdAccess.set(fd, -1);
        close0(fdVal);
    }

    // -- Native methods --

    private static native int read0(FileDescriptor fd, long address, int len)
        throws IOException;

    private static native long readv0(FileDescriptor fd, long address, int len)
        throws IOException;

    private static native int write0(FileDescriptor fd, long address, int len)
        throws IOException;

    private static native long writev0(FileDescriptor fd, long address, int len)
        throws IOException;

    private static native void close0(int fdVal) throws IOException;

    static {
        IOUtil.load();
    }
}
