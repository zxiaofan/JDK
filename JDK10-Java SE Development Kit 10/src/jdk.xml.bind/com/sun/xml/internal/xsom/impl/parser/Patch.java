/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.xsom.impl.parser;

import org.xml.sax.SAXException;

/**
 * Patch program that runs later to "fix" references among components.
 *
 * The only difference from the Runnable interface is that this interface
 * allows the program to throw a SAXException.
 */
public interface Patch {
    void run() throws SAXException;
}
