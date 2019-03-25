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
import jdk.nashorn.internal.runtime.JSType;
import jdk.nashorn.internal.runtime.ScriptObject;

/**
 * Iterator over a map
 */
class ScriptObjectIterator extends ArrayLikeIterator<Object> {

    protected final ScriptObject obj;
    private final long length;

    ScriptObjectIterator(final ScriptObject obj, final boolean includeUndefined) {
        super(includeUndefined);
        this.obj    = obj;
        this.length = JSType.toUint32(obj.getLength());
        this.index  = 0;
    }

    protected boolean indexInArray() {
        return index < length;
    }

    @Override
    public long getLength() {
        return length;
    }

    @Override
    public boolean hasNext() {
        if (length == 0L) {
            return false; //return empty string if toUint32(length) == 0
        }

        while (indexInArray()) {
            if (obj.has(index) || includeUndefined) {
                break;
            }
            bumpIndex();
        }

        return indexInArray();
    }

    @Override
    public Object next() {
        if (indexInArray()) {
            return obj.get(bumpIndex());
        }

        throw new NoSuchElementException();
    }
}
