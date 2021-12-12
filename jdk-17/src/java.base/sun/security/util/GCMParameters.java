/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.GCMParameterSpec;
import sun.security.util.HexDumpEncoder;
import sun.security.util.*;

/**
 * This class implements the parameter set used with
 * GCM encryption, which is defined in RFC 5084 as follows:
 *
 * <pre>
 *    GCMParameters ::= SEQUENCE {
 *      aes-iv      OCTET STRING, -- recommended size is 12 octets
 *      aes-tLen    AES-GCM-ICVlen DEFAULT 12 }
 *
 *    AES-GCM-ICVlen ::= INTEGER (12 | 13 | 14 | 15 | 16)
 *
 * </pre>
 *
 * @since 13
 */
public final class GCMParameters extends AlgorithmParametersSpi {

    // the iv
    private byte[] iv;
    // the tag length in bytes
    private int tLen;

    public GCMParameters() {}

    protected void engineInit(AlgorithmParameterSpec paramSpec)
        throws InvalidParameterSpecException {

        if (!(paramSpec instanceof GCMParameterSpec)) {
            throw new InvalidParameterSpecException
                ("Inappropriate parameter specification");
        }
        GCMParameterSpec gps = (GCMParameterSpec) paramSpec;
        // need to convert from bits to bytes for ASN.1 encoding
        this.tLen = gps.getTLen()/8;
        if (this.tLen < 12 || this.tLen > 16 ) {
            throw new InvalidParameterSpecException
                ("GCM parameter parsing error: unsupported tag len: " +
                 this.tLen);
        }
        this.iv = gps.getIV();
    }

    protected void engineInit(byte[] encoded) throws IOException {
        DerValue val = new DerValue(encoded);
        // check if IV or params
        if (val.tag == DerValue.tag_Sequence) {
            byte[] iv = val.data.getOctetString();
            int tLen;
            if (val.data.available() != 0) {
                tLen = val.data.getInteger();
                if (tLen < 12 || tLen > 16 ) {
                    throw new IOException
                        ("GCM parameter parsing error: unsupported tag len: " +
                         tLen);
                }
                if (val.data.available() != 0) {
                    throw new IOException
                        ("GCM parameter parsing error: extra data");
                }
            } else {
                tLen = 12;
            }
            this.iv = iv.clone();
            this.tLen = tLen;
        } else {
            throw new IOException("GCM parameter parsing error: no SEQ tag");
        }
    }

    protected void engineInit(byte[] encoded, String decodingMethod)
        throws IOException {
        engineInit(encoded);
    }

    protected <T extends AlgorithmParameterSpec>
            T engineGetParameterSpec(Class<T> paramSpec)
        throws InvalidParameterSpecException {

        if (GCMParameterSpec.class.isAssignableFrom(paramSpec)) {
            return paramSpec.cast(new GCMParameterSpec(tLen * 8, iv));
        } else {
            throw new InvalidParameterSpecException
                ("Inappropriate parameter specification");
        }
    }

    protected byte[] engineGetEncoded() throws IOException {
        DerOutputStream out = new DerOutputStream();
        DerOutputStream bytes = new DerOutputStream();

        bytes.putOctetString(iv);
        // Only put non-default values
        if (tLen != 12) {
            bytes.putInteger(tLen);
        }
        out.write(DerValue.tag_Sequence, bytes);
        return out.toByteArray();
    }

    protected byte[] engineGetEncoded(String encodingMethod)
        throws IOException {
        return engineGetEncoded();
    }

    /*
     * Returns a formatted string describing the parameters.
     */
    protected String engineToString() {
        String LINE_SEP = System.lineSeparator();
        HexDumpEncoder encoder = new HexDumpEncoder();
        StringBuilder sb
            = new StringBuilder(LINE_SEP + "    iv:" + LINE_SEP + "["
                + encoder.encodeBuffer(iv) + "]");

        sb.append(LINE_SEP + "tLen(bits):" + LINE_SEP + tLen*8 + LINE_SEP);
        return sb.toString();
    }
}
