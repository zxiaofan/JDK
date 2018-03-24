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
public class SOAPNamespaceConstants {
    public static final String NSPREFIX_SOAP_ENVELOPE = "soapenv";
    public static final String ENVELOPE = "http://schemas.xmlsoap.org/soap/envelope/";
    public static final String ENCODING =
        "http://schemas.xmlsoap.org/soap/encoding/";
    public static final String XSD = "http://www.w3.org/2001/XMLSchema";
    public static final String XSI =
        "http://www.w3.org/2001/XMLSchema-instance";
    public static final String XMLNS = "http://www.w3.org/XML/1998/namespace";
    public static final String TRANSPORT_HTTP =
        "http://schemas.xmlsoap.org/soap/http";
    public static final String ACTOR_NEXT =
        "http://schemas.xmlsoap.org/soap/actor/next";

    public static final String TAG_ENVELOPE = "Envelope";
    public static final String TAG_HEADER = "Header";
    public static final String TAG_BODY = "Body";
    public static final String TAG_FAULT = "Fault";

    public static final String ATTR_ACTOR = "actor";
    public static final String ATTR_MUST_UNDERSTAND = "mustUnderstand";
    public static final String ATTR_ENCODING_STYLE = "encodingStyle";
}
