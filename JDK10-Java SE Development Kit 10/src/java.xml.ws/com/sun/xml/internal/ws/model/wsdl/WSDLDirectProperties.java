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

package com.sun.xml.internal.ws.model.wsdl;

import com.sun.xml.internal.ws.api.model.SEIModel;

import javax.xml.namespace.QName;

/**
 * Replacement for {@link WSDLPortProperties} for when elements from the WSDL are known,
 * but the full WSDL is not available.
 *
 */
public final class WSDLDirectProperties extends WSDLProperties {
        private final QName serviceName;
        private final QName portName;

    public WSDLDirectProperties(QName serviceName, QName portName) {
        this(serviceName, portName, null);
    }

    public WSDLDirectProperties(QName serviceName, QName portName, SEIModel seiModel) {
        super(seiModel);
        this.serviceName = serviceName;
        this.portName = portName;
    }

    public QName getWSDLService() {
        return serviceName;
    }

    public QName getWSDLPort() {
        return portName;
    }

    public QName getWSDLPortType() {
        return null;
    }
}
