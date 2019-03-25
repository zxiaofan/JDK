/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
package sun.security.ec.point;

import sun.security.util.math.ImmutableIntegerModuloP;

import java.util.Objects;

/**
 * Elliptic curve point represented using affine coordinates (x, y). This class
 * is not part of the sun.security.ec.point.Point hierarchy because it is not
 * used to hold intermediate values during point arithmetic, and so it does not
 * have a mutable form.
 */
public class AffinePoint {

    private final ImmutableIntegerModuloP x;
    private final ImmutableIntegerModuloP y;

    public AffinePoint(ImmutableIntegerModuloP x, ImmutableIntegerModuloP y) {
        this.x = x;
        this.y = y;
    }

    public ImmutableIntegerModuloP getX() {
        return x;
    }

    public ImmutableIntegerModuloP getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AffinePoint)) {
            return false;
        }
        AffinePoint p = (AffinePoint) obj;
        boolean xEquals = x.asBigInteger().equals(p.x.asBigInteger());
        boolean yEquals = y.asBigInteger().equals(p.y.asBigInteger());
        return xEquals && yEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x.asBigInteger().toString() + "," +
            y.asBigInteger().toString() + ")";
    }
}
