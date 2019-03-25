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
 * Defines Java support for the IETF Simple Authentication and Security Layer
 * (SASL).
 * <P>
 * This module also contains SASL mechanisms including DIGEST-MD5,
 * CRAM-MD5, and NTLM.
 *
 * @moduleGraph
 * @since 9
 */
module java.security.sasl {
    requires java.logging;

    exports javax.security.sasl;

    exports com.sun.security.sasl.util to
        jdk.security.jgss;

    provides java.security.Provider with
        com.sun.security.sasl.Provider;
}

