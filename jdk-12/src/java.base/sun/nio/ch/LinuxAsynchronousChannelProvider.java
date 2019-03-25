/*
 * Copyright (c) 2008, 2010, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.channels.*;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.io.IOException;

public class LinuxAsynchronousChannelProvider
    extends AsynchronousChannelProvider
{
    private static volatile EPollPort defaultPort;

    private EPollPort defaultEventPort() throws IOException {
        if (defaultPort == null) {
            synchronized (LinuxAsynchronousChannelProvider.class) {
                if (defaultPort == null) {
                    defaultPort = new EPollPort(this, ThreadPool.getDefault()).start();
                }
            }
        }
        return defaultPort;
    }

    public LinuxAsynchronousChannelProvider() {
    }

    @Override
    public AsynchronousChannelGroup openAsynchronousChannelGroup(int nThreads, ThreadFactory factory)
        throws IOException
    {
        return new EPollPort(this, ThreadPool.create(nThreads, factory)).start();
    }

    @Override
    public AsynchronousChannelGroup openAsynchronousChannelGroup(ExecutorService executor, int initialSize)
        throws IOException
    {
        return new EPollPort(this, ThreadPool.wrap(executor, initialSize)).start();
    }

    private Port toPort(AsynchronousChannelGroup group) throws IOException {
        if (group == null) {
            return defaultEventPort();
        } else {
            if (!(group instanceof EPollPort))
                throw new IllegalChannelGroupException();
            return (Port)group;
        }
    }

    @Override
    public AsynchronousServerSocketChannel openAsynchronousServerSocketChannel(AsynchronousChannelGroup group)
        throws IOException
    {
        return new UnixAsynchronousServerSocketChannelImpl(toPort(group));
    }

    @Override
    public AsynchronousSocketChannel openAsynchronousSocketChannel(AsynchronousChannelGroup group)
        throws IOException
    {
        return new UnixAsynchronousSocketChannelImpl(toPort(group));
    }
}
