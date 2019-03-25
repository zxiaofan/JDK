/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime.arrays;

import java.util.NoSuchElementException;

/**
 * Dummy array iterator that has no elements
 */
final class EmptyArrayLikeIterator extends ArrayLikeIterator<Object> {

    EmptyArrayLikeIterator() {
        super(false);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public long getLength() {
        return 0;
    }
}
