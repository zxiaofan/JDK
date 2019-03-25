/*
 * Copyright (c) 2009, 2010, Oracle and/or its affiliates. All rights reserved.
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
 * Defines static methods to be invoked prior to binding or connecting TCP sockets.
 */

public final class NetHooks {

    /**
     * A provider with hooks to allow sockets be converted prior to binding or
     * connecting a TCP socket.
     *
     * <p> Concrete implementations of this class should define a zero-argument
     * constructor and implement the abstract methods specified below.
     */
    public abstract static class Provider {
        /**
         * Initializes a new instance of this class.
         */
        protected Provider() {}

        /**
         * Invoked prior to binding a TCP socket.
         */
        public abstract void implBeforeTcpBind(FileDescriptor fdObj,
                                               InetAddress address,
                                               int port)
            throws IOException;

        /**
         * Invoked prior to connecting an unbound TCP socket.
         */
        public abstract void implBeforeTcpConnect(FileDescriptor fdObj,
                                                 InetAddress address,
                                                 int port)
            throws IOException;
    }

    /**
     * For now, we load the SDP provider on Solaris. In the future this may
     * be changed to use the ServiceLoader facility to allow the deployment of
     * other providers.
     */
    private static final Provider provider = new sun.net.sdp.SdpProvider();

    /**
     * Invoke prior to binding a TCP socket.
     */
    public static void beforeTcpBind(FileDescriptor fdObj,
                                     InetAddress address,
                                     int port)
        throws IOException
    {
        provider.implBeforeTcpBind(fdObj, address, port);
    }

    /**
     * Invoke prior to connecting an unbound TCP socket.
     */
    public static void beforeTcpConnect(FileDescriptor fdObj,
                                        InetAddress address,
                                        int port)
        throws IOException
    {
        provider.implBeforeTcpConnect(fdObj, address, port);
    }
}
