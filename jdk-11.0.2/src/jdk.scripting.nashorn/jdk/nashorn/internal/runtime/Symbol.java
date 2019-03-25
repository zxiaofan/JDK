/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime;

import java.io.Serializable;
import jdk.nashorn.internal.objects.NativeSymbol;

/**
 * This class represents a unique, non-String Object property key as defined in ECMAScript 6.
 */
public final class Symbol implements Serializable {

    private final String name;

    private static final long serialVersionUID = -2988436597549486913L;

    /**
     * Symbol constructor
     * @param name symbol name
     */
    public Symbol(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Symbol(" + name + ")";
    }

    /**
     * Return the symbol's name
     * @return the name
     */
    public final String getName() {
        return name;
    }

    private Object writeReplace() {
        // If this symbol is a globally registered one, replace it with a
        // GlobalSymbol in serialized stream.
        return NativeSymbol.keyFor(null, this) == name ? new GlobalSymbol(name) : this;
    }

    /**
     * Represents a globally registered (with NativeSymbol._for) symbol in the
     * serialized stream. Upon deserialization, it resolves to the globally
     * registered symbol.
     */
    private static class GlobalSymbol implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String name;

        GlobalSymbol(final String name) {
            this.name = name;
        }

        private Object readResolve() {
            return NativeSymbol._for(null, name);
        }
    }
}
