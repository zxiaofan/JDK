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
 * Reverse iterator over a NativeArray
 */
final class ReverseScriptArrayIterator extends ScriptArrayIterator {

    /**
     * Constructor
     * @param array array to iterate over
     * @param includeUndefined should undefined elements be included in iteration
     */
    public ReverseScriptArrayIterator(final ScriptObject array, final boolean includeUndefined) {
        super(array, includeUndefined);
        this.index = array.getArray().length() - 1;
    }

    @Override
    public boolean isReverse() {
        return true;
    }

    @Override
    protected boolean indexInArray() {
        return index >= 0;
    }

    @Override
    protected long bumpIndex() {
        return index--;
    }
}
