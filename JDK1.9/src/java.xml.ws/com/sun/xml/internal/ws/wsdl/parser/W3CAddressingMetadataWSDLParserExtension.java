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

import com.sun.xml.internal.ws.api.model.wsdl.editable.*;
import javax.xml.stream.XMLStreamReader;
import javax.xml.namespace.QName;

/**
 * W3C WS-Addressing Runtime WSDL parser extension that parses
 * WS-Addressing Metadata wsdl extensibility elements
 * This mainly reads wsam:Action element on input/output/fault messages in wsdl.
 *
 * @author Rama Pulavarthi
 */
public class W3CAddressingMetadataWSDLParserExtension extends W3CAddressingWSDLParserExtension {

    String METADATA_WSDL_EXTN_NS = "http://www.w3.org/2007/05/addressing/metadata";
    QName METADATA_WSDL_ACTION_TAG = new QName(METADATA_WSDL_EXTN_NS, "Action", "wsam");
    @Override
    public boolean bindingElements(EditableWSDLBoundPortType binding, XMLStreamReader reader) {
        return false;
    }

    @Override
    public boolean portElements(EditableWSDLPort port, XMLStreamReader reader) {
        return false;
    }

    @Override
    public boolean bindingOperationElements(EditableWSDLBoundOperation operation, XMLStreamReader reader) {
        return false;
    }

    @Override
    protected void patchAnonymousDefault(EditableWSDLBoundPortType binding) {
    }

    @Override
    protected String getNamespaceURI() {
        return METADATA_WSDL_EXTN_NS;
    }

    @Override
    protected QName getWsdlActionTag() {
        return  METADATA_WSDL_ACTION_TAG;
    }
}
