/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * @toolGuide jar
 * @toolGuide jarsigner
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
