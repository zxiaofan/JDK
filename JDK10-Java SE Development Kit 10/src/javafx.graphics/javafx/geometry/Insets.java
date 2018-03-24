/*
 * Copyright (c) 2008, 2017, Oracle and/or its affiliates. All rights reserved.
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

 import javafx.beans.NamedArg;

/**
 * A set of inside offsets for the 4 side of a rectangular area
 * @since JavaFX 2.0
 */
public class Insets {
    /**
     * Empty insets. An {@code Insets} instance with all offsets equal to zero.
     */
    public static final Insets EMPTY = new Insets(0, 0, 0, 0);

    /**
     * The inset on the top side
     * @return the inset on the top side
     */
    public final double getTop() { return top; }
    private double top;

    /**
     * The inset on the right side
     * @return the inset on the right side
     */
    public final double getRight() { return right; }
    private double right;

    /**
     * The inset on the bottom side
     * @return the inset on the bottom side
     */
    public final double getBottom() { return bottom; }
    private double bottom;

    /**
     * The inset on the left side
     * @return the inset on the left side
     */
    public final double getLeft() { return left; }
    private double left;

    /**
     * The cached hash code, used to improve performance in situations where
     * we cache gradients, such as in the CSS routines.
     */
    private int hash = 0;

    /**
     * Constructs a new Insets instance with four different offsets.
     *
     * @param top the top offset
     * @param right the right offset
     * @param bottom the bottom offset
     * @param left the left offset
     */
    public Insets(@NamedArg("top") double top, @NamedArg("right") double right, @NamedArg("bottom") double bottom, @NamedArg("left") double left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    /**
     * Constructs a new Insets instance with same value for all four offsets.
     *
     * @param topRightBottomLeft the value used for top, bottom, right and left
     * offset
     */
    public Insets(@NamedArg("topRightBottomLeft") double topRightBottomLeft) {
        this.top = topRightBottomLeft;
        this.right = topRightBottomLeft;
        this.bottom = topRightBottomLeft;
        this.left = topRightBottomLeft;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof Insets) {
            Insets other = (Insets) obj;
            return top == other.top
              && right == other.right
              && bottom == other.bottom
              && left == other.left;
        } else return false;

    }

    /**
     * Returns a hash code value for the insets.
     * @return a hash code value for the insets.
     */
    @Override public int hashCode() {
        if (hash == 0) {
            long bits = 17L;
            bits = 37L * bits + Double.doubleToLongBits(top);
            bits = 37L * bits + Double.doubleToLongBits(right);
            bits = 37L * bits + Double.doubleToLongBits(bottom);
            bits = 37L * bits + Double.doubleToLongBits(left);
            hash = (int) (bits ^ (bits >> 32));
        }
        return hash;
    }

    /**
     * Returns a string representation for the insets.
     * @return a string representation for the insets.
     */
    @Override public String toString() {
        return "Insets [top=" + top + ", right=" + right + ", bottom="
                + bottom + ", left=" + left + "]";
    }
}
