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

package com.sun.xml.internal.ws.wsdl.parser;

import javax.xml.namespace.QName;


interface MIMEConstants {

    // namespace URIs
    static final String NS_WSDL_MIME = "http://schemas.xmlsoap.org/wsdl/mime/";

    // QNames
    static final QName QNAME_CONTENT = new QName(NS_WSDL_MIME, "content");
    static final QName QNAME_MULTIPART_RELATED = new QName(NS_WSDL_MIME, "multipartRelated");
    static final QName QNAME_PART = new QName(NS_WSDL_MIME, "part");
    static final QName QNAME_MIME_XML = new QName(NS_WSDL_MIME, "mimeXml");
}
