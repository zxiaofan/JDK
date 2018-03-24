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

package com.sun.xml.internal.ws.api.pipe;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.EndpointAddress;
import com.sun.xml.internal.ws.api.pipe.helper.PipeAdapter;
import com.sun.xml.internal.ws.util.pipe.StandalonePipeAssembler;

import javax.xml.ws.WebServiceException;

/**
 * Factory for transport pipes that enables transport pluggability.
 *
 * <p>
 * At runtime, on the client side, JAX-WS (more specifically the default {@link PipelineAssembler}
 * of JAX-WS client runtime) relies on this factory to create a suitable transport {@link Pipe}
 * that can handle the given {@link EndpointAddress endpoint address}.
 *
 * <p>
 * JAX-WS extensions that provide additional transport support can
 * extend this class and implement the {@link #doCreate} method.
 * They are expected to check the scheme of the endpoint address
 * (and possibly some other settings from bindings), and create
 * their transport pipe implementations accordingly.
 * For example,
 *
 * <pre>
 * class MyTransportPipeFactoryImpl {
 *   Pipe doCreate(...) {
 *     String scheme = address.getURI().getScheme();
 *     if(scheme.equals("foo"))
 *       return new MyTransport(...);
 *     else
 *       return null;
 *   }
 * }
 * </pre>
 *
 * <p>
 * {@link TransportPipeFactory} look-up follows the standard service
 * discovery mechanism, so you need
 * {@code META-INF/services/com.sun.xml.internal.ws.api.pipe.TransportPipeFactory}.
 *
 *
 *
 * <h2>TODO</h2>
 * <p>
 * One of the JAX-WS operation mode is supposedly where it doesn't have no WSDL whatsoever.
 * How do we identify the endpoint in such case?
 *
 * @author Kohsuke Kawaguchi
 * @see StandalonePipeAssembler
 */
public abstract class TransportPipeFactory {
    /**
     * Creates a transport {@link Pipe} for the given port, if this factory can do so,
     * or return null.
     *
     * @param context
     *      Object that captures various contextual information
     *      that can be used to determine the pipeline to be assembled.
     *
     * @return
     *      null to indicate that this factory isn't capable of creating a transport
     *      for this port (which causes the caller to search for other {@link TransportPipeFactory}s
     *      that can. Or non-null.
     *
     * @throws WebServiceException
     *      if this factory is capable of creating a transport pipe but some fatal
     *      error prevented it from doing so. This exception will be propagated
     *      back to the user application, and no further {@link TransportPipeFactory}s
     *      are consulted.
     */
    public abstract Pipe doCreate(@NotNull ClientPipeAssemblerContext context);

    /**
     * Locates {@link PipelineAssemblerFactory}s and create
     * a suitable {@link PipelineAssembler}.
     *
     * @param classLoader
     *      used to locate {@code META-INF/servces} files.
     * @return
     *      Always non-null, since we fall back to our default {@link PipelineAssembler}.
     *
     * @deprecated
     *      Use {@link TransportTubeFactory#create(ClassLoader, ClientTubeAssemblerContext)}
     */
    public static Pipe create(@Nullable ClassLoader classLoader, @NotNull ClientPipeAssemblerContext context) {
        return PipeAdapter.adapt(TransportTubeFactory.create(classLoader,context));
    }
}
