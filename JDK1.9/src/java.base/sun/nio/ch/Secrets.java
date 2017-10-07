/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.channels.SocketChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Provides access to implementation private constructors and methods.
 */

public final class Secrets {
    private Secrets() { }

    private static SelectorProvider provider() {
        SelectorProvider p = SelectorProvider.provider();
        if (!(p instanceof SelectorProviderImpl))
            throw new UnsupportedOperationException();
        return p;
    }

    public static SocketChannel newSocketChannel(FileDescriptor fd) {
        try {
            return new SocketChannelImpl(provider(), fd, false);
        } catch (IOException ioe) {
            throw new AssertionError(ioe);
        }
    }

    public static ServerSocketChannel newServerSocketChannel(FileDescriptor fd) {
        try {
            return new ServerSocketChannelImpl(provider(), fd, false);
        } catch (IOException ioe) {
            throw new AssertionError(ioe);
        }
    }
}
