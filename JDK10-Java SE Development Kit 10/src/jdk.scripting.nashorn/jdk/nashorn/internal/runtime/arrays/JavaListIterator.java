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

import java.util.List;

/**
  * Iterator over a Java List.
 */
class JavaListIterator extends ArrayLikeIterator<Object> {

    /** {@link java.util.List} to iterate over */
    protected final List<?> list;

    /** length of array */
    protected final long length;

    /**
     * Constructor
     * @param list list to iterate over
     * @param includeUndefined should undefined elements be included in iteration
     */
    protected JavaListIterator(final List<?> list, final boolean includeUndefined) {
        super(includeUndefined);
        this.list = list;
        this.length = list.size();
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
        return list.get((int)bumpIndex());
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
        list.remove(index);
    }
}
