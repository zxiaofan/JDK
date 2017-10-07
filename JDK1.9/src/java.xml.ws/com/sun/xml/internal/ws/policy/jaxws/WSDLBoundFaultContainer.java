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

package com.sun.xml.internal.ws.policy.jaxws;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundFault;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLObject;

import org.xml.sax.Locator;

/**
 * We need data from the WSDL operation that the default WSDLBoundFault does not
 * give us. This class holds all the necessary data.
 *
 * @author Fabian Ritzmann
 */
class WSDLBoundFaultContainer implements WSDLObject {

    private final WSDLBoundFault boundFault;
    private final WSDLBoundOperation boundOperation;

    public WSDLBoundFaultContainer(final WSDLBoundFault fault, final WSDLBoundOperation operation) {
        this.boundFault = fault;
        this.boundOperation = operation;
    }

    public Locator getLocation() {
        return null;
    }

    public WSDLBoundFault getBoundFault() {
        return this.boundFault;
    }

    public WSDLBoundOperation getBoundOperation() {
        return this.boundOperation;
    }

}
