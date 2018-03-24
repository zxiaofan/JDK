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

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.model.SEIModel;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPort;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;

/**
 * Properties exposed from {@link WSDLPort} for {@link MessageContext}.
 * Donot add this satellite if {@link WSDLPort} is null.
 *
 * @author Jitendra Kotamraju
 */
public final class WSDLPortProperties extends WSDLProperties {

    private final @NotNull WSDLPort port;

    public WSDLPortProperties(@NotNull WSDLPort port) {
        this(port, null);
    }

    public WSDLPortProperties(@NotNull WSDLPort port, @Nullable SEIModel seiModel) {
        super(seiModel);
        this.port = port;
    }

    public QName getWSDLService() {
        return port.getOwner().getName();
    }

    public QName getWSDLPort() {
        return port.getName();
    }

    public QName getWSDLPortType() {
        return port.getBinding().getPortTypeName();
    }
}
