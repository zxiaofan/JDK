/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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
package sun.rmi.server;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Abstract class that maps Class objects to lazily-computed values of
 * type V.  A concrete subclass must implement the computeValue method
 * to determine how the values are computed.
 *
 * The keys are only weakly reachable through this map, so this map
 * does not prevent a class (along with its class loader, etc.) from
 * being garbage collected if it is not otherwise strongly reachable.
 * The values are only softly reachable through this map, so that the
 * computed values generally persist while not otherwise strongly
 * reachable, but their storage may be reclaimed if necessary.  Also,
 * note that if a key is strongly reachable from a value, then the key
 * is effectively softly reachable through this map, which may delay
 * garbage collection of classes (see 4429536).
 **/
public abstract class WeakClassHashMap<V> {

    private Map<Class<?>,ValueCell<V>> internalMap = new WeakHashMap<>();

    protected WeakClassHashMap() { }

    public V get(Class<?> remoteClass) {
        /*
         * Use a mutable cell (a one-element list) to hold the soft
         * reference to a value, to allow the lazy value computation
         * to be synchronized with entry-level granularity instead of
         * by locking the whole table.
         */
        ValueCell<V> valueCell;
        synchronized (internalMap) {
            valueCell = internalMap.get(remoteClass);
            if (valueCell == null) {
                valueCell = new ValueCell<V>();
                internalMap.put(remoteClass, valueCell);
            }
        }
        synchronized (valueCell) {
            V value = null;
            if (valueCell.ref != null) {
                value = valueCell.ref.get();
            }
            if (value == null) {
                value = computeValue(remoteClass);
                valueCell.ref = new SoftReference<V>(value);
            }
            return value;
        }
    }

    protected abstract V computeValue(Class<?> remoteClass);

    private static class ValueCell<T> {
        Reference<T> ref = null;
        ValueCell() { }
    }
}
