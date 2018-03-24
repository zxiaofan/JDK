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

package com.sun.xml.internal.ws.assembler.dev;

import com.sun.xml.internal.ws.api.pipe.Tube;

import javax.xml.ws.WebServiceException;

/**
 * @author Marek Potociar (marek.potociar at sun.com)
 */
public interface TubeFactory {
    /**
     * Adds RM tube to the client-side tubeline, depending on whether RM is enabled or not.
     *
     * @param context wsit client tubeline assembler context
     * @return new tail of the client-side tubeline
     */
    Tube createTube(ClientTubelineAssemblyContext context) throws WebServiceException;

    /**
     * Adds RM tube to the service-side tubeline, depending on whether RM is enabled or not.
     *
     * @param context wsit service tubeline assembler context
     * @return new head of the service-side tubeline
     */
    Tube createTube(ServerTubelineAssemblyContext context) throws WebServiceException;

}
