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
package com.sun.org.slf4j.internal;

// Bridge to java.util.logging.
public class LoggerFactory {

    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz.getName());
    }
}
