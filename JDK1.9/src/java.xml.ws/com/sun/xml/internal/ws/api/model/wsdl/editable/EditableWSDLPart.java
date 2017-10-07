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

import com.sun.xml.internal.ws.api.model.ParameterBinding;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPart;

public interface EditableWSDLPart extends WSDLPart {

    /**
     * Sets binding
     *
     * @param binding Binding
     */
    public void setBinding(ParameterBinding binding);

    /**
     * Sets index
     *
     * @param index Index
     */
    public void setIndex(int index);

}
