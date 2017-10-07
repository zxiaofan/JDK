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

import com.sun.xml.internal.ws.api.model.wsdl.WSDLPortType;

public interface EditableWSDLPortType extends WSDLPortType {

    @Override
    public EditableWSDLOperation get(String operationName);

    @Override
    public Iterable<? extends EditableWSDLOperation> getOperations();

    /**
     * Associate WSDL operation with operation name
     *
     * @param opName Operation name
     * @param ptOp   Operation
     */
    public void put(String opName, EditableWSDLOperation ptOp);

    /**
     * Freezes WSDL model to prevent further modification
     */
    public void freeze();
}
