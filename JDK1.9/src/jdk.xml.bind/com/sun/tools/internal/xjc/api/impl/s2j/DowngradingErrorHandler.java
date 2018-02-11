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

package com.sun.tools.internal.xjc.api.impl.s2j;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * {@link ErrorHandler} that reports all errors as warnings.
 *
 * @author Kohsuke Kawaguchi
 */
final class DowngradingErrorHandler implements ErrorHandler {
    private final ErrorHandler core;

    public DowngradingErrorHandler(ErrorHandler core) {
        this.core = core;
    }

    public void warning(SAXParseException exception) throws SAXException {
        core.warning(exception);
    }

    public void error(SAXParseException exception) throws SAXException {
        core.warning(exception);
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        core.warning(exception);
    }
}
