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

package sun.rmi.rmic.newrmic.jrmp;

/**
 * Constants specific to the JRMP rmic generator.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 *
 * @author Peter Jones
 **/
final class Constants {

    private Constants() { throw new AssertionError(); }

    /*
     * fully-qualified names of types used by rmic
     */
    static final String REMOTE_OBJECT = "java.rmi.server.RemoteObject";
    static final String REMOTE_STUB = "java.rmi.server.RemoteStub";
    static final String REMOTE_REF = "java.rmi.server.RemoteRef";
    static final String OPERATION = "java.rmi.server.Operation";
    static final String SKELETON = "java.rmi.server.Skeleton";
    static final String SKELETON_MISMATCH_EXCEPTION =
        "java.rmi.server.SkeletonMismatchException";
    static final String REMOTE_CALL = "java.rmi.server.RemoteCall";
    static final String MARSHAL_EXCEPTION = "java.rmi.MarshalException";
    static final String UNMARSHAL_EXCEPTION = "java.rmi.UnmarshalException";
    static final String UNEXPECTED_EXCEPTION = "java.rmi.UnexpectedException";

    /*
     * stub protocol versions
     */
    enum StubVersion { V1_1, VCOMPAT, V1_2 };

    /*
     * serialVersionUID for all stubs that can use 1.2 protocol
     */
    static final long STUB_SERIAL_VERSION_UID = 2;

    /*
     * version number used to seed interface hash computation
     */
    static final int INTERFACE_HASH_STUB_VERSION = 1;
}
