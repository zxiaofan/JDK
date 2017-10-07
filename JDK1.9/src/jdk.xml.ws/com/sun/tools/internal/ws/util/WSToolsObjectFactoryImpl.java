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

package com.sun.tools.internal.ws.util;

import com.sun.tools.internal.ws.spi.WSToolsObjectFactory;
import com.sun.tools.internal.ws.wscompile.WsgenTool;
import com.sun.tools.internal.ws.wscompile.WsimportTool;
import com.sun.xml.internal.ws.api.server.Container;

import java.io.OutputStream;

/**
 * Factory implementation class to instantiate concrete objects for JAX-WS tools.
 *
 * @author JAX-WS Development Team
 */
public class WSToolsObjectFactoryImpl extends WSToolsObjectFactory {

    @Override
    public boolean wsimport(OutputStream logStream, Container container, String[] args) {
        WsimportTool tool = new WsimportTool(logStream, container);
        return tool.run(args);
    }

    @Override
    public boolean wsgen(OutputStream logStream, Container container, String[] args) {
        WsgenTool tool = new WsgenTool(logStream, container);
        return tool.run(args);
    }
}
