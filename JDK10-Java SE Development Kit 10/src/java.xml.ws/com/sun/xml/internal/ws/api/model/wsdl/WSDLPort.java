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

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.EndpointAddress;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;

import javax.xml.namespace.QName;

/**
 * Abstracts wsdl:service/wsdl:port
 *
 * @author Vivek Pandey
 */
public interface WSDLPort extends WSDLFeaturedObject, WSDLExtensible {
    /**
     * Gets wsdl:port@name attribute value as local name and wsdl:definitions@targetNamespace
     * as the namespace uri.
     */
    QName getName();

    /**
     * Gets {@link WSDLBoundPortType} associated with the {@link WSDLPort}.
     */
    @NotNull
    WSDLBoundPortType getBinding();

    /**
     * Gets endpoint address of this port.
     *
     * @return
     *      always non-null.
     */
    EndpointAddress getAddress();

    /**
     * Gets the {@link WSDLService} that owns this port.
     *
     * @return
     *      always non-null.
     */
    @NotNull
    WSDLService getOwner();

    /**
     * Returns endpoint reference
     * @return Endpoint reference
     */
    public @Nullable WSEndpointReference getEPR();
}
