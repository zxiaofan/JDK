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
import com.sun.xml.internal.ws.server.DefaultResourceInjector;

import javax.annotation.PostConstruct;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;

/**
 * Represents a functionality of the container to inject resources
 * to application service endpoint object (usually but not necessarily as per JavaEE spec.)
 *
 * <p>
 * If {@link Container#getSPI(Class)} returns a valid instance of {@link ResourceInjector},
 * The JAX-WS RI will call the {@link #inject} method for each service endpoint
 * instance that it manages.
 *
 * <p>
 * The JAX-WS RI will be responsible for calling {@link PostConstruct} callback,
 * so implementations of this class need not do so.
 *
 * @author Kohsuke Kawaguchi
 * @see Container
 */
public abstract class ResourceInjector {
    /**
     * Performs resource injection.
     *
     * @param context
     *      {@link WebServiceContext} implementation to be injected into the instance.
     * @param instance
     *      Instance of the service endpoint class to which resources will be injected.
     *
     * @throws WebServiceException
     *      If the resource injection fails.
     */
    public abstract void inject(@NotNull WSWebServiceContext context, @NotNull Object instance);

    /**
     * Fallback {@link ResourceInjector} implementation used when the {@link Container}
     * doesn't provide one.
     *
     * <p>
     * Just inject {@link WSWebServiceContext} and done.
     */
    public static final ResourceInjector STANDALONE = new DefaultResourceInjector();
}
