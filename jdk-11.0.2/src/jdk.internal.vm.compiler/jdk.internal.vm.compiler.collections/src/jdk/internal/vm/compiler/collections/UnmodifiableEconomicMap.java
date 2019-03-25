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


package jdk.internal.vm.compiler.collections;

/**
 * Unmodifiable memory efficient map data structure.
 *
 * @since 1.0
 */
public interface UnmodifiableEconomicMap<K, V> {

    /**
     * Returns the value to which {@code key} is mapped, or {@code null} if this map contains no
     * mapping for {@code key}.
     *
     * @since 1.0
     */
    V get(K key);

    /**
     * Returns the value to which {@code key} is mapped, or {@code defaultValue} if this map
     * contains no mapping for {@code key}.
     *
     * @since 1.0
     */
    default V get(K key, V defaultValue) {
        V v = get(key);
        if (v == null) {
            return defaultValue;
        }
        return v;
    }

    /**
     * Returns {@code true} if this map contains a mapping for {@code key}.
     *
     * @since 1.0
     */
    boolean containsKey(K key);

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @since 1.0
     */
    int size();

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @since 1.0
     */
    boolean isEmpty();

    /**
     * Returns a {@link Iterable} view of the values contained in this map.
     *
     * @since 1.0
     */
    Iterable<V> getValues();

    /**
     * Returns a {@link Iterable} view of the keys contained in this map.
     *
     * @since 1.0
     */
    Iterable<K> getKeys();

    /**
     * Returns a {@link UnmodifiableMapCursor} view of the mappings contained in this map.
     *
     * @since 1.0
     */
    UnmodifiableMapCursor<K, V> getEntries();
}
