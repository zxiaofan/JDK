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

import java.util.Vector;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.ldap.Control;

/**
  * %%% public for use by LdapSasl %%%
  */
public final class LdapResult {
    int msgId;
    public int status;                  // %%% public for use by LdapSasl
    String matchedDN;
    String errorMessage;
    // Vector<String | Vector<String>>
    Vector<Vector<String>> referrals = null;
    LdapReferralException refEx = null;
    Vector<LdapEntry> entries = null;
    Vector<Control> resControls = null;
    public byte[] serverCreds = null;   // %%% public for use by LdapSasl
    String extensionId = null;          // string OID
    byte[] extensionValue = null;       // BER OCTET STRING


    // This function turns an LdapResult that came from a compare operation
    // into one that looks like it came from a search operation. This is
    // useful when the caller asked the context to do a search, but it was
    // carried out as a compare. In this case, the client still expects a
    // result that looks like it came from a search.
    boolean compareToSearchResult(String name) {
        boolean successful = false;

        switch (status) {
            case LdapClient.LDAP_COMPARE_TRUE:
                status = LdapClient.LDAP_SUCCESS;
                entries = new Vector<>(1,1);
                Attributes attrs = new BasicAttributes(LdapClient.caseIgnore);
                LdapEntry entry = new LdapEntry( name, attrs );
                entries.addElement(entry);
                successful = true;
                break;

            case LdapClient.LDAP_COMPARE_FALSE:
                status = LdapClient.LDAP_SUCCESS;
                entries = new Vector<>(0);
                successful = true;
                break;

            default:
                successful = false;
                break;
        }

        return successful;
    }
}
