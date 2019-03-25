/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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
import java.io.ObjectInput;
import java.io.ObjectOutput;
import sun.rmi.transport.LiveRef;

/**
 * NOTE: There is a JDK-internal dependency on the existence of this
 * class and its getLiveRef method (inherited from UnicastRef) in the
 * implementation of javax.management.remote.rmi.RMIConnector.
 **/
public class UnicastRef2 extends UnicastRef {
    private static final long serialVersionUID = 1829537514995881838L;

    /**
     * Create a new (empty) Unicast remote reference.
     */
    public UnicastRef2()
    {}

    /**
     * Create a new Unicast RemoteRef.
     */
    public UnicastRef2(LiveRef liveRef) {
        super(liveRef);
    }

    /**
     * Returns the class of the ref type to be serialized
     */
    public String getRefClass(ObjectOutput out)
    {
        return "UnicastRef2";
    }

    /**
     * Write out external representation for remote ref.
     */
    public void writeExternal(ObjectOutput out) throws IOException
    {
        ref.write(out, true);
    }

    /**
     * Read in external representation for remote ref.
     * @exception ClassNotFoundException If the class for an object
     * being restored cannot be found.
     */
    public void readExternal(ObjectInput in)
        throws IOException, ClassNotFoundException
    {
        ref = LiveRef.read(in, true);
    }
}
