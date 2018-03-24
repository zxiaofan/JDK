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

import java.lang.reflect.Array;

/**
  * Iterator over a Java List.
 */
class JavaArrayIterator extends ArrayLikeIterator<Object> {

    /** Array to iterate over */
    protected final Object array;

    /** length of array */
    protected final long length;

    /**
     * Constructor
     * @param array array to iterate over
     * @param includeUndefined should undefined elements be included in iteration
     */
    protected JavaArrayIterator(final Object array, final boolean includeUndefined) {
        super(includeUndefined);
        assert array.getClass().isArray() : "expecting Java array object";
        this.array = array;
        this.length = Array.getLength(array);
    }

    /**
     * Is the current index still inside the array
     * @return true if inside the array
     */
    protected boolean indexInArray() {
        return index < length;
    }

    @Override
    public Object next() {
        return Array.get(array, (int)bumpIndex());
    }

    @Override
    public long getLength() {
        return length;
    }

    @Override
    public boolean hasNext() {
        return indexInArray();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
