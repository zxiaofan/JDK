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
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOperation;

public interface EditableWSDLOperation extends WSDLOperation {

    @Override
    @NotNull
    EditableWSDLInput getInput();

    /**
     * Set input
     *
     * @param input Input
     */
    public void setInput(EditableWSDLInput input);

    @Override
    @Nullable
    EditableWSDLOutput getOutput();

    /**
     * Set output
     *
     * @param output Output
     */
    public void setOutput(EditableWSDLOutput output);

    @Override
    Iterable<? extends EditableWSDLFault> getFaults();

    /**
     * Add fault
     *
     * @param fault Fault
     */
    public void addFault(EditableWSDLFault fault);

    @Override
    @Nullable
    EditableWSDLFault getFault(QName faultDetailName);

    /**
     * Set parameter order
     *
     * @param parameterOrder Parameter order
     */
    public void setParameterOrder(String parameterOrder);

    /**
     * Freezes WSDL model to prevent further modification
     *
     * @param root WSDL Model
     */
    public void freeze(EditableWSDLModel root);
}
