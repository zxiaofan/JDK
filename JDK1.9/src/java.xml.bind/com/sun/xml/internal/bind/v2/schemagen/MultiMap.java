/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.schemagen;

import java.util.TreeMap;
import java.util.Map;

/**
 * A special {@link Map} that 'conceptually' stores a set of values for each key.
 *
 * <p>
 * When multiple values are stored, however, this class doesn't let the caller
 * see individual values, and instead it returns a specially designated "MANY" value,
 * which is given as a parameter to the constructor.
 *
 * @author Kohsuke Kawaguchi
 */
final class MultiMap<K extends Comparable<K>,V> extends TreeMap<K,V> {
    private final V many;

    public MultiMap(V many) {
        this.many = many;
    }

    @Override
    public V put(K key, V value) {
        V old = super.put(key, value);
        if(old!=null && !old.equals(value)) {
            // different value stored
            super.put(key,many);
        }
        return old;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }
}
