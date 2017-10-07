/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.mimepull;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@link java.util.ArrayList} with the final keyword.
 *
 * <p>
 * This gives HotSpot a better hint that all methods can be inlined.
 *
 * @author Kohsuke Kawaguchi
 */
final class FinalArrayList<T> extends ArrayList<T> {

    private static final long serialVersionUID = 7996571518730043311L;

    public FinalArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public FinalArrayList() {
    }

    public FinalArrayList(Collection<? extends T> ts) {
        super(ts);
    }
}
