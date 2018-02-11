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

package com.sun.xml.internal.ws.server.sei;

import com.oracle.webservices.internal.api.databinding.JavaCallInfo;
import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.sun.xml.internal.ws.api.server.Invoker;
import com.sun.xml.internal.ws.client.sei.MethodHandler;
import com.sun.xml.internal.ws.model.AbstractSEIModelImpl;
import com.sun.xml.internal.ws.server.InvokerTube;
import com.sun.xml.internal.ws.wsdl.DispatchException;
import java.lang.reflect.InvocationTargetException;

/**
 * This pipe is used to invoke SEI based endpoints.
 *
 * @author Jitendra Kotamraju
 */
public class SEIInvokerTube extends InvokerTube {

    /**
     * For each method on the port interface we have
     * a {@link MethodHandler} that processes it.
     */
    private final WSBinding binding;
    private final AbstractSEIModelImpl model;

    public SEIInvokerTube(AbstractSEIModelImpl model,Invoker invoker, WSBinding binding) {
        super(invoker);
        this.binding = binding;
        this.model = model;
    }

    /**
     * This binds the parameters for SEI endpoints and invokes the endpoint method. The
     * return value, and response Holder arguments are used to create a new {@link Message}
     * that traverses through the Pipeline to transport.
     */
    public @NotNull NextAction processRequest(@NotNull Packet req) {
                JavaCallInfo call = model.getDatabinding().deserializeRequest(req);
                if (call.getException() == null) {
                        try {
                                if (req.getMessage().isOneWay(model.getPort()) && req.transportBackChannel != null) {
                                        req.transportBackChannel.close();
                                }
                                Object ret = getInvoker(req).invoke(req, call.getMethod(), call.getParameters());
                                call.setReturnValue(ret);
                                } catch (InvocationTargetException e) {
                                        call.setException(e);
                                } catch (Exception e) {
                                        call.setException(e);
                                }
                        } else if (call.getException() instanceof DispatchException) {
                            DispatchException e = (DispatchException)call.getException();
                            return doReturnWith(req.createServerResponse(e.fault, model.getPort(), null, binding));
                        }
                        Packet res = (Packet) model.getDatabinding().serializeResponse(call);
                        res = req.relateServerResponse(res, req.endpoint.getPort(), model, req.endpoint.getBinding());
            assert res != null;
            return doReturnWith(res);
    }

    public @NotNull NextAction processResponse(@NotNull Packet response) {
        return doReturnWith(response);
    }

    public @NotNull NextAction processException(@NotNull Throwable t) {
        return doThrow(t);
    }

}
