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
 * Defines JDK extensions to the GSS-API and an implementation of the SASL
 * GSSAPI mechanism.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.security.jgss {
    requires java.logging;
    requires java.security.sasl;

    requires transitive java.security.jgss;

    exports com.sun.security.jgss;

    provides java.security.Provider with
        com.sun.security.sasl.gsskerb.JdkSASL;
}

