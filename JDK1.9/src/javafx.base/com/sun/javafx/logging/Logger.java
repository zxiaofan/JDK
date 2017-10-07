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

package com.sun.javafx.logging;

/**
 * Common API for pulse loggers
 */
public class Logger {
    public void pulseStart() {}
    public void pulseEnd() {}
    public void renderStart() {}
    public void renderEnd() {}
    public void addMessage(String message) {}
    public void incrementCounter(String counter) {}
    public void newPhase(String name) {}
    public void newInput(String name) {}
}
