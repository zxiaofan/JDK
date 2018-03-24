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
 * Represents a WSDL extensibility element or attribute.
 *
 * <p>
 * This interface can be implemented by the programs that build
 * on top of the JAX-WS RI, to hook additional information into
 * {@link WSDLModel}.
 *
 * @author Vivek Pandey
 */
public interface WSDLExtension {
    /**
     * Gets the qualified name of the WSDL extensibility element or attribute.
     *
     * @return
     *      must not be null.
     */
    public QName getName();
}
