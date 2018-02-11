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

package com.sun.xml.internal.ws.wsdl.parser;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLModel;
import com.sun.xml.internal.ws.api.server.Container;
import com.sun.xml.internal.ws.api.wsdl.parser.WSDLParserExtensionContext;
import com.sun.xml.internal.ws.api.policy.PolicyResolver;

/**
 * Provides implementation of {@link WSDLParserExtensionContext}
 *
 * @author Vivek Pandey
 * @author Fabian Ritzmann
 */
final class WSDLParserExtensionContextImpl implements WSDLParserExtensionContext {
    private final boolean isClientSide;
    private final EditableWSDLModel wsdlModel;
    private final Container container;
    private final PolicyResolver policyResolver;

    /**
     * Construct {@link WSDLParserExtensionContextImpl} with information that whether its on client side
     * or server side.
     */
    protected WSDLParserExtensionContextImpl(EditableWSDLModel model, boolean isClientSide, Container container, PolicyResolver policyResolver) {
        this.wsdlModel = model;
        this.isClientSide = isClientSide;
        this.container = container;
        this.policyResolver = policyResolver;
    }

    public boolean isClientSide() {
        return isClientSide;
    }

    public EditableWSDLModel getWSDLModel() {
        return wsdlModel;
    }

    public Container getContainer() {
        return this.container;
    }

    public PolicyResolver getPolicyResolver() {
        return policyResolver;
    }
}
