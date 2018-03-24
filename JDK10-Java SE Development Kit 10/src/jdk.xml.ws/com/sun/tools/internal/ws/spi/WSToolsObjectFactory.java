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

package com.sun.tools.internal.ws.spi;

import com.sun.tools.internal.ws.util.WSToolsObjectFactoryImpl;
import com.sun.xml.internal.ws.api.server.Container;

import java.io.OutputStream;


/**
 * Singleton abstract factory used to produce JAX-WS tools related objects.
 *
 * @author JAX-WS Development Team
 */
public abstract class WSToolsObjectFactory {

    private static final WSToolsObjectFactory factory = new WSToolsObjectFactoryImpl();

    /**
     * Obtain an instance of a factory. Don't worry about synchronization(at the
     * most, one more factory is created).
     */
    public static WSToolsObjectFactory newInstance() {
        return factory;
    }

    /**
     * Invokes wsimport on the wsdl URL argument, and generates the necessary
     * portable artifacts like SEI, Service, Bean classes etc.
     *
     * @param logStream Stream used for reporting log messages like errors, warnings etc
     * @param container gives an environment for tool if it is run during appserver
     *                  deployment
     * @param args arguments with various options and wsdl url
     *
     * @return true if there is no error, otherwise false
     */
    public abstract boolean wsimport(OutputStream logStream, Container container, String[] args);

    /**
     * Invokes wsimport on the wsdl URL argument, and generates the necessary
     * portable artifacts like SEI, Service, Bean classes etc.
     *
     * @return true if there is no error, otherwise false
     *
     * @see #wsimport(OutputStream, Container, String[])
     */
    public boolean wsimport(OutputStream logStream, String[] args) {
        return wsimport(logStream, Container.NONE, args);
    }

    /**
     * Invokes wsgen on the endpoint implementation, and generates the necessary
     * artifacts like wrapper, exception bean classes etc.
     *
     * @param logStream Stream used for reporting log messages like errors, warnings etc
     * @param container gives an environment for tool if it is run during appserver
     *                  deployment
     * @param args arguments with various options and endpoint class
     *
     * @return true if there is no error, otherwise false
     */
    public abstract boolean wsgen(OutputStream logStream, Container container, String[] args);

    /**
     * Invokes wsgen on the endpoint implementation, and generates the necessary
     * artifacts like wrapper, exception bean classes etc.
     *
     * @return true if there is no error, otherwise false
     * @see #wsgen(OutputStream, Container, String[])
     */
    public boolean wsgen(OutputStream logStream, String[] args) {
        return wsgen(logStream, Container.NONE, args);
    }

}
