/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.corba;

import com.sun.corba.se.impl.corba.AnyImpl;
import com.sun.corba.se.impl.encoding.BufferManagerWrite;
import com.sun.corba.se.impl.encoding.CDROutputObject;
import com.sun.corba.se.impl.encoding.EncapsOutputStream;
import com.sun.corba.se.impl.encoding.TypeCodeOutputStream;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import com.sun.corba.se.pept.protocol.MessageMediator;

import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.transport.CorbaConnection;
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;
import com.sun.corba.se.spi.protocol.CorbaMessageMediator;

import java.security.AccessController;
import java.security.PrivilegedAction;

public final class OutputStreamFactory {

    private OutputStreamFactory() {
    }

    public static TypeCodeOutputStream newTypeCodeOutputStream(
            final ORB orb) {
        return AccessController.doPrivileged(
            new PrivilegedAction<TypeCodeOutputStream>() {
                @Override
                public TypeCodeOutputStream run() {
                    return new TypeCodeOutputStream(orb);
                }
        });
    }

    public static TypeCodeOutputStream newTypeCodeOutputStream(
            final ORB orb, final boolean littleEndian) {
        return AccessController.doPrivileged(
            new PrivilegedAction<TypeCodeOutputStream>() {
                @Override
                public TypeCodeOutputStream run() {
                    return new TypeCodeOutputStream(orb, littleEndian);
                }
        });
    }

    public static EncapsOutputStream newEncapsOutputStream(
            final ORB orb) {
        return AccessController.doPrivileged(
            new PrivilegedAction<EncapsOutputStream>() {
                @Override
                public EncapsOutputStream run() {
                    return new EncapsOutputStream(
                        (com.sun.corba.se.spi.orb.ORB)orb);
                }
        });
    }

    public static EncapsOutputStream newEncapsOutputStream(
            final ORB orb, final GIOPVersion giopVersion) {
        return AccessController.doPrivileged(
            new PrivilegedAction<EncapsOutputStream>() {
                @Override
                public EncapsOutputStream run() {
                    return new EncapsOutputStream(
                        (com.sun.corba.se.spi.orb.ORB)orb, giopVersion);
                }
        });
    }

    public static EncapsOutputStream newEncapsOutputStream(
            final ORB orb, final boolean isLittleEndian) {
        return AccessController.doPrivileged(
            new PrivilegedAction<EncapsOutputStream>() {
                @Override
                public EncapsOutputStream run() {
                    return new EncapsOutputStream(
                        (com.sun.corba.se.spi.orb.ORB)orb, isLittleEndian);
                }
        });
    }

    public static CDROutputObject newCDROutputObject(
            final ORB orb, final MessageMediator messageMediator,
            final Message header, final byte streamFormatVersion) {
        return AccessController.doPrivileged(
            new PrivilegedAction<CDROutputObject>() {
                @Override
                public CDROutputObject run() {
                    return new CDROutputObject(orb, messageMediator,
                        header, streamFormatVersion);
                }
        });
    }

    public static CDROutputObject newCDROutputObject(
            final ORB orb, final MessageMediator messageMediator,
            final Message header, final byte streamFormatVersion,
            final int strategy) {
        return AccessController.doPrivileged(
            new PrivilegedAction<CDROutputObject>() {
                @Override
                public CDROutputObject run() {
                    return new CDROutputObject(orb, messageMediator,
                        header, streamFormatVersion, strategy);
                }
        });
    }

    public static CDROutputObject newCDROutputObject(
            final ORB orb, final CorbaMessageMediator mediator,
            final GIOPVersion giopVersion, final CorbaConnection connection,
            final Message header, final byte streamFormatVersion) {
        return AccessController.doPrivileged(
            new PrivilegedAction<CDROutputObject>() {
                @Override
                public CDROutputObject run() {
                    return new CDROutputObject(orb, mediator,
                        giopVersion, connection, header, streamFormatVersion);
                }
        });
    }

}
