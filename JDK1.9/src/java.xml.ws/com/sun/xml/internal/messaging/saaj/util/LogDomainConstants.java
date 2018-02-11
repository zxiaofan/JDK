/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.messaging.saaj.util;

/**
 * @author  Manveen Kaur (manveen.kaur@eng.sun.com)
 */

/**
 * This interface defines a number of constants pertaining to Logging domains.
 */

public interface LogDomainConstants {

    public static String MODULE_TOPLEVEL_DOMAIN =
                    "com.sun.xml.internal.messaging.saaj";

    // First Level Domain
    public static String CLIENT_DOMAIN =
                MODULE_TOPLEVEL_DOMAIN + ".client";

    public static String SOAP_DOMAIN =
                MODULE_TOPLEVEL_DOMAIN + ".soap";

    public static String UTIL_DOMAIN =
                MODULE_TOPLEVEL_DOMAIN + ".util";

    // Second Level Domain
    public static String HTTP_CONN_DOMAIN =
                  CLIENT_DOMAIN + ".p2p";

    public static String NAMING_DOMAIN =
                SOAP_DOMAIN + ".name";

    public static String SOAP_IMPL_DOMAIN =
                  SOAP_DOMAIN + ".impl";

    public static String SOAP_VER1_1_DOMAIN =
                  SOAP_DOMAIN + ".ver1_1";

    public static String SOAP_VER1_2_DOMAIN =
                  SOAP_DOMAIN + ".ver1_2";

}
