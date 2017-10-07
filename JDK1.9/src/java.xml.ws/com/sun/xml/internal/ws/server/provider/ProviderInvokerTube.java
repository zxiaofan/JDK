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

package com.sun.xml.internal.ws.server.provider;

import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.api.pipe.Tube;
import com.sun.xml.internal.ws.api.server.AsyncProvider;
import com.sun.xml.internal.ws.api.server.Container;
import com.sun.xml.internal.ws.api.server.Invoker;
import com.sun.xml.internal.ws.api.server.ProviderInvokerTubeFactory;
import com.sun.xml.internal.ws.binding.SOAPBindingImpl;
import com.sun.xml.internal.ws.server.InvokerTube;

import javax.xml.ws.Provider;

/**
 * This {@link Tube} is used to invoke the {@link Provider} and {@link AsyncProvider} endpoints.
 *
 * @author Jitendra Kotamraju
 */
public abstract class ProviderInvokerTube<T> extends InvokerTube<Provider<T>> {

    protected ProviderArgumentsBuilder<T> argsBuilder;

    /*package*/ ProviderInvokerTube(Invoker invoker, ProviderArgumentsBuilder<T> argsBuilder) {
        super(invoker);
        this.argsBuilder = argsBuilder;
    }

    public static <T> ProviderInvokerTube<T>
    create(final Class<T> implType, final WSBinding binding, final Invoker invoker, final Container container) {

        final ProviderEndpointModel<T> model = new ProviderEndpointModel<T>(implType, binding);
        final ProviderArgumentsBuilder<?> argsBuilder = ProviderArgumentsBuilder.create(model, binding);
        if (binding instanceof SOAPBindingImpl) {
            //set portKnownHeaders on Binding, so that they can be used for MU processing
            ((SOAPBindingImpl) binding).setMode(model.mode);
        }

        return ProviderInvokerTubeFactory.create(null, container, implType, invoker, argsBuilder, model.isAsync);
    }
}
