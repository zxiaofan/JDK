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

package com.sun.xml.internal.xsom.impl.util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Aborts on the first error.
 */
public class DraconianErrorHandler implements ErrorHandler {
    public void error( SAXParseException e ) throws SAXException {
        throw e;
    }
    public void fatalError( SAXParseException e ) throws SAXException {
        throw e;
    }
    public void warning( SAXParseException e ) {}
}
