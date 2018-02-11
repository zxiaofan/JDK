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

package com.sun.xml.internal.ws.encoding.soap.streaming;

/**
 * @author WS Development Team
 */
public class SOAP12NamespaceConstants {
    public static final String XML_NS = "http://www.w3.org/XML/1998/namespace";
    public static final String ENVELOPE =
        "http://www.w3.org/2003/05/soap-envelope";
    public static final String ENCODING =
        "http://www.w3.org/2003/05/soap-encoding";
    public static final String SOAP_RPC = "http://www.w3.org/2002/06/soap-rpc";
    public static final String XSD = "http://www.w3.org/2001/XMLSchema";
    public static final String XSI =
        "http://www.w3.org/2001/XMLSchema-instance";
    public static final String TRANSPORT_HTTP =
        "http://www.w3.org/2003/05/soap/bindings/HTTP/";

    public static final String ACTOR_NEXT = "http://www.w3.org/2003/05/soap-envelope/role/next";

    public static final String ROLE_NEXT =
        "http://www.w3.org/2003/05/soap-envelope/role/next";
    public static final String ROLE_NONE = "http://www.w3.org/2003/05/soap-envelope/role/none";
    public static final String ROLE_ULTIMATE_RECEIVER = "http://www.w3.org/2003/05/soap-envelope/role/ultimateReceiver";

    public static final String SOAP_UPGRADE =
        "http://www.w3.org/2002/06/soap-upgrade";

    public static final String TAG_ENVELOPE = "Envelope";
    public static final String TAG_HEADER = "Header";
    public static final String TAG_BODY = "Body";
    public static final String TAG_RESULT = "result";
    public static final String TAG_NOT_UNDERSTOOD = "NotUnderstood";

    public static final String ATTR_ACTOR = "role";
    public static final String ATTR_MUST_UNDERSTAND = "mustUnderstand";
    public static final String ATTR_MISUNDERSTOOD = "missUnderstood";
    public static final String ATTR_ENCODING_STYLE = "encodingStyle";
    public static final String ATTR_NOT_UNDERSTOOD_QNAME = "qname";
}
