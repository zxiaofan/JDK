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

/**
 * ArrayData after the array has been sealed by Object.seal call.
 */
class SealedArrayFilter extends ArrayFilter {
    SealedArrayFilter(final ArrayData underlying) {
        super(underlying);
    }

    @Override
    public ArrayData copy() {
        return new SealedArrayFilter(underlying.copy());
    }

    @Override
    public ArrayData slice(final long from, final long to) {
        return getUnderlying().slice(from, to);
    }

    @Override
    public boolean canDelete(final int index, final boolean strict) {
        return canDelete(ArrayIndex.toLongIndex(index), strict);
    }

    @Override
    public boolean canDelete(final long longIndex, final boolean strict) {
        if (strict) {
            throw typeError("cant.delete.property", Long.toString(longIndex), "sealed array");
        }
        return false;
    }

    @Override
    public PropertyDescriptor getDescriptor(final Global global, final int index) {
        return global.newDataDescriptor(getObject(index), false, true, true);
    }
}
