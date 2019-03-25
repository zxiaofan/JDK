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

import jdk.nashorn.internal.runtime.ScriptObject;

/**
 * Iterator over a NativeArray
 */
class ScriptArrayIterator extends ArrayLikeIterator<Object> {

    /** Array {@link ScriptObject} to iterate over */
    protected final ScriptObject array;

    /** length of array */
    protected final long length;

    /**
     * Constructor
     * @param array array to iterate over
     * @param includeUndefined should undefined elements be included in iteration
     */
    protected ScriptArrayIterator(final ScriptObject array, final boolean includeUndefined) {
        super(includeUndefined);
        this.array = array;
        this.length = array.getArray().length();
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
        return array.get(bumpIndex());
    }

    @Override
    public long getLength() {
        return length;
    }

    @Override
    public boolean hasNext() {
        if (!includeUndefined) {
            while (indexInArray()) {
                if (array.has(index)) {
                    break;
                }
                bumpIndex();
            }
        }

        return indexInArray();
    }

    @Override
    public void remove() {
        array.delete(index, false);
    }
}
