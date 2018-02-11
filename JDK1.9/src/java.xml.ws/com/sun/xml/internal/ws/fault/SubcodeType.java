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

package com.sun.xml.internal.ws.fault;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * <pre>
 *      &lt;env:Subcode>
 *          &lt;env:Value>m:MessageTimeout1&lt;/env:Value>
 *          &lt;env:Subcode>
 *              &lt;env:Value>m:MessageTimeout2&lt;/env:Value>
 *          &lt;/env:Subcode>
 *      &lt;/env:Subcode>
 *  </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubcodeType", namespace = "http://www.w3.org/2003/05/soap-envelope", propOrder = {
    "Value",
    "Subcode"
        })
class SubcodeType {
    @XmlTransient
    private static final String ns="http://www.w3.org/2003/05/soap-envelope";
    /**
     * mandatory, minOccurs=1
     */
    @XmlElement(namespace = ns)
    private QName Value;

    /**
     * optional, minOcccurs=0
     */
    @XmlElements(@XmlElement(namespace = ns))
    private SubcodeType Subcode;

    public SubcodeType(QName value) {
        Value = value;
    }

    public SubcodeType() {
    }

    QName getValue() {
        return Value;
    }

    SubcodeType getSubcode() {
        return Subcode;
    }

    void setSubcode(SubcodeType subcode) {
        Subcode = subcode;
    }
}
