/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Defines tools for analysing dependencies in Java libraries and programs,
 * including the <em>{@index jdeps jdeps tool}</em>,
 * <em>{@index javap javap tool}</em>, and
 * <em>{@index jdeprscan jdeprscan tool}</em> tools.
 *
 * <p>
 * This module provides the equivalent of command-line access to the
 * <em>javap</em> and <em>jdeps</em> tools via the
 * {@link java.util.spi.ToolProvider ToolProvider} service provider
 * interface (SPI)</p>
 *
 * <p> Instances of the tools can be obtained by calling
 * {@link java.util.spi.ToolProvider#findFirst ToolProvider.findFirst}
 * or the {@linkplain java.util.ServiceLoader service loader} with the name
 * {@code "javap"} or {@code "jdeps"} as appropriate.
 *
 * <p>
 * <em>jdeprscan</em> only exists as a command line tool, and does not provide
 * any direct API.
 *
 * @toolGuide javap
 * @toolGuide jdeprscan
 * @toolGuide jdeps
 *
 * @provides java.util.spi.ToolProvider
 *
 * @moduleGraph
 * @since 9
 */
module jdk.jdeps {
    requires java.compiler;
    requires jdk.compiler;

    exports com.sun.tools.classfile to jdk.jlink;

    provides java.util.spi.ToolProvider with
        com.sun.tools.javap.Main.JavapToolProvider,
        com.sun.tools.jdeps.Main.JDepsToolProvider;
}
