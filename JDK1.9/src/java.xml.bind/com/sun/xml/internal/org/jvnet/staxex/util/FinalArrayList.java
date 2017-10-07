/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.staxex.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@link ArrayList} with a final marker to help JIT.
 * @author Kohsuke Kawaguchi
 */
public final class FinalArrayList<T> extends ArrayList<T> {
    public FinalArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public FinalArrayList() {
    }

    public FinalArrayList(Collection collection) {
        super(collection);
    }
}
