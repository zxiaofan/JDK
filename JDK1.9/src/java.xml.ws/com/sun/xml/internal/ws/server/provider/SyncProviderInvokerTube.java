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

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPort;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;
import com.sun.xml.internal.ws.api.server.Invoker;

import javax.xml.ws.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This tube is used to invoke the {@link Provider} endpoints.
 *
 * @author Jitendra Kotamraju
 */
public // TODO needed by factory
class SyncProviderInvokerTube<T> extends ProviderInvokerTube<T> {

    private static final Logger LOGGER = Logger.getLogger(
        com.sun.xml.internal.ws.util.Constants.LoggingDomain + ".server.SyncProviderInvokerTube");

    public SyncProviderInvokerTube(Invoker invoker, ProviderArgumentsBuilder<T> argsBuilder) {
        super(invoker, argsBuilder);
    }

    /*
    * This binds the parameter for Provider endpoints and invokes the
    * invoke() method of {@linke Provider} endpoint. The return value from
    * invoke() is used to create a new {@link Message} that traverses
    * through the Pipeline to transport.
    */
    public NextAction processRequest(Packet request) {
        WSDLPort port = getEndpoint().getPort();
        WSBinding binding = getEndpoint().getBinding();
        T param = argsBuilder.getParameter(request);

        LOGGER.fine("Invoking Provider Endpoint");

        T returnValue;
        try {
            returnValue = getInvoker(request).invokeProvider(request, param);
        } catch(Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            Packet response = argsBuilder.getResponse(request,e,port,binding);
            return doReturnWith(response);
        }
        if (returnValue == null) {
            // Oneway. Send response code immediately for transports(like HTTP)
            // Don't do this above, since close() may generate some exceptions
            if (request.transportBackChannel != null) {
                request.transportBackChannel.close();
            }
        }
        Packet response = argsBuilder.getResponse(request,returnValue,port,binding);

        // Only used by Provider<Packet>
        // Implementation may pass Packet containing throwable; use both
        ThrowableContainerPropertySet tc = response.getSatellite(ThrowableContainerPropertySet.class);
        Throwable t = (tc != null) ? tc.getThrowable() : null;

        return t != null ? doThrow(response, t) : doReturnWith(response);
    }

    public @NotNull NextAction processResponse(@NotNull Packet response) {
        return doReturnWith(response);
    }

    public @NotNull NextAction processException(@NotNull Throwable t) {
        return doThrow(t);
    }

}
