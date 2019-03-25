/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.virtual.phases.ea;

import java.util.Iterator;
import java.util.Map;

import jdk.internal.vm.compiler.collections.EconomicMap;
import jdk.internal.vm.compiler.collections.UnmodifiableMapCursor;

public abstract class EffectsBlockState<T extends EffectsBlockState<T>> {

    /**
     * This flag specifies whether this block is unreachable, which can happen during analysis if
     * conditions turn constant or nodes canonicalize to cfg sinks.
     */
    private boolean dead;

    public EffectsBlockState() {
        // emtpy
    }

    public EffectsBlockState(EffectsBlockState<T> other) {
        this.dead = other.dead;
    }

    @Override
    public String toString() {
        return "";
    }

    protected abstract boolean equivalentTo(T other);

    public boolean isDead() {
        return dead;
    }

    public void markAsDead() {
        this.dead = true;
    }

    /**
     * Returns true if every value in subMap is also present in the superMap (according to "equals"
     * semantics).
     */
    protected static <K, V> boolean isSubMapOf(EconomicMap<K, V> superMap, EconomicMap<K, V> subMap) {
        if (superMap == subMap) {
            return true;
        }
        UnmodifiableMapCursor<K, V> cursor = subMap.getEntries();
        while (cursor.advance()) {
            K key = cursor.getKey();
            V value = cursor.getValue();
            assert value != null;
            V otherValue = superMap.get(key);
            if (otherValue != value && !value.equals(otherValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Modifies target so that only entries that have corresponding entries in source remain.
     */
    protected static <U, V> void meetMaps(Map<U, V> target, Map<U, V> source) {
        Iterator<Map.Entry<U, V>> iter = target.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<U, V> entry = iter.next();
            if (source.containsKey(entry.getKey())) {
                assert source.get(entry.getKey()) == entry.getValue();
            } else {
                iter.remove();
            }
        }
    }
}
