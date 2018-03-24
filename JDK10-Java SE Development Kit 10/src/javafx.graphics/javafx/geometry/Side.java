/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.geometry;

/**
 * Enum for which side of a rectangle something should be. This is used for chart titles, axis etc.
 * @since JavaFX 2.0
 */
public enum Side {
    /**
     * Represents top side of a rectangle.
     */
    TOP,

    /**
     * Represents bottom side of a rectangle.
     */
    BOTTOM,

    /**
     * Represents left side of a rectangle.
     */
    LEFT,

    /**
     * Represents right side of a rectangle.
     */
    RIGHT;

    /**
     * Indicates whether this is vertical side of a rectangle (returns
     * {@code true} for {@code LEFT} and {@code RIGHT}.
     * @return {@code true} if this represents a vertical side of a rectangle
     */
    public boolean isVertical() {
        return this == LEFT || this == RIGHT;
    }

    /**
     * Indicates whether this is horizontal side of a rectangle (returns
     * {@code true} for {@code TOP} and {@code BOTTOM}.
     * @return {@code true} if this represents a horizontal side of a rectangle
     */
    public boolean isHorizontal() {
        return this == TOP || this == BOTTOM;
    }
}
