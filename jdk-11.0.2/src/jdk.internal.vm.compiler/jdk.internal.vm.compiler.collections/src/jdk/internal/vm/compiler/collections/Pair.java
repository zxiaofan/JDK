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

import java.util.Objects;

/**
 * Utility class representing a pair of values.
 *
 * @since 1.0
 */
public final class Pair<L, R> {

    private static final Pair<Object, Object> EMPTY = new Pair<>(null, null);

    private final L left;
    private final R right;

    /**
     * Returns an empty pair.
     *
     * @since 1.0
     */
    @SuppressWarnings("unchecked")
    public static <L, R> Pair<L, R> empty() {
        return (Pair<L, R>) EMPTY;
    }

    /**
     * Constructs a pair with its left value being {@code left}, or returns an empty pair if
     * {@code left} is null.
     *
     * @return the constructed pair or an empty pair if {@code left} is null.
     * @since 1.0
     */
    public static <L, R> Pair<L, R> createLeft(L left) {
        if (left == null) {
            return empty();
        } else {
            return new Pair<>(left, null);
        }
    }

    /**
     * Constructs a pair with its right value being {@code right}, or returns an empty pair if
     * {@code right} is null.
     *
     * @return the constructed pair or an empty pair if {@code right} is null.
     * @since 1.0
     */
    public static <L, R> Pair<L, R> createRight(R right) {
        if (right == null) {
            return empty();
        } else {
            return new Pair<>(null, right);
        }
    }

    /**
     * Constructs a pair with its left value being {@code left}, and its right value being
     * {@code right}, or returns an empty pair if both inputs are null.
     *
     * @return the constructed pair or an empty pair if both inputs are null.
     * @since 1.0
     */
    public static <L, R> Pair<L, R> create(L left, R right) {
        if (right == null && left == null) {
            return empty();
        } else {
            return new Pair<>(left, right);
        }
    }

    private Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Returns the left value of this pair.
     *
     * @since 1.0
     */
    public L getLeft() {
        return left;
    }

    /**
     * Returns the right value of this pair.
     *
     * @since 1.0
     */
    public R getRight() {
        return right;
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(left) + 31 * Objects.hashCode(right);
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof Pair) {
            Pair<L, R> pair = (Pair<L, R>) obj;
            return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
        }

        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0
     */
    @Override
    public String toString() {
        return String.format("(%s, %s)", left, right);
    }
}
