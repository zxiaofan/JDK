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

package com.sun.xml.internal.ws.model.wsdl;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLMessage;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLPart;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;

import java.util.ArrayList;

/**
 * Provides abstraction for wsdl:message
 * @author Vivek Pandey
 */
public final class WSDLMessageImpl extends AbstractExtensibleImpl implements EditableWSDLMessage {
    private final QName name;
    private final ArrayList<EditableWSDLPart> parts;

    /**
     * @param name wsdl:message name attribute value
     */
    public WSDLMessageImpl(XMLStreamReader xsr,QName name) {
        super(xsr);
        this.name = name;
        this.parts = new ArrayList<EditableWSDLPart>();
    }

    public QName getName() {
        return name;
    }

    public void add(EditableWSDLPart part){
        parts.add(part);
    }

    public Iterable<EditableWSDLPart> parts(){
        return parts;
    }
}
