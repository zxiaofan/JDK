/*
 * Copyright (c) 2006, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.util;

import java.io.IOException;
import java.math.BigInteger;

import java.security.spec.*;


/**
 * Contains Elliptic Curve parameters.
 *
 * @since   1.6
 * @author  Andreas Sterbenz
 */
public final class NamedCurve extends ECParameterSpec {

    // friendly name for toString() output
    private final String name;

    // well known OID
    private final String oid;

    // encoded form (as NamedCurve identified via OID)
    private final byte[] encoded;

    NamedCurve(String name, String oid, EllipticCurve curve,
            ECPoint g, BigInteger n, int h) {
        super(curve, g, n, h);
        this.name = name;
        this.oid = oid;

        DerOutputStream out = new DerOutputStream();

        try {
            out.putOID(new ObjectIdentifier(oid));
        } catch (IOException e) {
            throw new RuntimeException("Internal error", e);
        }

        encoded = out.toByteArray();
    }

    public String getName() {
        return name;
    }

    public byte[] getEncoded() {
        return encoded.clone();
    }

    public String getObjectId() {
        return oid;
    }

    public String toString() {
        return name + " (" + oid + ")";
    }
}
