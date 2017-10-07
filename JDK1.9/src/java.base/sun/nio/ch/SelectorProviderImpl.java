/*
 * Copyright (c) 2000, 2008, Oracle and/or its affiliates. All rights reserved.
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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ProtocolFamily;
import java.nio.channels.*;
import java.nio.channels.spi.*;


public abstract class SelectorProviderImpl
    extends SelectorProvider
{

    public DatagramChannel openDatagramChannel() throws IOException {
        return new DatagramChannelImpl(this);
    }

    public DatagramChannel openDatagramChannel(ProtocolFamily family) throws IOException {
        return new DatagramChannelImpl(this, family);
    }

    public Pipe openPipe() throws IOException {
        return new PipeImpl(this);
    }

    public abstract AbstractSelector openSelector() throws IOException;

    public ServerSocketChannel openServerSocketChannel() throws IOException {
        return new ServerSocketChannelImpl(this);
    }

    public SocketChannel openSocketChannel() throws IOException {
        return new SocketChannelImpl(this);
    }
}
