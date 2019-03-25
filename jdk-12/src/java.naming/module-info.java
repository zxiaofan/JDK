/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the Java Naming and Directory Interface (JNDI) API.
 *
 * @provides javax.naming.ldap.spi.LdapDnsProvider
 *
 * @uses javax.naming.ldap.spi.LdapDnsProvider
 *
 * @moduleGraph
 * @since 9
 */
module java.naming {
    requires java.security.sasl;

    exports javax.naming;
    exports javax.naming.directory;
    exports javax.naming.event;
    exports javax.naming.ldap;
    exports javax.naming.spi;
    exports javax.naming.ldap.spi;

    exports com.sun.jndi.toolkit.ctx to
        jdk.naming.dns;
    exports com.sun.jndi.toolkit.url to
        jdk.naming.dns,
        jdk.naming.rmi;

    uses javax.naming.ldap.StartTlsResponse;
    uses javax.naming.spi.InitialContextFactory;
    uses javax.naming.ldap.spi.LdapDnsProvider;

    provides java.security.Provider with
        sun.security.provider.certpath.ldap.JdkLDAP;
}

