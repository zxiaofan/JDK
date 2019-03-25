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
public class Logger {

    private final java.util.logging.Logger impl;

    public Logger(String name) {
        impl = java.util.logging.Logger.getLogger(name);
    }

    public boolean isDebugEnabled() {
        return impl.isLoggable(java.util.logging.Level.FINE);
    }

    public boolean isTraceEnabled() {
        return impl.isLoggable(java.util.logging.Level.FINE);
    }

    public void debug(String s) {
        impl.log(java.util.logging.Level.FINE, s);
    }

    public void debug(String s, Throwable e) {
        impl.log(java.util.logging.Level.FINE, s, e);
    }

    public void debug(String s, Object... o) {
        impl.log(java.util.logging.Level.FINE, s, o);
    }

    public void trace(String s) {
        impl.log(java.util.logging.Level.FINE, s);
    }

    public void error(String s) {
        impl.log(java.util.logging.Level.SEVERE, s);
    }

    public void error(String s, Throwable e) {
        impl.log(java.util.logging.Level.SEVERE, s, e);
    }

    public void error(String s, Object... o) {
        impl.log(java.util.logging.Level.SEVERE, s, o);
    }

    public void warn(String s) {
        impl.log(java.util.logging.Level.WARNING, s);
    }

    public void warn(String s, Throwable e) {
        impl.log(java.util.logging.Level.WARNING, s, e);
    }
}
