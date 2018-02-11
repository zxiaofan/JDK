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

import com.sun.xml.internal.ws.api.BindingID;
import com.sun.xml.internal.ws.util.ServiceFinder;

import javax.xml.ws.soap.SOAPBinding;
import java.util.logging.Logger;

/**
 * Creates {@link PipelineAssembler}.
 *
 * <p>
 * To create a pipeline,
 * the JAX-WS runtime locates {@link PipelineAssemblerFactory}s through
 * the {@code META-INF/services/com.sun.xml.internal.ws.api.pipe.PipelineAssemblerFactory} files.
 * Factories found are checked to see if it supports the given binding ID one by one,
 * and the first valid {@link PipelineAssembler} returned will be used to create
 * a pipeline.
 *
 * <p>
 * TODO: is bindingId really extensible? for this to be extensible,
 * someone seems to need to hook into WSDL parsing.
 *
 * <p>
 * TODO: JAX-WSA might not define its own binding ID -- it may just go to an extension element
 * of WSDL. So this abstraction might need to be worked on.
 *
 * @author Kohsuke Kawaguchi
 * @deprecated
 *      Use {@link TubelineAssemblerFactory} instead.
 */
public abstract class PipelineAssemblerFactory {
    /**
     * Creates a {@link PipelineAssembler} applicable for the given binding ID.
     *
     * @param bindingId
     *      The binding ID for which a pipeline will be created,
     *      such as {@link SOAPBinding#SOAP11HTTP_BINDING}.
     *      Must not be null.
     *
     * @return
     *      null if this factory doesn't recognize the given binding ID.
     */
    public abstract PipelineAssembler doCreate(BindingID bindingId);

    /**
     * Locates {@link PipelineAssemblerFactory}s and create
     * a suitable {@link PipelineAssembler}.
     *
     * @param bindingId
     *      The binding ID string for which the new {@link PipelineAssembler}
     *      is created. Must not be null.
     * @return
     *      Always non-null, since we fall back to our default {@link PipelineAssembler}.
     */
    public static PipelineAssembler create(ClassLoader classLoader, BindingID bindingId) {
        for (PipelineAssemblerFactory factory : ServiceFinder.find(PipelineAssemblerFactory.class,classLoader)) {
            PipelineAssembler assembler = factory.doCreate(bindingId);
            if(assembler!=null) {
                logger.fine(factory.getClass()+" successfully created "+assembler);
                return assembler;
            }
        }

        // default binding IDs that are known
        // TODO: replace this with proper ones
        return new com.sun.xml.internal.ws.util.pipe.StandalonePipeAssembler();
    }

    private static final Logger logger = Logger.getLogger(PipelineAssemblerFactory.class.getName());
}
