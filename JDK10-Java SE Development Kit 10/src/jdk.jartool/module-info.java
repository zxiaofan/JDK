/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Defines tools for manipulating Java Archive (JAR) files,
 * including the <em>{@index jar jar tool}</em> and
 * <em>{@index jarsigner jarsigner tool}</em> tools.
 * This module also defines APIs for signing JAR files.
 *
 * <p> This module provides the equivalent of command-line access to
 * <em>jar</em> via the {@link java.util.spi.ToolProvider ToolProvider} SPI.
 * Instances of the tool can be obtained by calling
 * {@link java.util.spi.ToolProvider#findFirst ToolProvider.findFirst}
 * or the {@linkplain java.util.ServiceLoader service loader} with the name
 * {@code "jar"}.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:
 * <dd>{@extLink jar_tool_reference jar},
 *     {@extLink jarsigner_tool_reference jarsigner}
 * </dl>
 *
 * @moduleGraph
 * @since 9
 */
module jdk.jartool {
    exports com.sun.jarsigner;
    exports jdk.security.jarsigner;

    provides java.util.spi.ToolProvider with
        sun.tools.jar.JarToolProvider;
}
