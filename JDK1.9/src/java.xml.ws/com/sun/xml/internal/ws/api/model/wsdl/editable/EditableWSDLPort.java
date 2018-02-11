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

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.EndpointAddress;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPort;

public interface EditableWSDLPort extends WSDLPort {

    @Override
    @NotNull
    EditableWSDLBoundPortType getBinding();

    @Override
    @NotNull
    EditableWSDLService getOwner();

    /**
     * Sets endpoint address
     *
     * @param address Endpoint address
     */
    public void setAddress(EndpointAddress address);

    /**
     * Sets endpoint reference
     *
     * @param epr Endpoint reference
     */
    public void setEPR(@NotNull WSEndpointReference epr);

    /**
     * Freezes WSDL model to prevent further modification
     *
     * @param root WSDL Model
     */
    void freeze(EditableWSDLModel root);
}
