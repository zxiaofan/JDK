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

import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.runtime.JSType;

/**
 * Reverse iterator over a ScriptObjectMirror
 */
final class ReverseJSObjectIterator extends JSObjectIterator {

    ReverseJSObjectIterator(final JSObject obj, final boolean includeUndefined) {
        super(obj, includeUndefined);
        this.index = JSType.toUint32(obj.hasMember("length")? obj.getMember("length") : 0) - 1;
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

