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

import jdk.nashorn.internal.runtime.JSType;
import jdk.nashorn.internal.runtime.ScriptObject;

/**
 * Reverse iterator over a map
 */
final class ReverseScriptObjectIterator extends ScriptObjectIterator {

    ReverseScriptObjectIterator(final ScriptObject obj, final boolean includeUndefined) {
        super(obj, includeUndefined);
        this.index = JSType.toUint32(obj.getLength()) - 1;
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
