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

import com.sun.xml.internal.ws.api.model.wsdl.WSDLExtensible;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOperation;

import javax.xml.namespace.QName;

/**
 * Abstraction of wsdl:portType.
 *
 * @author Vivek Pandey
 */
public interface WSDLPortType extends WSDLObject, WSDLExtensible {
    /**
     * Gets the name of the wsdl:portType@name attribute value as local name and wsdl:definitions@targetNamespace
     * as the namespace uri.
     */
    public QName getName();

    /**
     * Gets the {@link WSDLOperation} for a given operation name
     *
     * @param operationName non-null operationName
     * @return null if a {@link WSDLOperation} is not found
     */
    public WSDLOperation get(String operationName);

    /**
     * Gets {@link Iterable}<{@link WSDLOperation}>
     */
    public Iterable<? extends WSDLOperation> getOperations();
}
