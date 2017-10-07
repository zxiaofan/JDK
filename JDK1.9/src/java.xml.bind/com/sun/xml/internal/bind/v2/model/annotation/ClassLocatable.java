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

package com.sun.xml.internal.bind.v2.model.annotation;

import com.sun.xml.internal.bind.v2.model.nav.Navigator;
import com.sun.xml.internal.bind.v2.runtime.Location;

/**
 * {@link Locatable} implementation for a class.
 *
 * @author Kohsuke Kawaguchi
 */
public class ClassLocatable<C> implements Locatable {
    private final Locatable upstream;
    private final C clazz;
    private final Navigator<?,C,?,?> nav;

    public ClassLocatable(Locatable upstream, C clazz, Navigator<?,C,?,?> nav) {
        this.upstream = upstream;
        this.clazz = clazz;
        this.nav = nav;
    }

    public Locatable getUpstream() {
        return upstream;
    }

    public Location getLocation() {
        return nav.getClassLocation(clazz);
    }
}
