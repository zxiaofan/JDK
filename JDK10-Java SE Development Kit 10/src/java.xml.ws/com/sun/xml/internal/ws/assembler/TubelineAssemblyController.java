/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.assembler;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.logging.Logger;
import com.sun.xml.internal.ws.assembler.dev.ClientTubelineAssemblyContext;
import com.sun.xml.internal.ws.resources.TubelineassemblyMessages;
import com.sun.xml.internal.ws.runtime.config.TubeFactoryConfig;
import com.sun.xml.internal.ws.runtime.config.TubeFactoryList;

import javax.xml.namespace.QName;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Marek Potociar (marek.potociar at sun.com)
 */
final class TubelineAssemblyController {

    private final MetroConfigName metroConfigName;

    TubelineAssemblyController(MetroConfigName metroConfigName) {
        this.metroConfigName = metroConfigName;
    }

    /**
     * Provides a ordered collection of WSIT/Metro client-side tube creators that are be used to
     * construct a client-side Metro tubeline
     *
     * The order of the tube creators in the collection is last-to-first from the
     * client side request message processing perspective.
     *
     * <b>
     * WARNING: This method is part of Metro internal API and may be changed, removed or
     * replaced by a different method without a prior notice. The method SHOULD NOT be used
     * outside of Metro codebase.
     * </b>
     *
     * @param endpointUri URI of the endpoint for which the collection of tube factories should be returned
     *
     * @return collection of WSIT/Metro client-side tube creators
     */
    Collection<TubeCreator> getTubeCreators(ClientTubelineAssemblyContext context) {
        URI endpointUri;
        if (context.getPortInfo() != null) {
            endpointUri = createEndpointComponentUri(context.getPortInfo().getServiceName(), context.getPortInfo().getPortName());
        } else {
            endpointUri = null;
        }

        MetroConfigLoader configLoader = new MetroConfigLoader(context.getContainer(), metroConfigName);
        return initializeTubeCreators(configLoader.getClientSideTubeFactories(endpointUri));
    }

    /**
     * Provides a ordered collection of WSIT/Metro server-side tube creators that are be used to
     * construct a server-side Metro tubeline for a given endpoint
     *
     * The order of the tube creators in the collection is last-to-first from the
     * server side request message processing perspective.
     *
     * <b>
     * WARNING: This method is part of Metro internal API and may be changed, removed or
     * replaced by a different method without a prior notice. The method SHOULD NOT be used
     * outside of Metro codebase.
     * </b>
     *
     * @param endpointUri URI of the endpoint for which the collection of tube factories should be returned
     *
     * @return collection of WSIT/Metro server-side tube creators
     */
    Collection<TubeCreator> getTubeCreators(DefaultServerTubelineAssemblyContext context) {
        URI endpointUri;
        if (context.getEndpoint() != null) {
            endpointUri = createEndpointComponentUri(context.getEndpoint().getServiceName(), context.getEndpoint().getPortName());
        } else {
            endpointUri = null;
        }

        MetroConfigLoader configLoader = new MetroConfigLoader(context.getEndpoint().getContainer(), metroConfigName);
        return initializeTubeCreators(configLoader.getEndpointSideTubeFactories(endpointUri));
    }

    private Collection<TubeCreator> initializeTubeCreators(TubeFactoryList tfl) {
        ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = tccl != null ? tccl : TubelineAssemblyController.class.getClassLoader();

        LinkedList<TubeCreator> tubeCreators = new LinkedList<TubeCreator>();
        for (TubeFactoryConfig tubeFactoryConfig : tfl.getTubeFactoryConfigs()) {
            tubeCreators.addFirst(new TubeCreator(tubeFactoryConfig, classLoader));
        }
        return tubeCreators;
    }

    /*
     * Example WSDL component URI: http://org.sample#wsdl11.port(PingService/HttpPingPort)
     */
    private URI createEndpointComponentUri(@NotNull QName serviceName, @NotNull QName portName) {
        StringBuilder sb = new StringBuilder(serviceName.getNamespaceURI()).append("#wsdl11.port(").append(serviceName.getLocalPart()).append('/').append(portName.getLocalPart()).append(')');
        try {
            return new URI(sb.toString());
        } catch (URISyntaxException ex) {
            Logger.getLogger(TubelineAssemblyController.class).warning(
                    TubelineassemblyMessages.MASM_0020_ERROR_CREATING_URI_FROM_GENERATED_STRING(sb.toString()),
                    ex);
            return null;
        }
    }
}
