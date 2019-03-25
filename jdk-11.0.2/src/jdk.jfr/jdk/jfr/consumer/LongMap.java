/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.consumer;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Commonly used data structure for looking up objects given an id (long value)
 *
 * TODO: Implement without using Map and Long objects, to minimize allocation
 *
 * @param <T>
 */
final class LongMap<T> implements Iterable<T> {
    private final HashMap<Long, T> map;

    LongMap() {
        map = new HashMap<>(101);
    }

    void put(long id, T object) {
        map.put(id, object);
    }

    T get(long id) {
        return map.get(id);
    }

    @Override
    public Iterator<T> iterator() {
        return map.values().iterator();
    }

    Iterator<Long> keys() {
        return map.keySet().iterator();
    }
}
