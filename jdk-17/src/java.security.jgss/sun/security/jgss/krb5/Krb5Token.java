/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.jgss.krb5;

import java.io.IOException;
import sun.security.util.*;
import sun.security.jgss.*;

/**
 * This class represents a base class for all Kerberos v5 GSS-API
 * tokens. It contains commonly used definitions and utilities.
 *
 * @author Mayank Upadhyay
 */

abstract class Krb5Token extends GSSToken {

    /**
     * The token id defined for the token emitted by the initSecContext call
     * carrying the AP_REQ .
     */
    public static final int AP_REQ_ID = 0x0100;

    /**
     * The token id defined for the token emitted by the acceptSecContext call
     * carrying the AP_REP .
     */
    public static final int AP_REP_ID = 0x0200;

    /**
     * The token id defined for any token carrying a KRB-ERR message.
     */
    public static final int ERR_ID    = 0x0300;

    /**
     * The token id defined for the token emitted by the getMIC call.
     */
    public static final int MIC_ID    = 0x0101;

    /**
     * The token id defined for the token emitted by the wrap call.
     */
    public static final int WRAP_ID   = 0x0201;

    // new token ID draft-ietf-krb-wg-gssapi-cfx-07.txt
    public static final int MIC_ID_v2  = 0x0404;
    public static final int WRAP_ID_v2 = 0x0504;

    /**
     * The object identifier corresponding to the Kerberos v5 GSS-API
     * mechanism.
     */
    public static ObjectIdentifier OID;

    static {
        try {
            OID = ObjectIdentifier.of(Krb5MechFactory.
                                       GSS_KRB5_MECH_OID.toString());
        } catch (IOException ioe) {
          // should not happen
        }
    }

    /**
     * Returns a strign representing the token type.
     *
     * @param tokenId the token id for which a string name is desired
     * @return the String name of this token type
     */
    public static String getTokenName(int tokenId) {
        String retVal = null;
        switch (tokenId) {
            case AP_REQ_ID:
            case AP_REP_ID:
                retVal = "Context Establishment Token";
                break;
            case MIC_ID:
                retVal = "MIC Token";
                break;
            case MIC_ID_v2:
                retVal = "MIC Token (new format)";
                break;
            case WRAP_ID:
                retVal = "Wrap Token";
                break;
            case WRAP_ID_v2:
                retVal = "Wrap Token (new format)";
                break;
            default:
                retVal = "Kerberos GSS-API Mechanism Token";
                break;
        }
        return retVal;
    }
}
