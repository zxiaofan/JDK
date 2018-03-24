/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.model.wsdl.editable;

import javax.xml.namespace.QName;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLService;

public interface EditableWSDLService extends WSDLService {

    @Override
    @NotNull
    EditableWSDLModel getParent();

    @Override
    EditableWSDLPort get(QName portName);

    @Override
    EditableWSDLPort getFirstPort();

    @Override
    @Nullable
    EditableWSDLPort getMatchingPort(QName portTypeName);

    @Override
    Iterable<? extends EditableWSDLPort> getPorts();

    /**
     * Associate WSDL port with port QName
     *
     * @param portName Port QName
     * @param port     Port
     */
    public void put(QName portName, EditableWSDLPort port);

    /**
     * Freezes WSDL model to prevent further modification
     *
     * @param root WSDL Model
     */
    void freeze(EditableWSDLModel root);
}
