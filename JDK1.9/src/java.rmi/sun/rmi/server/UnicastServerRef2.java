/*
 * Copyright (c) 1997, 2002, Oracle and/or its affiliates. All rights reserved.
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

package sun.rmi.server;

import java.io.ObjectInputFilter;
import java.io.ObjectOutput;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.RemoteRef;

import sun.rmi.transport.LiveRef;

/**
 * Server-side ref for a remote impl that uses a custom socket factory.
 *
 * @author Ann Wollrath
 * @author Roger Riggs
 */
public class UnicastServerRef2 extends UnicastServerRef
{
    // use serialVersionUID from JDK 1.2.2 for interoperability
    private static final long serialVersionUID = -2289703812660767614L;

    /**
     * Create a new (empty) Unicast server remote reference.
     */
    public UnicastServerRef2()
    {}

    /**
     * Construct a Unicast server remote reference for a specified
     * liveRef.
     */
    public UnicastServerRef2(LiveRef ref)
    {
        super(ref);
    }

    /**
     * Construct a Unicast server remote reference for a specified
     * liveRef and filter.
     */
    public UnicastServerRef2(LiveRef ref,
                             ObjectInputFilter filter)
    {
        super(ref, filter);
    }

    /**
     * Construct a Unicast server remote reference to be exported
     * on the specified port.
     */
    public UnicastServerRef2(int port,
                             RMIClientSocketFactory csf,
                             RMIServerSocketFactory ssf)
    {
        super(new LiveRef(port, csf, ssf));
    }

    /**
     * Construct a Unicast server remote reference to be exported
     * on the specified port.
     */
    public UnicastServerRef2(int port,
                             RMIClientSocketFactory csf,
                             RMIServerSocketFactory ssf,
                             ObjectInputFilter filter)
    {
        super(new LiveRef(port, csf, ssf), filter);
    }

    /**
     * Returns the class of the ref type to be serialized
     */
    public String getRefClass(ObjectOutput out)
    {
        return "UnicastServerRef2";
    }

    /**
     * Return the client remote reference for this remoteRef.
     * In the case of a client RemoteRef "this" is the answer.
     * For  a server remote reference, a client side one will have to
     * found or created.
     */
    protected RemoteRef getClientRef() {
        return new UnicastRef2(ref);
    }
}
