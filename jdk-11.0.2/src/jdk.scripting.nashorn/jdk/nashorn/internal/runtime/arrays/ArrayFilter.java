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

import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.runtime.ScriptRuntime;
import jdk.nashorn.internal.runtime.Undefined;
import jdk.nashorn.internal.runtime.linker.Bootstrap;

/**
 * Base class for array filters. Implements all core routines so that the
 * filter only has to implement those needed.
 */
abstract class ArrayFilter extends ArrayData {
    /** Underlying array. */
    protected ArrayData underlying;

    ArrayFilter(final ArrayData underlying) {
        super(underlying.length());
        this.underlying = underlying;
    }

    /**
     * Get the underlying {@link ArrayData} that this filter wraps
     * @return array data
     */
    protected ArrayData getUnderlying() {
        return underlying;
    }

    @Override
    public void setLength(final long length) {
        super.setLength(length);
        underlying.setLength(length);
    }

    @Override
    public Object[] asObjectArray() {
        return underlying.asObjectArray();
    }

    @Override
    public Object asArrayOfType(final Class<?> componentType) {
        return underlying.asArrayOfType(componentType);
    }

    @Override
    public ArrayData shiftLeft(final int by) {
        underlying.shiftLeft(by);
        setLength(underlying.length());
        return this;
    }

    @Override
    public ArrayData shiftRight(final int by) {
        underlying = underlying.shiftRight(by);
        setLength(underlying.length());
        return this;
    }

    @Override
    public ArrayData ensure(final long safeIndex) {
        underlying = underlying.ensure(safeIndex);
        setLength(underlying.length());
        return this;
    }

    @Override
    public ArrayData shrink(final long newLength) {
        underlying = underlying.shrink(newLength);
        setLength(underlying.length());
        return this;
    }

    @Override
    public ArrayData set(final int index, final Object value, final boolean strict) {
        underlying = underlying.set(index, value, strict);
        setLength(underlying.length());
        return this;
    }

    @Override
    public ArrayData set(final int index, final int value, final boolean strict) {
        underlying = underlying.set(index, value, strict);
        setLength(underlying.length());
        return this;
    }

    @Override
    public ArrayData set(final int index, final double value, final boolean strict) {
        underlying = underlying.set(index, value, strict);
        setLength(underlying.length());
        return this;
    }

    @Override
    public ArrayData setEmpty(final int index) {
        underlying.setEmpty(index);
        return this;
    }

    @Override
    public ArrayData setEmpty(final long lo, final long hi) {
        underlying.setEmpty(lo, hi);
        return this;
    }

    @Override
    public Type getOptimisticType() {
        return underlying.getOptimisticType();
    }

    @Override
    public int getInt(final int index) {
        return underlying.getInt(index);
    }

    @Override
    public int getIntOptimistic(final int index, final int programPoint) {
        return underlying.getIntOptimistic(index, programPoint);
    }

    @Override
    public double getDouble(final int index) {
        return underlying.getDouble(index);
    }

    @Override
    public double getDoubleOptimistic(final int index, final int programPoint) {
        return underlying.getDoubleOptimistic(index, programPoint);
    }

    @Override
    public Object getObject(final int index) {
        return underlying.getObject(index);
    }

    @Override
    public boolean has(final int index) {
        return underlying.has(index);
    }

    @Override
    public ArrayData delete(final int index) {
        underlying = underlying.delete(index);
        setLength(underlying.length());
        return this;
    }

    @Override
    public ArrayData delete(final long from, final long to) {
        underlying = underlying.delete(from, to);
        setLength(underlying.length());
        return this;
    }

    @Override
    public ArrayData convert(final Class<?> type) {
        underlying = underlying.convert(type);
        setLength(underlying.length());
        return this;
    }

    @Override
    public Object pop() {
        final Object value = underlying.pop();
        setLength(underlying.length());
        return value;
    }

    @Override
    public long nextIndex(final long index) {
        return underlying.nextIndex(index);
    }

    static Object convertUndefinedValue(final Class<?> targetType) {
        return invoke(Bootstrap.getLinkerServices().getTypeConverter(Undefined.class, targetType),
                ScriptRuntime.UNDEFINED);
    }
}
