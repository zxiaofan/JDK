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

package com.sun.xml.internal.ws.api.model.wsdl.editable;

import javax.jws.soap.SOAPBinding.Style;
import javax.xml.namespace.QName;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.BindingID;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundPortType;

public interface EditableWSDLBoundPortType extends WSDLBoundPortType {

        @Override
    @NotNull EditableWSDLModel getOwner();

        @Override
    public EditableWSDLBoundOperation get(QName operationName);

        @Override
    EditableWSDLPortType getPortType();

        @Override
    Iterable<? extends EditableWSDLBoundOperation> getBindingOperations();

        @Override
    @Nullable EditableWSDLBoundOperation getOperation(String namespaceUri, String localName);

    /**
     * Populates the Map that holds operation name as key and {@link WSDLBoundOperation} as the value.
     *
     * @param opName Must be non-null
     * @param ptOp   Must be non-null
     * @throws NullPointerException if either opName or ptOp is null
     */
    public void put(QName opName, EditableWSDLBoundOperation ptOp);

    /**
     * Sets the binding ID
     * @param bindingId Binding ID
     */
        public void setBindingId(BindingID bindingId);

    /**
     * sets whether the {@link WSDLBoundPortType} is rpc or lit
     */
        public void setStyle(Style style);

        /**
         * Freezes WSDL model to prevent further modification
         */
        public void freeze();
}
