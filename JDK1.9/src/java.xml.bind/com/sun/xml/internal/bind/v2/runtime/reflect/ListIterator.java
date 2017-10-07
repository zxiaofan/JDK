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

package com.sun.xml.internal.bind.v2.runtime.reflect;

import java.util.Iterator;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

/**
 * Almost like {@link Iterator} but can throw JAXB specific exceptions.
 * @author Kohsuke Kawaguchi
 */
public interface ListIterator<E> {
    /**
     * Works like {@link Iterator#hasNext()}.
     */
    boolean hasNext();

    /**
     * Works like {@link Iterator#next()}.
     *
     * @throws SAXException
     *      if an error is found, reported, and we were told to abort
     * @throws JAXBException
     *      if an error is found, reported, and we were told to abort
     */
    E next() throws SAXException, JAXBException;
}
