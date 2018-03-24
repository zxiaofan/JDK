/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.policy;

import javax.xml.namespace.QName;

/**
 * Commonly used constants by the policy implementations
 */
public final class PolicyConstants {
    /**
     * Sun proprietary policy namespace URI
     */
    public static final String SUN_POLICY_NAMESPACE_URI = "http://java.sun.com/xml/ns/wsit/policy";

    /**
     * Sun proprietary policy namespace prefix
     */
    public static final String SUN_POLICY_NAMESPACE_PREFIX = "sunwsp";

    /**
     * Fully qualified name of the SUN's proprietary policy assertion visibility attribute
     */
    public static final QName VISIBILITY_ATTRIBUTE = new QName(SUN_POLICY_NAMESPACE_URI, "visibility");

    /**
     * Recognized value of the SUN's proprietary policy assertion visibility attribute
     */
    public static final String VISIBILITY_VALUE_PRIVATE = "private";

    /**
     * Standard WS-Security Utility namespace URI, used in Policy Id
     */
    public static final String WSU_NAMESPACE_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";

    /**
     * Standard WS-Security Utility namespace prefix, used in Policy Id
     */
    public static final String WSU_NAMESPACE_PREFIX = "wsu";

    /**
     * Fully qualified name of the Policy wsu:Id XML attribute
     */
    public static final QName WSU_ID = new QName(WSU_NAMESPACE_URI, "Id");

    /**
     * Standard XML namespace URI
     */
    public static final String XML_NAMESPACE_URI = "http://www.w3.org/XML/1998/namespace";

    /**
     * Fully qualified name of the xml:id policy attribute
     */
    public static final QName XML_ID = new QName(XML_NAMESPACE_URI, "id");

    /**
     * Identifier of the client-side configuration file
     */
    public static final String CLIENT_CONFIGURATION_IDENTIFIER = "client";

    /**
     * XML namespace for management policy assertions
     */
    public static final String SUN_MANAGEMENT_NAMESPACE = "http://java.sun.com/xml/ns/metro/management";

    /**
     * Prevent instantiation of this class.
     */
    private PolicyConstants() {
        // nothing to initialize
    }
}
