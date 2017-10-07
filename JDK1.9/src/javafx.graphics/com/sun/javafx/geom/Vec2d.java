/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.geom;

/**
 * A 2-dimensional, double-precision, floating-point vector.
 *
 */
public class Vec2d {
    /**
     * The x coordinate.
     */
    public double x;

    /**
     * The y coordinate.
     */
    public double y;

    public Vec2d() { }

    public Vec2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2d(Vec2d v) {
        set(v);
    }

    public Vec2d(Vec2f v) {
        set(v);
    }

    public void set(Vec2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void set(Vec2f v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the square of the distance between two points.
     *
     * @param x1 the X coordinate of the first specified point
     * @param y1 the Y coordinate of the first specified point
     * @param x2 the X coordinate of the second specified point
     * @param y2 the Y coordinate of the second specified point
     * @return the square of the distance between the two
     * sets of specified coordinates.
     */
    public static double distanceSq(double x1, double y1, double x2, double y2) {
        x1 -= x2;
        y1 -= y2;
        return (x1 * x1 + y1 * y1);
    }

    /**
     * Returns the distance between two points.
     *
     * @param x1 the X coordinate of the first specified point
     * @param y1 the Y coordinate of the first specified point
     * @param x2 the X coordinate of the second specified point
     * @param y2 the Y coordinate of the second specified point
     * @return the distance between the two sets of specified
     * coordinates.
     */
    public static double distance(double x1, double y1, double x2, double y2) {
        x1 -= x2;
        y1 -= y2;
        return Math.sqrt(x1 * x1 + y1 * y1);
    }

    /**
     * Returns the square of the distance from this
     * <code>Vec2d</code> to a specified point.
     *
     * @param vx the X coordinate of the specified point to be measured
     *           against this <code>Vec2d</code>
     * @param vy the Y coordinate of the specified point to be measured
     *           against this <code>Vec2d</code>
     * @return the square of the distance between this
     * <code>Vec2d</code> and the specified point.
     */
    public double distanceSq(double vx, double vy) {
        vx -= x;
        vy -= y;
        return (vx * vx + vy * vy);
    }

    /**
     * Returns the square of the distance from this
     * <code>Vec2d</code> to a specified <code>Vec2d</code>.
     *
     * @param v the specified point to be measured
     *           against this <code>Vec2d</code>
     * @return the square of the distance between this
     * <code>Vec2d</code> to a specified <code>Vec2d</code>.
     */
    public double distanceSq(Vec2d v) {
        double vx = v.x - this.x;
        double vy = v.y - this.y;
        return (vx * vx + vy * vy);
    }

    /**
     * Returns the distance from this <code>Vec2d</code> to
     * a specified point.
     *
     * @param vx the X coordinate of the specified point to be measured
     *           against this <code>Vec2d</code>
     * @param vy the Y coordinate of the specified point to be measured
     *           against this <code>Vec2d</code>
     * @return the distance between this <code>Vec2d</code>
     * and a specified point.
     */
    public double distance(double vx, double vy) {
        vx -= x;
        vy -= y;
        return Math.sqrt(vx * vx + vy * vy);
    }

    /**
     * Returns the distance from this <code>Vec2d</code> to a
     * specified <code>Vec2d</code>.
     *
     * @param v the specified point to be measured
     *           against this <code>Vec2d</code>
     * @return the distance between this <code>Vec2d</code> and
     * the specified <code>Vec2d</code>.
     */
    public double distance(Vec2d v) {
        double vx = v.x - this.x;
        double vy = v.y - this.y;
        return Math.sqrt(vx * vx + vy * vy);
    }

    /**
     * Returns the hashcode for this <code>Vec2d</code>.
     * @return      a hash code for this <code>Vec2d</code>.
     */
    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(x);
        bits = 31L * bits + Double.doubleToLongBits(y);
        return (int) (bits ^ (bits >> 32));
    }

    /**
     * Determines whether or not two 2D points or vectors are equal.
     * Two instances of <code>Vec2d</code> are equal if the values of their
     * <code>x</code> and <code>y</code> member fields, representing
     * their position in the coordinate space, are the same.
     * @param obj an object to be compared with this <code>Vec2d</code>
     * @return <code>true</code> if the object to be compared is
     *         an instance of <code>Vec2d</code> and has
     *         the same values; <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Vec2d) {
            Vec2d v = (Vec2d) obj;
            return (x == v.x) && (y == v.y);
        }
        return false;
    }

    /**
     * Returns a <code>String</code> that represents the value
     * of this <code>Vec2d</code>.
     * @return a string representation of this <code>Vec2d</code>.
     */
    @Override
    public String toString() {
        return "Vec2d[" + x + ", " + y + "]";
    }
}
