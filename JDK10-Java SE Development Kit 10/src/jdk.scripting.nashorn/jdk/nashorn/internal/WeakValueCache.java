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

package jdk.nashorn.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.function.Function;

/**
 * This class provides a map based cache with weakly referenced values. Cleared references are
 * purged from the underlying map when values are retrieved or created.
 * It uses a {@link java.util.HashMap} to store values and needs to be externally synchronized.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public final class WeakValueCache<K, V> {

    private final HashMap<K, KeyValueReference<K, V>> map = new HashMap<>();
    private final ReferenceQueue<V> refQueue = new ReferenceQueue<>();

    /**
     * Returns the value associated with {@code key}, or {@code null} if no such value exists.
     *
     * @param key the key
     * @return the value or null if none exists
     */
    public V get(final K key) {
        // Remove cleared entries
        for (;;) {
            final KeyValueReference<?, ?> ref = (KeyValueReference) refQueue.poll();
            if (ref == null) {
                break;
            }
            map.remove(ref.key, ref);
        }

        final KeyValueReference<K, V> ref = map.get(key);
        if (ref != null) {
            return ref.get();
        }
        return null;
    }

    /**
     * Returns the value associated with {@code key}, or creates and returns a new value if
     * no value exists using the {@code creator} function.
     *
     * @param key the key
     * @param creator function to create a new value
     * @return the existing value, or a new one if none existed
     */
    public V getOrCreate(final K key, final Function<? super K, ? extends V> creator) {
        V value = get(key);

        if (value == null) {
            // Define a new value if it does not exist
            value = creator.apply(key);
            map.put(key, new KeyValueReference<>(key, value));
        }

        return value;
    }

    private static class KeyValueReference<K, V> extends WeakReference<V> {
        final K key;

        KeyValueReference(final K key, final V value) {
            super(value);
            this.key = key;
        }
    }

}
