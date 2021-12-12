/*
 * Copyright (c) 1996, 2003, Oracle and/or its affiliates. All rights reserved.
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
package sun.rmi.transport;

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.ObjID;
import java.rmi.server.RemoteServer;

public interface Endpoint {
    /**
     * Return a channel that generates connections to the remote
     * endpoint.
     */
    Channel getChannel();

    /**
     * Export the object so that it can accept incoming calls at
     * the endpoint.
     */
    void exportObject(Target target)
        throws RemoteException;

    /**
     * Returns the transport for incoming connections to this endpoint.
     **/
    Transport getInboundTransport();

    /**
     * Returns transport for making connections to remote endpoints.
     **/
    Transport getOutboundTransport();
}
