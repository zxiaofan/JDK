/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.debug;

import java.util.ArrayList;
import java.util.List;

import jdk.internal.vm.compiler.collections.EconomicMap;

/**
 * Registry for allocating a globally unique integer id to each {@link AbstractKey}.
 */
public class KeyRegistry {

    private static final EconomicMap<String, Integer> keyMap = EconomicMap.create();
    private static final List<AbstractKey> keys = new ArrayList<>();

    /**
     * Ensures a given metric key is registered.
     *
     * @return the globally unique id for {@code value}
     */
    static synchronized int register(AbstractKey key) {
        String name = key.getName();
        if (!keyMap.containsKey(name)) {
            keyMap.put(name, keys.size());
            keys.add(key);
        }
        return keyMap.get(name);
    }

    /**
     * Gets a copy of the registered keys.
     *
     * @return a list where {@code get(i).getIndex() == i}
     */
    public static synchronized List<MetricKey> getKeys() {
        return new ArrayList<>(keys);
    }
}
