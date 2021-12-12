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
 * An <code>AccessException</code> is thrown by certain methods of the
 * <code>java.rmi.Naming</code> class (specifically <code>bind</code>,
 * <code>rebind</code>, and <code>unbind</code>) to
 * indicate that the caller does not have permission to perform the action
 * requested by the method call.  If the method was invoked from a non-local
 * host, then an <code>AccessException</code> is thrown.
 *
 * @author  Ann Wollrath
 * @author  Roger Riggs
 * @since   1.1
 * @see     java.rmi.Naming
 */
public class AccessException extends java.rmi.RemoteException {

    /* indicate compatibility with JDK 1.1.x version of class */
     private static final long serialVersionUID = 6314925228044966088L;

    /**
     * Constructs an <code>AccessException</code> with the specified
     * detail message.
     *
     * @param s the detail message
     * @since 1.1
     */
    public AccessException(String s) {
        super(s);
    }

    /**
     * Constructs an <code>AccessException</code> with the specified
     * detail message and nested exception.
     *
     * @param s the detail message
     * @param ex the nested exception
     * @since 1.1
     */
    public AccessException(String s, Exception ex) {
        super(s, ex);
    }
}
