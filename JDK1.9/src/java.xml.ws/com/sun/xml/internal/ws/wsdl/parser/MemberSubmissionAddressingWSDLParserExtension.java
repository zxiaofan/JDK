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

import com.sun.xml.internal.ws.api.addressing.AddressingVersion;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressingFeature;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLFeaturedObject;
import com.sun.xml.internal.ws.api.model.wsdl.editable.*;
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;

/**
 * Member Submission WS-Addressing Runtime WSDL parser extension
 *
 * @author Arun Gupta
 */
public class MemberSubmissionAddressingWSDLParserExtension extends W3CAddressingWSDLParserExtension {
    @Override
    public boolean bindingElements(EditableWSDLBoundPortType binding, XMLStreamReader reader) {
        return addressibleElement(reader, binding);
    }

    @Override
    public boolean portElements(EditableWSDLPort port, XMLStreamReader reader) {
        return addressibleElement(reader, port);
    }

    private boolean addressibleElement(XMLStreamReader reader, WSDLFeaturedObject binding) {
        QName ua = reader.getName();
        if (ua.equals(AddressingVersion.MEMBER.wsdlExtensionTag)) {
            String required = reader.getAttributeValue(WSDLConstants.NS_WSDL, "required");
            binding.addFeature(new MemberSubmissionAddressingFeature(Boolean.parseBoolean(required)));
            XMLStreamReaderUtil.skipElement(reader);
            return true;        // UsingAddressing is consumed
        }

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
        return AddressingVersion.MEMBER.wsdlNsUri;
    }

    @Override
    protected QName getWsdlActionTag() {
        return  AddressingVersion.MEMBER.wsdlActionTag;
    }
}
