/*
 * Copyright (c) 1996, Oracle and/or its affiliates. All rights reserved.
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
package sun.rmi.transport.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.rmi.server.RMISocketFactory;

/**
 * RMIDirectSocketFactory creates a direct socket connection to the
 * specified port on the specified host.
 */
public class TCPDirectSocketFactory extends RMISocketFactory {

    public Socket createSocket(String host, int port) throws IOException
    {
        return new Socket(host, port);
    }

    public ServerSocket createServerSocket(int port) throws IOException
    {
        return new ServerSocket(port);
    }
}
