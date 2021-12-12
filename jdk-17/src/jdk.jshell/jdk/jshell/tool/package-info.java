/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
 * Provides a mechanism to launch an instance of a Java shell tool.
 * Allows configuration of the tool before launching. A builder is used
 * to configure and launch the tool.
 * <p>
 * At the simplest, a builder is retrieved, and the builder is used to start the
 * tool:
 * <pre>
 * {@code
 *       JavaShellToolBuilder
 *             .builder()
 *             .start();
 * }
 * </pre>
 * The builder can be configured and the start can have arguments:
 * <pre>
 * {@code
 *       JavaShellToolBuilder
 *             .builder()
 *             .out(myCommandPrintStream, myOutputPrintStream)
 *             .locale(Locale.CANADA)
 *             .start("--feedback", "silent", "MyStart");
 * }
 * </pre>
 *
 * @since 9
 */


package jdk.jshell.tool;

