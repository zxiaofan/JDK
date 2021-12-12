/*
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
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
package sun.net;

import java.net.InetAddress;
import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Defines static methods to ensure that any installed net hooks are invoked
 * prior to binding or connecting TCP sockets.
 */

public final class NetHooks {

    /**
     * Invoke prior to binding a TCP socket.
     */
    public static void beforeTcpBind(FileDescriptor fdObj,
                                     InetAddress address,
                                     int port)
        throws IOException
    {
        // nothing to do
    }

    /**
     * Invoke prior to connecting an unbound TCP socket.
     */
    public static void beforeTcpConnect(FileDescriptor fdObj,
                                        InetAddress address,
                                        int port)
        throws IOException
    {
        // nothing to do
    }
}
