/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package java.rmi.server;

/**
 * The <code>RemoteStub</code> class is the common superclass to client
 * stubs and provides the framework to support a wide range of remote
 * reference semantics.  Stub objects are surrogates that support
 * exactly the same set of remote interfaces defined by the actual
 * implementation of the remote object.
 *
 * @version %I%, %G%
 * @author  Ann Wollrath
 * @since   JDK1.1
 */
abstract public class RemoteStub extends RemoteObject {
    
    /** indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = -1585587260594494182L;
    
    /**
     * Constructs a <code>RemoteStub</code>.
     */
    protected RemoteStub() {
    	super();
    }
    
    /**
     * Constructs a <code>RemoteStub</code>, with the specified remote
     * reference.
     *
     * @param ref the remote reference
     * @since JDK1.1
     */
    protected RemoteStub(RemoteRef ref) {
	super(ref);
    }

    /**
     * Sets the remote reference inside the remote stub.
     *
     * @param stub the remote stub
     * @param ref the remote reference
     * @since JDK1.1
     * @deprecated no replacement.  The <code>setRef</code> method
     * is not needed since <code>RemoteStub</code>s can be created with
     * the <code>RemoteStub(RemoteRef)</code> constructor.
     */
    @Deprecated
    protected static void setRef(RemoteStub stub, RemoteRef ref) {
	throw new UnsupportedOperationException();
    }
}
