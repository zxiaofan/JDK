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

package com.sun.xml.internal.bind.v2.runtime.unmarshaller;

/**
 * Pair of {@link Loader} and {@link Receiver}.
 *
 * Used by {@link StructureLoader}.
 *
 * @author Kohsuke Kawaguchi
 */
public final class ChildLoader {
    public final Loader loader;
    public final Receiver receiver;

    public ChildLoader(Loader loader, Receiver receiver) {
        assert loader!=null;
        this.loader = loader;
        this.receiver = receiver;
    }
}
