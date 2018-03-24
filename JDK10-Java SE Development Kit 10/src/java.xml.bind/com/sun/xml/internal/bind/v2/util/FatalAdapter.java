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

package com.sun.xml.internal.bind.v2.util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;

/**
 * Maps an error to a fatal error.
 *
 * @author Kohsuke Kawaguchi
 */
public class FatalAdapter implements ErrorHandler {
    private final ErrorHandler core;

    public FatalAdapter(ErrorHandler handler) {
        this.core = handler;
    }

    public void warning (SAXParseException exception) throws SAXException {
        core.warning(exception);
    }

    public void error (SAXParseException exception) throws SAXException {
        core.fatalError(exception);
    }

    public void fatalError (SAXParseException exception) throws SAXException {
        core.fatalError(exception);
    }
}
