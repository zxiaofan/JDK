/*
 * Copyright (c) 2006, 2020, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Arrays;

/**
 * Contains Elliptic Curve parameters.
 *
 * @since   1.6
 * @author  Andreas Sterbenz
 */
public final class NamedCurve extends ECParameterSpec {

    // friendly names with stdName followed by aliases
    private final String[] nameAndAliases;

    // well known OID
    private final String oid;

    // encoded form (as NamedCurve identified via OID)
    private final byte[] encoded;

    NamedCurve(KnownOIDs ko, EllipticCurve curve,
            ECPoint g, BigInteger n, int h) {
        super(curve, g, n, h);
        String[] aliases = ko.aliases();
        this.nameAndAliases = new String[aliases.length + 1];
        nameAndAliases[0] = ko.stdName();
        System.arraycopy(aliases, 0, nameAndAliases, 1, aliases.length);

        this.oid = ko.value();

        DerOutputStream out = new DerOutputStream();
        try {
            out.putOID(ObjectIdentifier.of(ko));
        } catch (IOException e) {
            throw new RuntimeException("Internal error", e);
        }
        encoded = out.toByteArray();
    }

    // returns the curve's standard name followed by its aliases
    public String[] getNameAndAliases() {
        return nameAndAliases;
    }

    public byte[] getEncoded() {
        return encoded.clone();
    }

    public String getObjectId() {
        return oid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(nameAndAliases[0]);
        if (nameAndAliases.length > 1) {
            sb.append(" [");
            int j = 1;
            while (j < nameAndAliases.length - 1) {
                sb.append(nameAndAliases[j++]);
                sb.append(',');
            }
            sb.append(nameAndAliases[j] + "]");
        }
        sb.append(" (" + oid + ")");
        return sb.toString();
    }
}
