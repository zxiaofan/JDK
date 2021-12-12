/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines the Java binding of the IETF Generic Security Services API (GSS-API).
 * <P>
 * This module also contains GSS-API mechanisms including Kerberos v5 and SPNEGO.
 *
 * @moduleGraph
 * @since 9
 */
module java.security.jgss {
    requires java.naming;

    exports javax.security.auth.kerberos;
    exports org.ietf.jgss;

    exports sun.security.jgss to
        jdk.security.jgss;
    exports sun.security.jgss.krb5 to
        jdk.security.auth;
    exports sun.security.jgss.krb5.internal to
        jdk.security.jgss;
    exports sun.security.krb5 to
        jdk.security.auth;
    exports sun.security.krb5.internal to
        jdk.security.jgss;
    exports sun.security.krb5.internal.ktab to
        jdk.security.auth;

    // Opens for reflective instantiation of sun.net.www.protocol.http.spnego.NegotiatorImpl
    // to sun.net.www.protocol.http.HttpURLConnection
    opens sun.net.www.protocol.http.spnego to
        java.base;

    provides java.security.Provider with
        sun.security.jgss.SunProvider;
}

