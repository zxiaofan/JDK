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

/**
 * MultiplexConnectionInfo groups related information about a
 * virtual connection managed by a ConnectionMultiplexer object.
 *
 * @author Peter Jones
 */
class MultiplexConnectionInfo {

    /** integer that uniquely identifies this connection */
    int id;

    /** input stream for reading from connection */
    MultiplexInputStream in = null;

    /** output stream for writing to connection */
    MultiplexOutputStream out = null;

    /** true if this connection has been closed */
    boolean closed = false;

    /**
     * Create information structure for given connection identifier.
     * @param id connection identifier
     */
    MultiplexConnectionInfo(int id)
    {
        this.id  = id;
    }
}
