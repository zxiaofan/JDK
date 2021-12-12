/*
 * Copyright (c) 2011, 2019, Oracle and/or its affiliates. All rights reserved.
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

package javax.security.auth.kerberos;

import sun.security.krb5.JavaxSecurityAuthKerberosAccess;

class JavaxSecurityAuthKerberosAccessImpl
        implements JavaxSecurityAuthKerberosAccess {
    public sun.security.krb5.internal.ktab.KeyTab keyTabTakeSnapshot(
            KeyTab ktab) {
        return ktab.takeSnapshot();
    }

    public KerberosPrincipal kerberosTicketGetClientAlias(KerberosTicket t) {
        return t.clientAlias;
    }

    public void kerberosTicketSetClientAlias(KerberosTicket t, KerberosPrincipal a) {
        t.clientAlias = a;
    }

    public KerberosPrincipal kerberosTicketGetServerAlias(KerberosTicket t) {
        return t.serverAlias;
    }

    public void kerberosTicketSetServerAlias(KerberosTicket t, KerberosPrincipal a) {
        t.serverAlias = a;
    }

    public KerberosTicket kerberosTicketGetProxy(KerberosTicket t) {
        return t.proxy;
    }

    public void kerberosTicketSetProxy(KerberosTicket t, KerberosTicket p) {
        t.proxy = p;
    }
}
