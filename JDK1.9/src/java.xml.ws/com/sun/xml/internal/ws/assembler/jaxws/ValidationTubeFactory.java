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

package com.sun.xml.internal.ws.assembler.jaxws;

import com.sun.xml.internal.ws.api.pipe.Tube;
import com.sun.xml.internal.ws.assembler.dev.ClientTubelineAssemblyContext;
import com.sun.xml.internal.ws.assembler.dev.ServerTubelineAssemblyContext;
import com.sun.xml.internal.ws.assembler.dev.TubeFactory;

import javax.xml.ws.WebServiceException;

/**
 * TubeFactory implementation creating one of the standard JAX-WS RI tubes
 *
 * @author Marek Potociar (marek.potociar at sun.com)
 */
public final class ValidationTubeFactory implements TubeFactory {

    @Override
    public Tube createTube(ClientTubelineAssemblyContext context) throws WebServiceException {
        return context.getWrappedContext().createValidationTube(context.getTubelineHead());
    }

    @Override
    public Tube createTube(ServerTubelineAssemblyContext context) throws WebServiceException {
        return context.getWrappedContext().createValidationTube(context.getTubelineHead());
    }
}
