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

package com.sun.xml.internal.ws.client;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.model.SEIModel;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPort;
import com.sun.xml.internal.ws.binding.BindingImpl;
import com.sun.xml.internal.ws.binding.SOAPBindingImpl;
import com.sun.xml.internal.ws.binding.WebServiceFeatureList;
import com.sun.xml.internal.ws.model.SOAPSEIModel;

import javax.xml.ws.WebServiceFeature;

/**
 * {@link PortInfo} that has {@link SEIModel}.
 *
 * This object is created statically when {@link WSServiceDelegate} is created
 * with an service interface.
 *
 * NOTE: Made this class public so that Dispatch instances derived from a
 *       'parent' SEI-based port instance (generally for sending protocol
 *       messages or request retries) can still know what the parent's SEI was.
 *
 * @author Kohsuke Kawaguchi
 */
public final class SEIPortInfo extends PortInfo {

    public final Class sei;

    /**
     * Model of {@link #sei}.
     */
    public final SOAPSEIModel model;

    public SEIPortInfo(WSServiceDelegate owner, Class sei, SOAPSEIModel model, @NotNull WSDLPort portModel) {
        super(owner, portModel);
        this.sei = sei;
        this.model = model;
        assert sei != null && model != null;
    }

    @Override
    public BindingImpl createBinding(WebServiceFeature[] webServiceFeatures, Class<?> portInterface) {
        BindingImpl binding = super.createBinding(webServiceFeatures, portInterface);
        return setKnownHeaders(binding);
    }

    public BindingImpl createBinding(WebServiceFeatureList webServiceFeatures, Class<?> portInterface) {
        // not to pass in (BindingImpl) model.getWSBinding()
        BindingImpl binding = super.createBinding(webServiceFeatures, portInterface, null);
        return setKnownHeaders(binding);
    }

    private BindingImpl setKnownHeaders(BindingImpl binding) {
        if (binding instanceof SOAPBindingImpl) {
            ((SOAPBindingImpl) binding).setPortKnownHeaders(model.getKnownHeaders());
        }
        return binding;
    }
}
