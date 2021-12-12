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
 * Defines the implementation of the
 * {@linkplain javax.tools.ToolProvider#getSystemDocumentationTool system documentation tool}
 * and its command-line equivalent, <em>{@index javadoc javadoc tool}</em>.
 *
 * <h2 style="font-family:'DejaVu Sans Mono', monospace; font-style:italic">javadoc</h2>
 *
 * <p>
 * This module provides the equivalent of command-line access to <em>javadoc</em>
 * via the {@link java.util.spi.ToolProvider ToolProvider} and
 * {@link javax.tools.Tool} service provider interfaces (SPIs),
 * and more flexible access via the {@link javax.tools.DocumentationTool DocumentationTool}
 * SPI.</p>
 *
 * <p> Instances of the tools can be obtained by calling
 * {@link java.util.spi.ToolProvider#findFirst ToolProvider.findFirst}
 * or the {@linkplain java.util.ServiceLoader service loader} with the name
 * {@code "javadoc"}.
 *
 * @toolGuide javadoc
 *
 * @provides java.util.spi.ToolProvider
 * @provides javax.tools.DocumentationTool
 * @provides javax.tools.Tool
 *
 * @see <a href="{@docRoot}/../specs/javadoc/doc-comment-spec.html">
 *      Documentation Comment Specification for the Standard Doclet</a>
 *
 * @moduleGraph
 * @since 9
 */
module jdk.javadoc {
    requires java.xml;

    requires transitive java.compiler;
    requires transitive jdk.compiler;

    exports jdk.javadoc.doclet;

    provides java.util.spi.ToolProvider with
        jdk.javadoc.internal.tool.JavadocToolProvider;

    provides javax.tools.DocumentationTool with
        jdk.javadoc.internal.api.JavadocTool;

    provides javax.tools.Tool with
        jdk.javadoc.internal.api.JavadocTool;

    provides com.sun.tools.doclint.DocLint with
            jdk.javadoc.internal.doclint.DocLint;
}
