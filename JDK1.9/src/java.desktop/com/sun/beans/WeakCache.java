/*
 * Copyright (c) 2008, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.beans;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * A hashtable-based cache with weak keys and weak values.
 * An entry in the map will be automatically removed
 * when its key is no longer in the ordinary use.
 * A value will be automatically removed as well
 * when it is no longer in the ordinary use.
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
public final class WeakCache<K, V> {
    private final Map<K, Reference<V>> map = new WeakHashMap<K, Reference<V>>();

    /**
     * Returns a value to which the specified {@code key} is mapped,
     * or {@code null} if this map contains no mapping for the {@code key}.
     *
     * @param key  the key whose associated value is returned
     * @return a value to which the specified {@code key} is mapped
     */
    public V get(K key) {
        Reference<V> reference = this.map.get(key);
        if (reference == null) {
            return null;
        }
        V value = reference.get();
        if (value == null) {
            this.map.remove(key);
        }
        return value;
    }

    /**
     * Associates the specified {@code value} with the specified {@code key}.
     * Removes the mapping for the specified {@code key} from this cache
     * if it is present and the specified {@code value} is {@code null}.
     * If the cache previously contained a mapping for the {@code key},
     * the old value is replaced by the specified {@code value}.
     *
     * @param key    the key with which the specified value is associated
     * @param value  the value to be associated with the specified key
     */
    public void put(K key, V value) {
        if (value != null) {
            this.map.put(key, new WeakReference<V>(value));
        }
        else {
            this.map.remove(key);
        }
    }

    /**
     * Removes all of the mappings from this cache.
     */
    public void clear() {
        this.map.clear();
    }
}
