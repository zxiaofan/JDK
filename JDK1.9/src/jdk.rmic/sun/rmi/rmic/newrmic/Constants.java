/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.rmi.rmic.newrmic;

/**
 * Constants potentially useful to all rmic generators.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 *
 * @author Peter Jones
 **/
public final class Constants {

    private Constants() { throw new AssertionError(); }

    /*
     * fully-qualified names of types used by rmic
     */
    public static final String REMOTE = "java.rmi.Remote";
    public static final String EXCEPTION = "java.lang.Exception";
    public static final String REMOTE_EXCEPTION = "java.rmi.RemoteException";
    public static final String RUNTIME_EXCEPTION = "java.lang.RuntimeException";
}
