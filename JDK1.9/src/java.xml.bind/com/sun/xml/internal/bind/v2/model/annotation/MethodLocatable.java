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
 * {@link Locatable} implementation for a method.
 *
 * @author Kohsuke Kawaguchi
 */
public class MethodLocatable<M> implements Locatable {
    private final Locatable upstream;
    private final M method;
    private final Navigator<?,?,?,M> nav;

    public MethodLocatable(Locatable upstream, M method, Navigator<?,?,?,M> nav) {
        this.upstream = upstream;
        this.method = method;
        this.nav = nav;
    }

    public Locatable getUpstream() {
        return upstream;
    }

    public Location getLocation() {
        return nav.getMethodLocation(method);
    }
}
