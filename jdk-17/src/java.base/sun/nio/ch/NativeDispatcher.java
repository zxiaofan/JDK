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

/**
 * Allows different platforms to call different native methods
 * for read and write operations.
 */

abstract class NativeDispatcher {

    abstract int read(FileDescriptor fd, long address, int len)
        throws IOException;

    /**
     * Returns {@code true} if pread/pwrite needs to be synchronized with
     * position sensitive methods.
     */
    boolean needsPositionLock() {
        return false;
    }

    int pread(FileDescriptor fd, long address, int len, long position)
        throws IOException
    {
        throw new IOException("Operation Unsupported");
    }

    abstract long readv(FileDescriptor fd, long address, int len)
        throws IOException;

    abstract int write(FileDescriptor fd, long address, int len)
        throws IOException;

    int pwrite(FileDescriptor fd, long address, int len, long position)
        throws IOException
    {
        throw new IOException("Operation Unsupported");
    }

    abstract long writev(FileDescriptor fd, long address, int len)
        throws IOException;

    abstract void close(FileDescriptor fd) throws IOException;

    // Prepare the given fd for closing by duping it to a known internal fd
    // that's already closed.  This is necessary on some operating systems
    // (Solaris and Linux) to prevent fd recycling.
    //
    void preClose(FileDescriptor fd) throws IOException {
        // Do nothing by default; this is only needed on Unix
    }

    /**
     * Duplicates a file descriptor.
     * @param fd1 the file descriptor to duplicate
     * @param fd2 the new file descriptor, the socket or file that it is connected
     *            to will be closed by this method
     */
    void dup(FileDescriptor fd1, FileDescriptor fd2) throws IOException {
        throw new UnsupportedOperationException();
    }
}
