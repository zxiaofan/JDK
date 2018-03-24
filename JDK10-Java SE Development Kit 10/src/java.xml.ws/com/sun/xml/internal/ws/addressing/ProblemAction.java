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

package com.sun.xml.internal.ws.addressing;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sun.xml.internal.ws.addressing.W3CAddressingConstants;

/**
 * @author Arun Gupta
 */
@XmlRootElement(name="ProblemAction", namespace= W3CAddressingConstants.WSA_NAMESPACE_NAME)
public class ProblemAction {

    @XmlElement(name="Action", namespace=W3CAddressingConstants.WSA_NAMESPACE_NAME)
    private String action;

    @XmlElement(name="SoapAction", namespace=W3CAddressingConstants.WSA_NAMESPACE_NAME)
    private String soapAction;

    /** Creates a new instance of ProblemAction */
    public ProblemAction() {
    }

    public ProblemAction(String action) {
        this.action = action;
    }

    public ProblemAction(String action, String soapAction) {
        this.action = action;
        this.soapAction = soapAction;
    }

    public String getAction() {
        return action;
    }

    public String getSoapAction() {
        return soapAction;
    }
}
