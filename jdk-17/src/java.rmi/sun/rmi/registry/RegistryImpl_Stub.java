/*
 * Copyright (c) 2017, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.rmi.registry;

import java.io.IOException;

import sun.rmi.transport.StreamRemoteCall;

/**
 * Stubs to invoke RegistryImpl remote methods.
 * Originally generated from RMIC but frozen to match RegistryImpl_Skel.
 */
@SuppressWarnings({"deprecation", "serial"})
public final class RegistryImpl_Stub
        extends java.rmi.server.RemoteStub
        implements java.rmi.registry.Registry, java.rmi.Remote {
    private static final java.rmi.server.Operation[] operations = {
            new java.rmi.server.Operation("void bind(java.lang.String, java.rmi.Remote)"),
            new java.rmi.server.Operation("java.lang.String list()[]"),
            new java.rmi.server.Operation("java.rmi.Remote lookup(java.lang.String)"),
            new java.rmi.server.Operation("void rebind(java.lang.String, java.rmi.Remote)"),
            new java.rmi.server.Operation("void unbind(java.lang.String)")
    };

    private static final long interfaceHash = 4905912898345647071L;

    // constructors
    public RegistryImpl_Stub() {
        super();
    }

    public RegistryImpl_Stub(java.rmi.server.RemoteRef ref) {
        super(ref);
    }

    // methods from remote interfaces

    // implementation of bind(String, Remote)
    public void bind(java.lang.String $param_String_1, java.rmi.Remote $param_Remote_2)
            throws java.rmi.AccessException, java.rmi.AlreadyBoundException, java.rmi.RemoteException {
        try {
            StreamRemoteCall call = (StreamRemoteCall)ref.newCall(this, operations, 0, interfaceHash);
            try {
                java.io.ObjectOutput out = call.getOutputStream();
                out.writeObject($param_String_1);
                out.writeObject($param_Remote_2);
            } catch (java.io.IOException e) {
                throw new java.rmi.MarshalException("error marshalling arguments", e);
            }
            ref.invoke(call);
            ref.done(call);
        } catch (java.lang.RuntimeException e) {
            throw e;
        } catch (java.rmi.RemoteException e) {
            throw e;
        } catch (java.rmi.AlreadyBoundException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new java.rmi.UnexpectedException("undeclared checked exception", e);
        }
    }

    // implementation of list()
    public java.lang.String[] list()
            throws java.rmi.AccessException, java.rmi.RemoteException {
        try {
            StreamRemoteCall call = (StreamRemoteCall)ref.newCall(this, operations, 1, interfaceHash);
            ref.invoke(call);
            java.lang.String[] $result;
            try {
                java.io.ObjectInput in = call.getInputStream();
                $result = (java.lang.String[]) in.readObject();
            } catch (ClassCastException | IOException | ClassNotFoundException e) {
                call.discardPendingRefs();
                throw new java.rmi.UnmarshalException("error unmarshalling return", e);
            } finally {
                ref.done(call);
            }
            return $result;
        } catch (java.lang.RuntimeException e) {
            throw e;
        } catch (java.rmi.RemoteException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new java.rmi.UnexpectedException("undeclared checked exception", e);
        }
    }

    // implementation of lookup(String)
    public java.rmi.Remote lookup(java.lang.String $param_String_1)
            throws java.rmi.AccessException, java.rmi.NotBoundException, java.rmi.RemoteException {
        try {
            StreamRemoteCall call = (StreamRemoteCall)ref.newCall(this, operations, 2, interfaceHash);
            try {
                java.io.ObjectOutput out = call.getOutputStream();
                out.writeObject($param_String_1);
            } catch (java.io.IOException e) {
                throw new java.rmi.MarshalException("error marshalling arguments", e);
            }
            ref.invoke(call);
            java.rmi.Remote $result;
            try {
                java.io.ObjectInput in = call.getInputStream();
                $result = (java.rmi.Remote) in.readObject();
            } catch (ClassCastException | IOException | ClassNotFoundException e) {
                call.discardPendingRefs();
                throw new java.rmi.UnmarshalException("error unmarshalling return", e);
            } finally {
                ref.done(call);
            }
            return $result;
        } catch (java.lang.RuntimeException e) {
            throw e;
        } catch (java.rmi.RemoteException e) {
            throw e;
        } catch (java.rmi.NotBoundException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new java.rmi.UnexpectedException("undeclared checked exception", e);
        }
    }

    // implementation of rebind(String, Remote)
    public void rebind(java.lang.String $param_String_1, java.rmi.Remote $param_Remote_2)
            throws java.rmi.AccessException, java.rmi.RemoteException {
        try {
            StreamRemoteCall call = (StreamRemoteCall)ref.newCall(this, operations, 3, interfaceHash);
            try {
                java.io.ObjectOutput out = call.getOutputStream();
                out.writeObject($param_String_1);
                out.writeObject($param_Remote_2);
            } catch (java.io.IOException e) {
                throw new java.rmi.MarshalException("error marshalling arguments", e);
            }
            ref.invoke(call);
            ref.done(call);
        } catch (java.lang.RuntimeException e) {
            throw e;
        } catch (java.rmi.RemoteException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new java.rmi.UnexpectedException("undeclared checked exception", e);
        }
    }

    // implementation of unbind(String)
    public void unbind(java.lang.String $param_String_1)
            throws java.rmi.AccessException, java.rmi.NotBoundException, java.rmi.RemoteException {
        try {
            StreamRemoteCall call = (StreamRemoteCall)ref.newCall(this, operations, 4, interfaceHash);
            try {
                java.io.ObjectOutput out = call.getOutputStream();
                out.writeObject($param_String_1);
            } catch (java.io.IOException e) {
                throw new java.rmi.MarshalException("error marshalling arguments", e);
            }
            ref.invoke(call);
            ref.done(call);
        } catch (java.lang.RuntimeException e) {
            throw e;
        } catch (java.rmi.RemoteException e) {
            throw e;
        } catch (java.rmi.NotBoundException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new java.rmi.UnexpectedException("undeclared checked exception", e);
        }
    }
}
