/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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
 */
package org.graalvm.util;

/**
 * Unmodifiable memory efficient map data structure.
 */
public interface UnmodifiableEconomicMap<K, V> {

    V get(K key);

    default V get(K key, V defaultValue) {
        V v = get(key);
        if (v == null) {
            return defaultValue;
        }
        return v;
    }

    boolean containsKey(K key);

    int size();

    boolean isEmpty();

    Iterable<V> getValues();

    Iterable<K> getKeys();

    UnmodifiableMapCursor<K, V> getEntries();
}
