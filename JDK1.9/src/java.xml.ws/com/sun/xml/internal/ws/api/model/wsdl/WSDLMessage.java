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

import javax.xml.namespace.QName;

/**
 * Abstraction of wsdl:message.
 *
 * @author Vivek Pandey
 */
public interface WSDLMessage extends WSDLObject, WSDLExtensible {
    /**
     * Gives wsdl:message@name value.
     */
    QName getName();

    /**
     * Gets all the parts.
     */
    Iterable<? extends WSDLPart> parts();
}
