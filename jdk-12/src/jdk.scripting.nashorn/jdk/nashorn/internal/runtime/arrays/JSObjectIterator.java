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
import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.runtime.JSType;

/**
 * Iterator over a ScriptObjectMirror
 */
class JSObjectIterator extends ArrayLikeIterator<Object> {

    protected final JSObject obj;
    private final long length;

    JSObjectIterator(final JSObject obj, final boolean includeUndefined) {
        super(includeUndefined);
        this.obj    = obj;
        this.length = JSType.toUint32(obj.hasMember("length")? obj.getMember("length") : 0);
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
            if (obj.hasSlot((int)index) || includeUndefined) {
                break;
            }
            bumpIndex();
        }

        return indexInArray();
    }

    @Override
    public Object next() {
        if (indexInArray()) {
            return obj.getSlot((int)bumpIndex());
        }

        throw new NoSuchElementException();
    }
}

