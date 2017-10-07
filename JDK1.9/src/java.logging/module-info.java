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
 * Defines the Java Logging API.
 *
 * @moduleGraph
 * @since 9
 */
module java.logging {
    exports java.util.logging;

    provides jdk.internal.logger.DefaultLoggerFinder with
        sun.util.logging.internal.LoggingProviderImpl;
}

