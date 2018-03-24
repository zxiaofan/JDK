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

import com.oracle.webservices.internal.api.message.BasePropertySet;
import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.model.SEIModel;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPort;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;


import org.xml.sax.InputSource;

/**
 * Properties exposed from {@link WSDLPort} for {@link MessageContext}.
 * Donot add this satellite if {@link WSDLPort} is null.
 *
 * @author Jitendra Kotamraju
 */
public abstract class WSDLProperties extends BasePropertySet {

    private static final PropertyMap model;
    static {
        model = parse(WSDLProperties.class);
    }

    private final @Nullable SEIModel seiModel;

    protected WSDLProperties(@Nullable SEIModel seiModel) {
        this.seiModel = seiModel;
    }

    @Property(MessageContext.WSDL_SERVICE)
    public abstract QName getWSDLService();

    @Property(MessageContext.WSDL_PORT)
    public abstract QName getWSDLPort();

    @Property(MessageContext.WSDL_INTERFACE)
    public abstract QName getWSDLPortType();

    @Property(MessageContext.WSDL_DESCRIPTION)
    public InputSource getWSDLDescription() {
        return seiModel != null ? new InputSource(seiModel.getWSDLLocation()) : null;
    }

    @Override
    protected PropertyMap getPropertyMap() {
        return model;
    }

}
