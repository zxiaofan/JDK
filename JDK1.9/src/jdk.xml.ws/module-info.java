/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines tools for JAX-WS classes and WSDL generation,
 * including the <em>{@index wsgen wsgen tool}</em>
 * and <em>{@index wsimport wsimport tool}</em> tools.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:
 * <dd>{@extLink wsgen_tool_reference wsgen},
 *     {@extLink wsimport_tool_reference wsimport}
 * </dl>
 *
 * @moduleGraph
 * @since 9
 */
@Deprecated(since="9", forRemoval=true)
module jdk.xml.ws {
    requires java.compiler;
    requires java.logging;
    requires java.rmi;
    requires java.xml;
    requires java.xml.bind;
    requires java.xml.ws;
    requires jdk.xml.bind;

    uses com.sun.tools.internal.ws.wscompile.Plugin;

    provides com.sun.tools.internal.ws.wscompile.Plugin with
        com.sun.tools.internal.ws.wscompile.plugin.at_generated.PluginImpl;
}

