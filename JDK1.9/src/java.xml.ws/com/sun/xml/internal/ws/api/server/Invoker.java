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

package com.sun.xml.internal.ws.api.server;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.message.Packet;

import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hides the detail of calling into application endpoint implementation.
 *
 * <p>
 * Typical host of the JAX-WS RI would want to use
 * {@link InstanceResolver#createDefault(Class)} and then
 * use {@link InstanceResolver#createInvoker()} to obtain
 * the default invoker implementation.
 *
 *
 * @author Jitendra Kotamraju
 * @author Kohsuke Kawaguchi
 */
public abstract class Invoker extends com.sun.xml.internal.ws.server.sei.Invoker {
    /**
     * Called by {@link WSEndpoint} when it's set up.
     *
     * <p>
     * This is an opportunity for {@link Invoker}
     * to do a endpoint-specific initialization process.
     *
     * @param wsc
     *      The {@link WebServiceContext} instance that can be injected
     *      to the user instances.
     * @param endpoint
     */
    public void start(@NotNull WSWebServiceContext wsc, @NotNull WSEndpoint endpoint) {
        // backward compatibility
        start(wsc);
    }

    /**
     * @deprecated
     *      Use {@link #start(WSWebServiceContext,WSEndpoint)}
     */
    public void start(@NotNull WebServiceContext wsc) {
        throw new IllegalStateException("deprecated version called");
    }

    /**
     * Called by {@link WSEndpoint}
     * when {@link WSEndpoint#dispose()} is called.
     *
     * This allows {@link InstanceResolver} to do final clean up.
     *
     * <p>
     * This method is guaranteed to be only called once by {@link WSEndpoint}.
     */
    public void dispose() {}

    /**
     * Invokes {@link Provider#invoke(Object)}
     */
    public <T> T invokeProvider( @NotNull Packet p, T arg ) throws IllegalAccessException, InvocationTargetException {
        // default slow implementation that delegates to the other invoke method.
        return (T)invoke(p,invokeMethod,arg);
    }

    /**
     * Invokes {@link AsyncProvider#invoke(Object, AsyncProviderCallback, WebServiceContext)}
     */
    public <T> void invokeAsyncProvider( @NotNull Packet p, T arg, AsyncProviderCallback cbak, WebServiceContext ctxt ) throws IllegalAccessException, InvocationTargetException {
        // default slow implementation that delegates to the other invoke method.
        invoke(p, asyncInvokeMethod, arg, cbak, ctxt);
    }

    private static final Method invokeMethod;

    static {
        try {
            invokeMethod = Provider.class.getMethod("invoke",Object.class);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    private static final Method asyncInvokeMethod;

    static {
        try {
            asyncInvokeMethod = AsyncProvider.class.getMethod("invoke",Object.class, AsyncProviderCallback.class, WebServiceContext.class);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }
}
