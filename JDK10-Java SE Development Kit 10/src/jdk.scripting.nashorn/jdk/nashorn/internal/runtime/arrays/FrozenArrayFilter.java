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

import static jdk.nashorn.internal.runtime.ECMAErrors.typeError;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.runtime.PropertyDescriptor;
import jdk.nashorn.internal.runtime.ScriptRuntime;

/**
 * ArrayData after the array has been frozen by Object.freeze call.
 */
final class FrozenArrayFilter extends SealedArrayFilter {
    FrozenArrayFilter(final ArrayData underlying) {
        super(underlying);
    }

    @Override
    public ArrayData copy() {
        return this;
    }

    @Override
    public PropertyDescriptor getDescriptor(final Global global, final int index) {
        return global.newDataDescriptor(getObject(index), false, true, false);
    }

    @Override
    public ArrayData set(final int index, final int value, final boolean strict) {
        if (strict) {
            throw typeError("cant.set.property", Integer.toString(index), "frozen array");
        }
        return this;
    }

    @Override
    public ArrayData set(final int index, final double value, final boolean strict) {
        if (strict) {
            throw typeError("cant.set.property", Integer.toString(index), "frozen array");
        }
        return this;
    }

    @Override
    public ArrayData set(final int index, final Object value, final boolean strict) {
        if (strict) {
            throw typeError("cant.set.property", Integer.toString(index), "frozen array");
        }
        return this;
    }

    @Override
    public ArrayData push(final boolean strict, final Object... items) {
        return this; //nop
    }

    @Override
    public Object pop() {
        final int len = (int)underlying.length();
        return len == 0 ? ScriptRuntime.UNDEFINED : underlying.getObject(len - 1);
    }
}
