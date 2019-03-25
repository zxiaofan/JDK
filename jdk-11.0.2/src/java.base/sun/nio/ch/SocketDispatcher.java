/*
 * Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.
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

class SocketDispatcher extends NativeDispatcher {

    int read(FileDescriptor fd, long address, int len) throws IOException {
        return FileDispatcherImpl.read0(fd, address, len);
    }

    long readv(FileDescriptor fd, long address, int len) throws IOException {
        return FileDispatcherImpl.readv0(fd, address, len);
    }

    int write(FileDescriptor fd, long address, int len) throws IOException {
        return FileDispatcherImpl.write0(fd, address, len);
    }

    long writev(FileDescriptor fd, long address, int len) throws IOException {
        return FileDispatcherImpl.writev0(fd, address, len);
    }

    void close(FileDescriptor fd) throws IOException {
        FileDispatcherImpl.close0(fd);
    }

    void preClose(FileDescriptor fd) throws IOException {
        FileDispatcherImpl.preClose0(fd);
    }
}
