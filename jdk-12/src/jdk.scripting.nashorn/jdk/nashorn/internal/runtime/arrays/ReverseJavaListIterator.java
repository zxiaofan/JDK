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
 * Reverse iterator over a List
 */
final class ReverseJavaListIterator extends JavaListIterator {
    /**
     * Constructor
     * @param list list to iterate over
     * @param includeUndefined should undefined elements be included in iteration
     */
    public ReverseJavaListIterator(final List<?> list, final boolean includeUndefined) {
        super(list, includeUndefined);
        this.index = list.size() - 1;
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
