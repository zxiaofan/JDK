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
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLModel;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLOperation;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLOutput;
import com.sun.istack.internal.NotNull;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;

/**
 * @author Vivek Pandey
 */
public final class WSDLOutputImpl extends AbstractExtensibleImpl implements EditableWSDLOutput {
    private String name;
    private QName messageName;
    private EditableWSDLOperation operation;
    private EditableWSDLMessage message;
    private String action;
    private boolean defaultAction = true;

    public WSDLOutputImpl(XMLStreamReader xsr,String name, QName messageName, EditableWSDLOperation operation) {
        super(xsr);
        this.name = name;
        this.messageName = messageName;
        this.operation = operation;
    }

    public String getName() {
        return (name == null)?operation.getName().getLocalPart()+"Response":name;
    }

    public EditableWSDLMessage getMessage() {
        return message;
    }

    public String getAction() {
        return action;
    }

    public boolean isDefaultAction() {
        return defaultAction;
    }

    public void setDefaultAction(boolean defaultAction) {
        this.defaultAction = defaultAction;
    }

    @NotNull
    public EditableWSDLOperation getOperation() {
        return operation;
    }

    @NotNull
    public QName getQName() {
        return new QName(operation.getName().getNamespaceURI(), getName());
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void freeze(EditableWSDLModel root) {
        message = root.getMessage(messageName);
    }
}
