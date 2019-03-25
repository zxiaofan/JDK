/*
 * Copyright (c) 1999, 2011, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.ldap;

import javax.naming.ldap.UnsolicitedNotification;
import javax.naming.NamingException;
import javax.naming.ldap.Control;
import java.util.Vector;

/**
 * A concrete implementation of an UnsolicitedNotification.
 * @author Rosanna Lee
 */
final class UnsolicitedResponseImpl implements UnsolicitedNotification {
    private String oid;
    private String[] referrals;
    private byte[] extensionValue;
    private NamingException exception;
    private Control[] controls;

    UnsolicitedResponseImpl(String oid, byte[] berVal, Vector<Vector<String>> ref,
        int status, String msg, String matchedDN, Control[] controls) {
        this.oid = oid;
        this.extensionValue = berVal;

        if (ref != null && ref.size() > 0) {
            int len = ref.size();
            referrals = new String[len];
            for (int i = 0; i < len; i++) {
                // ref is a list of single-String Vectors
                referrals[i] = ref.elementAt(i).elementAt(0);
            }
        }
        exception = LdapCtx.mapErrorCode(status, msg);
        // matchedDN ignored for now; could be used to set resolvedName
        // exception.setResolvedName(new CompositeName().add(matchedDN));

        this.controls = controls;
    }

    /**
      * Retrieves the object identifier of the response.
      *
      * @return A possibly null object identifier string representing the LDAP
      *         {@code ExtendedResponse.responseName} component.
      */
    public String getID() {
        return oid;
    }

    /**
      * Retrieves the ASN.1 BER encoded value of the LDAP extended operation
      * response. Null is returned if the value is absent from the response
      * sent by the LDAP server.
      * The result is the raw BER bytes including the tag and length of
      * the response value. It does not include the response OID.
      *
      * @return A possibly null byte array representing the ASN.1 BER encoded
      *         contents of the LDAP {@code ExtendedResponse.response}
      *         component.
      */
    public byte[] getEncodedValue() {
        return extensionValue;
    }

    /**
     * Retrieves the referral(s) sent by the server.
     *
     * @return A possibly null array of referrals, each of which is represented
     * by a URL string. If null, no referral was sent by the server.
     */
    public String[] getReferrals() {
        return referrals;
    }

    /**
     * Retrieves the exception as constructed using information
     * sent by the server.
     * @return A possibly null exception as constructed using information
     * sent by the server. If null, a "success" status was indicated by
     * the server.
     */
    public NamingException getException() {
        return exception;
    }

    public Control[] getControls() throws NamingException {
        return controls;
    }

    private static final long serialVersionUID = 5913778898401784775L;
}
