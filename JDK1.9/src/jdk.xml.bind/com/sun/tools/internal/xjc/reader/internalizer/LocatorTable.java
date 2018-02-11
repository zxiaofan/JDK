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

package com.sun.tools.internal.xjc.reader.internalizer;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;
import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;

/**
 * Stores {@link Locator} objects for every {@link Element}.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public final class LocatorTable {
    /** Locations of the start element. */
    private final Map startLocations = new HashMap();

    /** Locations of the end element. */
    private final Map endLocations = new HashMap();

    public void storeStartLocation( Element e, Locator loc ) {
        startLocations.put(e,new LocatorImpl(loc));
    }

    public void storeEndLocation( Element e, Locator loc ) {
        endLocations.put(e,new LocatorImpl(loc));
    }

    public Locator getStartLocation( Element e ) {
        return (Locator)startLocations.get(e);
    }

    public Locator getEndLocation( Element e ) {
        return (Locator)endLocations.get(e);
    }
}
