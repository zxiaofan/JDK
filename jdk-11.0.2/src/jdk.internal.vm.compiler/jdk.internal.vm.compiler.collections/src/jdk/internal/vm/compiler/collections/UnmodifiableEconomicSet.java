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
 * Unmodifiable memory efficient set data structure.
 *
 * @since 1.0
 */
public interface UnmodifiableEconomicSet<E> extends Iterable<E> {

    /**
     * Returns {@code true} if this set contains a mapping for the {@code element}.
     *
     * @since 1.0
     */
    boolean contains(E element);

    /**
     * Returns the number of elements in this set.
     *
     * @since 1.0
     */
    int size();

    /**
     * Returns {@code true} if this set contains no elements.
     *
     * @since 1.0
     */
    boolean isEmpty();

    /**
     * Stores all of the elements in this set into {@code target}. An
     * {@link UnsupportedOperationException} will be thrown if the length of {@code target} does not
     * match the size of this set.
     *
     * @return an array containing all the elements in this set.
     * @throws UnsupportedOperationException if the length of {@code target} does not equal the size
     *             of this set.
     * @since 1.0
     */
    default E[] toArray(E[] target) {
        if (target.length != size()) {
            throw new UnsupportedOperationException("Length of target array must equal the size of the set.");
        }

        int index = 0;
        for (E element : this) {
            target[index++] = element;
        }

        return target;
    }
}
