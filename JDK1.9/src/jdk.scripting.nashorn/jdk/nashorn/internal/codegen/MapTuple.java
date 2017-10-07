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

package jdk.nashorn.internal.codegen;

import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.ir.Symbol;

/**
 * A tuple of values used for map creation
 * @param <T> value type
 */
class MapTuple<T> {
    final String key;
    final Symbol symbol;
    final Type   type;
    final T      value;

    MapTuple(final String key, final Symbol symbol, final Type type) {
        this(key, symbol, type, null);
    }

    MapTuple(final String key, final Symbol symbol, final Type type, final T value) {
        this.key    = key;
        this.symbol = symbol;
        this.type   = type;
        this.value  = value;
    }

    public Class<?> getValueType() {
        return null; //until proven otherwise we are undefined, see NASHORN-592 int.class;
    }

    boolean isPrimitive() {
        return getValueType() != null && getValueType().isPrimitive() && getValueType() != boolean.class;
    }

    @Override
    public String toString() {
        return "[key=" + key + ", symbol=" + symbol + ", value=" + value + " (" + (value == null ? "null" : value.getClass().getSimpleName()) +")]";
    }
}
