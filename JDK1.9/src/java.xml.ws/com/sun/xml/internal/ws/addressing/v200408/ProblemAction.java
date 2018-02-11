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

package com.sun.xml.internal.ws.addressing.v200408;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionAddressingConstants.WSA_NAMESPACE_NAME;
/**
 * @author Arun Gupta
 */
@XmlRootElement(name="ProblemAction", namespace= WSA_NAMESPACE_NAME)
public class ProblemAction {

    @XmlElement(name="Action", namespace= WSA_NAMESPACE_NAME)
    private String action;

    @XmlElement(name="SoapAction", namespace=WSA_NAMESPACE_NAME)
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
