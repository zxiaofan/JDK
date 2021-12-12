/*
 * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi;

/**
 * A <code>StubNotFoundException</code> is thrown if a valid stub class
 * could not be found for a remote object when it is exported.
 *
 * @author  Roger Riggs
 * @since   1.1
 * @see     java.rmi.server.UnicastRemoteObject
 */
public class StubNotFoundException extends RemoteException {

    /* indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = -7088199405468872373L;

    /**
     * Constructs a <code>StubNotFoundException</code> with the specified
     * detail message.
     *
     * @param s the detail message
     * @since 1.1
     */
    public StubNotFoundException(String s) {
        super(s);
    }

    /**
     * Constructs a <code>StubNotFoundException</code> with the specified
     * detail message and nested exception.
     *
     * @param s the detail message
     * @param ex the nested exception
     * @since 1.1
     */
    public StubNotFoundException(String s, Exception ex) {
        super(s, ex);
    }
}
