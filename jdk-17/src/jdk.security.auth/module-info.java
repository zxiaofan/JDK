/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Provides implementations of the {@code javax.security.auth.*}
 * interfaces and various authentication modules.
 *
 * @provides javax.security.auth.spi.LoginModule
 * @moduleGraph
 * @since 9
 */
module jdk.security.auth {

    requires java.security.jgss;

    requires transitive java.naming;

    exports com.sun.security.auth;
    exports com.sun.security.auth.callback;
    exports com.sun.security.auth.login;
    exports com.sun.security.auth.module;

    provides javax.security.auth.spi.LoginModule with
        com.sun.security.auth.module.Krb5LoginModule,
        com.sun.security.auth.module.UnixLoginModule,
        com.sun.security.auth.module.JndiLoginModule,
        com.sun.security.auth.module.KeyStoreLoginModule,
        com.sun.security.auth.module.LdapLoginModule,
        com.sun.security.auth.module.NTLoginModule;
}
