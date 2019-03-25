/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph.iterators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.graalvm.compiler.graph.Node;

public interface NodeIterable<T extends Node> extends Iterable<T> {

    @SuppressWarnings("unchecked")
    default <F extends T> NodeIterable<F> filter(Class<F> clazz) {
        return (NodeIterable<F>) new FilteredNodeIterable<>(this).and(NodePredicates.isA(clazz));
    }

    default FilteredNodeIterable<T> filter(NodePredicate predicate) {
        return new FilteredNodeIterable<>(this).and(predicate);
    }

    default List<T> snapshot() {
        ArrayList<T> list = new ArrayList<>();
        snapshotTo(list);
        return list;
    }

    default void snapshotTo(Collection<? super T> to) {
        for (T n : this) {
            to.add(n);
        }
    }

    default T first() {
        Iterator<T> iterator = iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    default int count() {
        int count = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    default boolean isEmpty() {
        return !iterator().hasNext();
    }

    default boolean isNotEmpty() {
        return iterator().hasNext();
    }

    default boolean contains(T node) {
        for (T next : this) {
            if (next == node) {
                return true;
            }
        }
        return false;
    }
}
