/*
 * Copyright (c) 1997, Oracle and/or its affiliates. All rights reserved.
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
package sun.security.x509;

import java.io.IOException;
import java.math.BigInteger;

import sun.security.util.HexDumpEncoder;
import sun.security.util.*;

/**
 * This class defines the UniqueIdentity class used by certificates.
 *
 * @author Amit Kapoor
 * @author Hemma Prafullchandra
 */
public class UniqueIdentity {
    // Private data members
    private BitArray    id;

    /**
     * The default constructor for this class.
     *
     * @param id the byte array containing the unique identifier.
     */
    public UniqueIdentity(BitArray id) {
        this.id = id;
    }

    /**
     * The default constructor for this class.
     *
     * @param id the byte array containing the unique identifier.
     */
    public UniqueIdentity(byte[] id) {
        this.id = new BitArray(id.length*8, id);
    }

    /**
     * Create the object, decoding the values from the passed DER stream.
     *
     * @param in the DerInputStream to read the UniqueIdentity from.
     * @exception IOException on decoding errors.
     */
    public UniqueIdentity(DerInputStream in) throws IOException {
        DerValue derVal = in.getDerValue();
        id = derVal.getUnalignedBitString(true);
    }

    /**
     * Create the object, decoding the values from the passed DER stream.
     *
     * @param derVal the DerValue decoded from the stream.
     * @exception IOException on decoding errors.
     */
    public UniqueIdentity(DerValue derVal) throws IOException {
        id = derVal.getUnalignedBitString(true);
    }

    /**
     * Return the UniqueIdentity as a printable string.
     */
    public String toString() {
        return ("UniqueIdentity:" + id.toString() + "\n");
    }

    /**
     * Encode the UniqueIdentity in DER form to the stream.
     *
     * @param out the DerOutputStream to marshal the contents to.
     * @param tag enocode it under the following tag.
     * @exception IOException on errors.
     */
    public void encode(DerOutputStream out, byte tag) throws IOException {
        byte[] bytes = id.toByteArray();
        int excessBits = bytes.length*8 - id.length();

        out.write(tag);
        out.putLength(bytes.length + 1);

        out.write(excessBits);
        out.write(bytes);
    }

    /**
     * Return the unique id.
     */
    public boolean[] getId() {
        if (id == null) return null;

        return id.toBooleanArray();
    }
}
