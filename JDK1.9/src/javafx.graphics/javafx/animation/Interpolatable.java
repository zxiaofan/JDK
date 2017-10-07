/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.animation;

/**
 * A value that can be interpolated. It defines single
 * {@link #interpolate(Object, double)} method, which returns interpolated value
 * of given fraction.
 * @since JavaFX 2.0
 */
@FunctionalInterface
public interface Interpolatable<T> {

    /**
     * The function calculates an interpolated value along the fraction
     * {@code t} between {@code 0.0} and {@code 1.0}. When {@code t} = 1.0,
     * {@code endVal} is returned.
     *
     * @param endValue
     *            target value
     * @param t
     *            fraction between {@code 0.0} and {@code 1.0}
     * @return interpolated value
     */
    public T interpolate(T endValue, double t);
}
