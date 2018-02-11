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
import com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe;
import com.sun.xml.internal.ws.util.ServiceFinder;
import com.sun.xml.internal.ws.util.pipe.StandaloneTubeAssembler;
import java.util.logging.Level;

import javax.xml.ws.WebServiceException;
import java.util.logging.Logger;

/**
 * Factory for transport tubes that enables transport pluggability.
 *
 * <p>
 * At runtime, on the client side, JAX-WS (more specifically the default {@link TubelineAssembler}
 * of JAX-WS client runtime) relies on this factory to create a suitable transport {@link Tube}
 * that can handle the given {@link EndpointAddress endpoint address}.
 *
 * <p>
 * JAX-WS extensions that provide additional transport support can
 * extend this class and implement the {@link #doCreate} method.
 * They are expected to check the scheme of the endpoint address
 * (and possibly some other settings from bindings), and create
 * their transport tube implementations accordingly.
 * For example,
 *
 * <pre>
 * class MyTransportTubeFactoryImpl {
 *   Tube doCreate(...) {
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
 * {@link TransportTubeFactory} look-up follows the standard service
 * discovery mechanism, so you need
 * {@code META-INF/services/com.sun.xml.internal.ws.api.pipe.BasicTransportTubeFactory}.
 *
 * @author Jitendra Kotamraju
 * @see StandaloneTubeAssembler
 */
public abstract class TransportTubeFactory {
    /**
     * Creates a transport {@link Tube} for the given port, if this factory can do so,
     * or return null.
     *
     * @param context
     *      Object that captures various contextual information
     *      that can be used to determine the tubeline to be assembled.
     *
     * @return
     *      null to indicate that this factory isn't capable of creating a transport
     *      for this port (which causes the caller to search for other {@link TransportTubeFactory}s
     *      that can. Or non-null.
     *
     * @throws WebServiceException
     *      if this factory is capable of creating a transport tube but some fatal
     *      error prevented it from doing so. This exception will be propagated
     *      back to the user application, and no further {@link TransportTubeFactory}s
     *      are consulted.
     */
    public abstract Tube doCreate(@NotNull ClientTubeAssemblerContext context);

    private static final TransportTubeFactory DEFAULT = new DefaultTransportTubeFactory();
    private static class DefaultTransportTubeFactory extends TransportTubeFactory {

                @Override
                public Tube doCreate(ClientTubeAssemblerContext context) {
                        return createDefault(context);
                }

    }

    /**
     * Locates {@link TransportTubeFactory}s and create a suitable transport {@link Tube}.
     *
     * @param classLoader
     *      used to locate {@code META-INF/servces} files.
     * @return
     *      Always non-null, since we fall back to our default {@link Tube}.
     */
    public static Tube create(@Nullable ClassLoader classLoader, @NotNull ClientTubeAssemblerContext context) {
        for (TransportTubeFactory factory : ServiceFinder.find(TransportTubeFactory.class,classLoader, context.getContainer())) {
            Tube tube = factory.doCreate(context);
            if (tube !=null) {
                if (logger.isLoggable(Level.FINE)) {
                    TransportTubeFactory.logger.log(Level.FINE, "{0} successfully created {1}", new Object[]{factory.getClass(), tube});
                }
                return tube;
            }
        }

        // See if there is a {@link TransportPipeFactory} out there and use it for compatibility.
        ClientPipeAssemblerContext ctxt = new ClientPipeAssemblerContext(
                context.getAddress(), context.getWsdlModel(), context.getService(),
                context.getBinding(), context.getContainer());
        ctxt.setCodec(context.getCodec());
        for (TransportPipeFactory factory : ServiceFinder.find(TransportPipeFactory.class,classLoader)) {
            Pipe pipe = factory.doCreate(ctxt);
            if (pipe!=null) {
                if (logger.isLoggable(Level.FINE)) {
                    logger.log(Level.FINE, "{0} successfully created {1}", new Object[]{factory.getClass(), pipe});
                }
                return PipeAdapter.adapt(pipe);
            }
        }

        return DEFAULT.createDefault(ctxt);
    }

    protected Tube createDefault(ClientTubeAssemblerContext context) {
        // default built-in transports
        String scheme = context.getAddress().getURI().getScheme();
        if (scheme != null) {
            if(scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https"))
                return createHttpTransport(context);
        }
        throw new WebServiceException("Unsupported endpoint address: "+context.getAddress());    // TODO: i18n
    }

    protected Tube createHttpTransport(ClientTubeAssemblerContext context) {
        return new HttpTransportPipe(context.getCodec(), context.getBinding());
    }

    private static final Logger logger = Logger.getLogger(TransportTubeFactory.class.getName());
}
