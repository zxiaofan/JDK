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


/**
 * Interface defining WSDL-related constants.
 *
 * @author WS Development Team
 */
public interface WSDLConstants {
    // namespace URIs
    static final String PREFIX_NS_WSDL = "wsdl";
    static final String NS_XMLNS = "http://www.w3.org/2001/XMLSchema";
    static final String NS_WSDL = "http://schemas.xmlsoap.org/wsdl/";
    static final String NS_SOAP11_HTTP_BINDING = "http://schemas.xmlsoap.org/soap/http";

    static final QName QNAME_SCHEMA = new QName(NS_XMLNS, "schema");

    // QNames
    static final QName QNAME_BINDING = new QName(NS_WSDL, "binding");
    static final QName QNAME_DEFINITIONS = new QName(NS_WSDL, "definitions");
    static final QName QNAME_DOCUMENTATION = new QName(NS_WSDL, "documentation");
    static final QName NS_SOAP_BINDING_ADDRESS = new QName("http://schemas.xmlsoap.org/wsdl/soap/", "address");
    static final QName NS_SOAP_BINDING = new QName("http://schemas.xmlsoap.org/wsdl/soap/", "binding");
    static final QName NS_SOAP12_BINDING = new QName("http://schemas.xmlsoap.org/wsdl/soap12/", "binding");
    static final QName NS_SOAP12_BINDING_ADDRESS = new QName("http://schemas.xmlsoap.org/wsdl/soap12/", "address");

    //static final QName QNAME_FAULT = new QName(NS_WSDL, "fault");
    static final QName QNAME_IMPORT = new QName(NS_WSDL, "import");

    //static final QName QNAME_INPUT = new QName(NS_WSDL, "input");
    static final QName QNAME_MESSAGE = new QName(NS_WSDL, "message");
    static final QName QNAME_PART = new QName(NS_WSDL, "part");
    static final QName QNAME_OPERATION = new QName(NS_WSDL, "operation");
    static final QName QNAME_INPUT = new QName(NS_WSDL, "input");
    static final QName QNAME_OUTPUT = new QName(NS_WSDL, "output");

    //static final QName QNAME_OUTPUT = new QName(NS_WSDL, "output");
    //static final QName QNAME_PART = new QName(NS_WSDL, "part");
    static final QName QNAME_PORT = new QName(NS_WSDL, "port");
    static final QName QNAME_ADDRESS = new QName(NS_WSDL, "address");
    static final QName QNAME_PORT_TYPE = new QName(NS_WSDL, "portType");
    static final QName QNAME_FAULT = new QName(NS_WSDL, "fault");
    static final QName QNAME_SERVICE = new QName(NS_WSDL, "service");
    static final QName QNAME_TYPES = new QName(NS_WSDL, "types");

    static final String ATTR_TRANSPORT = "transport";
    static final String ATTR_LOCATION = "location";
    static final String ATTR_NAME = "name";
    static final String ATTR_TNS = "targetNamespace";

    //static final QName QNAME_ATTR_ARRAY_TYPE = new QName(NS_WSDL, "arrayType");
}
