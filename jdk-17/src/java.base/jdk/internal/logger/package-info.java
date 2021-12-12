/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
 * <b>[JDK INTERNAL]</b>
 * The {@code jdk.internal.logger} package defines an internal provider
 * whose default naive implementation is replaced by the {@code java.logging}
 * module when the {@code java.logging} module is present.
 * <p>
 * <b>Default Implementation</b>
 * <p>
 * The JDK default implementation of the System.LoggerFinder will attempt to
 * load an installed instance of the {@link jdk.internal.logger.DefaultLoggerFinder}
 * defined in this package.
 * When the {@code java.util.logging} package is present, this will usually
 * resolve to an instance of {@link sun.util.logging.internal.LoggingProviderImpl} -
 * which provides an implementation of the Logger whose backend is a
 * {@link java.util.logging.Logger java.util.logging.Logger}.
 * Configuration can thus be performed by direct access to the regular
 * {@code java.util.logging} APIs,
 * using {@link java.util.logging.Logger java.util.logging.Logger} and
 * {@link java.util.logging.LogManager} to access and configure the backend
 * Loggers.
 * <br>
 * If however {@code java.util.logging} is not linked with the application, then
 * the default implementation will return a simple logger that will print out
 * all log messages of INFO level and above to the console ({@code System.err}),
 * as implemented by the base {@link jdk.internal.logger.DefaultLoggerFinder} class.
 * <p>
 * <b>Message Levels and Mapping to java.util.logging</b>
 * <p>
 * The {@link java.lang.System.LoggerFinder} class documentation describe how
 * {@linkplain java.lang.System.Logger.Level System.Logger levels} are mapped
 * to {@linkplain java.util.logging.Level JUL levels} when {@code
 * java.util.logging} is the backend.
 *
 * @see jdk.internal.logger.DefaultLoggerFinder
 * @see sun.util.logging.internal.LoggingProviderImpl
 * @see java.lang.System.LoggerFinder
 * @see java.lang.System.Logger
 * @see sun.util.logging.PlatformLogger.Bridge
 * @see sun.util.logging.internal
 *
 * @since 9
 */
package jdk.internal.logger;
