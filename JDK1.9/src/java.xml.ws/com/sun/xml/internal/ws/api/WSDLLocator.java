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

package com.sun.xml.internal.ws.api;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.Service;

/**
 * Used to locate WSDL documents; particularly useful for J2EE deployment archives
 *
 * @since 2.2.6
 */
public abstract class WSDLLocator {

    /**
     * Returns the actual WSDL location
     *
     * @param service Service class
     * @param wsdlLoc Designates the WSDL location either from the service class
     * or through other means
     * @return the actual WSDL location, if found, or null if not found.
     * @throws MalformedURLException if there is an error in creating URL
     */
    public abstract URL locateWSDL(Class<Service> service, String wsdlLoc) throws MalformedURLException;

}
