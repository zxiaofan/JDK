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

package com.sun.xml.internal.ws.api.server;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;
import com.sun.istack.internal.Nullable;

import javax.xml.namespace.QName;

/**
 * Implementations of this class can contribute properties associated with an Endpoint. The properties appear as
 * extensibility elements inside the EndpointReference of the endpoint. If any EPR extensibility elements are configured
 * for an endpoint, the EndpointReference is published inside the WSDL.
 *
 * @since JAX-WS 2.2
 * @author Rama Pulavarthi
 */
public abstract class EndpointReferenceExtensionContributor {
    /**
     *
     * @param extension EPRExtension is passed if an extension with same QName is already configured on the endpoint
     *      via other means (one possible way is by embedding EndpointReference in WSDL).
     *
     * @return  EPRExtension that should be finally configured on an Endpoint.
     */
    public abstract WSEndpointReference.EPRExtension getEPRExtension(WSEndpoint endpoint, @Nullable WSEndpointReference.EPRExtension extension );

    /**
     *
     * @return QName of the extensibility element that is contributed by this extension.
     */
    public abstract QName getQName();
}
