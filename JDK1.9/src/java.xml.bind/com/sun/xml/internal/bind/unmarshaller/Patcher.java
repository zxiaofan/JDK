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

package com.sun.xml.internal.bind.unmarshaller;

import org.xml.sax.SAXException;

/**
 * Runs by UnmarshallingContext after all the parsing is done.
 *
 * Primarily used to resolve forward IDREFs, but it can run any action.
 *
 * @author Kohsuke Kawaguchi
 */
public interface Patcher {
    /**
     * Runs an post-action.
     *
     * @throws SAXException
     *      if an error is found during the action, it should be reporeted to the context.
     *      The context may then throw a {@link SAXException} to abort the processing,
     *      and that's when you can throw a {@link SAXException}.
     */
    void run() throws SAXException;
}
