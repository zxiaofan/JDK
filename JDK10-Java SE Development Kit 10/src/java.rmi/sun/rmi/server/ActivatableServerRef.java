/*
 * Copyright (c) 1997, 2003, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutput;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.activation.ActivationID;
import sun.rmi.transport.LiveRef;

/**
 * Server-side ref for a persistent remote impl.
 *
 * @author Ann Wollrath
 */
public class ActivatableServerRef extends UnicastServerRef2 {

    private static final long serialVersionUID = 2002967993223003793L;

    private ActivationID id;

    /**
     * Construct a Unicast server remote reference to be exported
     * on the specified port.
     */
    public ActivatableServerRef(ActivationID id, int port)
    {
        this(id, port, null, null);
    }

    /**
     * Construct a Unicast server remote reference to be exported
     * on the specified port.
     */
    public ActivatableServerRef(ActivationID id, int port,
                                RMIClientSocketFactory csf,
                                RMIServerSocketFactory ssf)
    {
        super(new LiveRef(port, csf, ssf));
        this.id = id;
    }

    /**
     * Returns the class of the ref type to be serialized
     */
    public String getRefClass(ObjectOutput out)
    {
        return "ActivatableServerRef";
    }

    /**
     * Return the client remote reference for this remoteRef.
     * In the case of a client RemoteRef "this" is the answer.
     * For  a server remote reference, a client side one will have to
     * found or created.
     */
    protected RemoteRef getClientRef() {
        return new ActivatableRef(id, new UnicastRef2(ref));
    }

    /**
     * Prevents serialization (because deserializaion is impossible).
     */
    public void writeExternal(ObjectOutput out) throws IOException {
        throw new NotSerializableException(
            "ActivatableServerRef not serializable");
    }
}
