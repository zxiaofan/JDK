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

import java.util.Iterator;

import org.graalvm.util.impl.EconomicMapImpl;

/**
 * Memory efficient set data structure.
 */
public interface EconomicSet<E> extends UnmodifiableEconomicSet<E> {

    boolean add(E element);

    void remove(E element);

    void clear();

    default void addAll(EconomicSet<E> values) {
        addAll(values.iterator());
    }

    default void addAll(Iterable<E> values) {
        addAll(values.iterator());
    }

    default void addAll(Iterator<E> values) {
        while (values.hasNext()) {
            add(values.next());
        }
    }

    default void removeAll(EconomicSet<E> values) {
        removeAll(values.iterator());
    }

    default void removeAll(Iterable<E> values) {
        removeAll(values.iterator());
    }

    default void removeAll(Iterator<E> values) {
        while (values.hasNext()) {
            remove(values.next());
        }
    }

    default void retainAll(EconomicSet<E> values) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E key = iterator.next();
            if (!values.contains(key)) {
                iterator.remove();
            }
        }
    }

    /**
     * Creates a new set guaranteeing insertion order when iterating over its elements with the
     * default {@link Equivalence#DEFAULT} comparison strategy.
     */
    static <E> EconomicSet<E> create() {
        return EconomicSet.create(Equivalence.DEFAULT);
    }

    /**
     * Creates a new set guaranteeing insertion order when iterating over its elements.
     */
    static <E> EconomicSet<E> create(Equivalence strategy) {
        return EconomicMapImpl.create(strategy);
    }

    /**
     * Creates a new set guaranteeing insertion order when iterating over its elements with the
     * default {@link Equivalence#DEFAULT} comparison strategy and inserts all elements of the
     * specified collection.
     */
    static <E> EconomicSet<E> create(int initialCapacity) {
        return EconomicSet.create(Equivalence.DEFAULT, initialCapacity);
    }

    /**
     * Creates a new set guaranteeing insertion order when iterating over its elements with the
     * default {@link Equivalence#DEFAULT} comparison strategy and inserts all elements of the
     * specified collection.
     */
    static <E> EconomicSet<E> create(UnmodifiableEconomicSet<E> c) {
        return EconomicSet.create(Equivalence.DEFAULT, c);
    }

    /**
     * Creates a new set guaranteeing insertion order when iterating over its elements and
     * initializes with the given capacity.
     */
    static <E> EconomicSet<E> create(Equivalence strategy, int initialCapacity) {
        return EconomicMapImpl.create(strategy, initialCapacity);
    }

    /**
     * Creates a new set guaranteeing insertion order when iterating over its elements and inserts
     * all elements of the specified collection.
     */
    static <E> EconomicSet<E> create(Equivalence strategy, UnmodifiableEconomicSet<E> c) {
        return EconomicMapImpl.create(strategy, c);
    }
}
