/*
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.remote.protocol.iiop;

import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.Delegate;
import javax.rmi.PortableRemoteObject;
import javax.rmi.CORBA.Stub;

import java.util.Properties;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.NoSuchObjectException;

import com.sun.jmx.remote.internal.IIOPProxy;

/**
 * An implementatin of IIOPProxy that simply delegates to the appropriate
 * RMI-IIOP and CORBA APIs.
 */

public class IIOPProxyImpl implements IIOPProxy {
    public IIOPProxyImpl() { }

    @Override
    public boolean isStub(Object obj) {
        return (obj instanceof Stub);
    }

    @Override
    public Object getDelegate(Object stub) {
        return ((Stub)stub)._get_delegate();
    }

    @Override
    public void setDelegate(Object stub, Object delegate) {
        ((Stub)stub)._set_delegate((Delegate)delegate);
    }

    @Override
    public Object getOrb(Object stub) {
        try {
            return ((Stub)stub)._orb();
        } catch (org.omg.CORBA.BAD_OPERATION x) {
            throw new UnsupportedOperationException(x);
        }
    }

    @Override
    public void connect(Object stub, Object orb)
        throws RemoteException
    {
        ((Stub)stub).connect((ORB)orb);
    }

    @Override
    public boolean isOrb(Object obj) {
        return (obj instanceof ORB);
    }

    @Override
    public Object createOrb(String[] args, Properties props) {
        return ORB.init(args, props);
    }

    @Override
    public Object stringToObject(Object orb, String str) {
        return ((ORB)orb).string_to_object(str);
    }

    @Override
    public String objectToString(Object orb, Object obj) {
        return ((ORB)orb).object_to_string((org.omg.CORBA.Object)obj);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T narrow(Object narrowFrom, Class<T> narrowTo) {
        return (T)PortableRemoteObject.narrow(narrowFrom, narrowTo);
    }

    @Override
    public void exportObject(Remote obj) throws RemoteException {
        PortableRemoteObject.exportObject(obj);
    }

    @Override
    public void unexportObject(Remote obj) throws NoSuchObjectException {
        PortableRemoteObject.unexportObject(obj);
    }

    @Override
    public Remote toStub(Remote obj) throws NoSuchObjectException {
        return PortableRemoteObject.toStub(obj);
    }
}
