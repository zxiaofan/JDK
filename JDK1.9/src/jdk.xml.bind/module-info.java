/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
 * Defines tools for JAXB classes and XML schema generation,
 * including the <em>{@index schemagen schemagen tool}</em>
 * and <em>{@index xjc xjc tool}</em> tools.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:
 * <dd>{@extLink schemagen_tool_reference schemagen},
 *     {@extLink xjc_tool_reference xjc}
 * </dl>
 *
 * @moduleGraph
 * @since 9
 */
@Deprecated(since="9", forRemoval=true)
module jdk.xml.bind {
    requires java.activation;
    requires java.compiler;
    requires java.desktop;
    requires java.logging;
    requires java.xml;
    requires java.xml.bind;
    requires jdk.compiler;

    exports com.sun.codemodel.internal to
        jdk.xml.ws;
    exports com.sun.codemodel.internal.writer to
        jdk.xml.ws;
    exports com.sun.istack.internal.tools to
        jdk.xml.ws;
    exports com.sun.tools.internal.jxc.ap to
        jdk.xml.ws;
    exports com.sun.tools.internal.jxc.model.nav to
        jdk.xml.ws;
    exports com.sun.tools.internal.xjc to
        jdk.xml.ws;
    exports com.sun.tools.internal.xjc.api to
        jdk.xml.ws;
    exports com.sun.tools.internal.xjc.reader to
        jdk.xml.ws;
    exports com.sun.tools.internal.xjc.reader.internalizer to
        jdk.xml.ws;
    exports com.sun.tools.internal.xjc.util to
        jdk.xml.ws;
    exports com.sun.xml.internal.xsom.parser to
        jdk.xml.ws;
    // com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BindInfo uses JAXBContext
    exports com.sun.tools.internal.xjc.generator.bean to
       java.xml.bind;

    // XML document content needs to be exported
    opens com.sun.tools.internal.xjc.reader.xmlschema.bindinfo to
        java.xml.bind;

    uses com.sun.tools.internal.xjc.Plugin;

    provides com.sun.tools.internal.xjc.Plugin with
        com.sun.tools.internal.xjc.addon.accessors.PluginImpl,
        com.sun.tools.internal.xjc.addon.at_generated.PluginImpl,
        com.sun.tools.internal.xjc.addon.code_injector.PluginImpl,
        com.sun.tools.internal.xjc.addon.episode.PluginImpl,
        com.sun.tools.internal.xjc.addon.locator.SourceLocationAddOn,
        com.sun.tools.internal.xjc.addon.sync.SynchronizedMethodAddOn;
}

