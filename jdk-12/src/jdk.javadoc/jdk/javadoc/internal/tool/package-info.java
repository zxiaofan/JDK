/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
 *  Provides the front end for the javadoc tool.
 *
 *  <p>The main entry points are in {@link jdk.javadoc.internal.tool.Main}
 *  which calls the (poorly-named) {@link jdk.javadoc.internal.tool.Start}
 *  which provides the overall functionality of the tool.
 *
 *  <p>The classes provide a framework for processing command-line options
 *  and determining the set of elements (modules, packages, types and members)
 *  to be documented.
 *
 *  <p>The classes also provide the means to use the javac front end to read
 *  source files, including the documentation comments.
 *
 *  <p>Finally, once the appropriate files have been read, the classes invoke
 *  the selected doclet to process those files, typically to generate API
 *  documentation.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
package jdk.javadoc.internal.tool;
