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

package com.sun.xml.internal.ws.api.model.wsdl;

import com.sun.xml.internal.ws.api.model.ParameterBinding;

/**
 * Abstracts wsdl:part after applying binding information from wsdl:binding.
 *
 * @author Vivek Pandey
 */
public interface WSDLPart extends WSDLObject {
    /**
     * Gets wsdl:part@name attribute value.
     */
    String getName();

    /**
     * Gets the wsdl:part binding as seen thru wsdl:binding
     */
    ParameterBinding getBinding();

    /**
     * Index value is as the order in which the wsdl:part appears inside the input or output wsdl:message.
     * @return n where n >= 0
     */
    int getIndex();

    /**
     * Gives the XML Schema descriptor referenced using either wsdl:part@element or wsdl:part@type.
     */
    public WSDLPartDescriptor getDescriptor();
}
