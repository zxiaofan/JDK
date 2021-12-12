/*
 * Copyright (c) 1999, 2002, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;

/**
 * This class implements the LDAPv3 Request Control for manageDsaIT as
 * defined in
 * <a href="http://www.ietf.org/internet-drafts/draft-ietf-ldapext-namedref-00.txt">draft-ietf-ldapext-namedref-00.txt</a>.
 *
 * The control has no control value.
 *
 * @author Vincent Ryan
 */
public final class ManageReferralControl extends BasicControl {

    /**
     * The manage referral control's assigned object identifier
     * is 2.16.840.1.113730.3.4.2.
     *
     * @serial
     */
    public static final String OID = "2.16.840.1.113730.3.4.2";

    private static final long serialVersionUID = 909382692585717224L;

    /**
     * Constructs a manage referral critical control.
     */
    public ManageReferralControl() {
        super(OID, true, null);
    }

    /**
     * Constructs a manage referral control.
     *
     * @param   criticality The control's criticality setting.
     */
    public ManageReferralControl(boolean criticality) {
        super(OID, criticality, null);
    }
}
