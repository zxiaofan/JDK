/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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

import sun.security.util.math.*;

/**
 * Elliptic curve point in projective coordinates (X, Y, Z) where
 * an affine point (x, y) is represented using any (X, Y, Z) s.t.
 * x = X/Z and y = Y/Z.
 */
public abstract class ProjectivePoint
    <T extends IntegerModuloP> implements Point {

    protected final T x;
    protected final T y;
    protected final T z;

    protected ProjectivePoint(T x, T y, T z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public IntegerFieldModuloP getField() {
        return this.x.getField();
    }

    @Override
    public Immutable fixed() {
        return new Immutable(x.fixed(), y.fixed(), z.fixed());
    }

    @Override
    public Mutable mutable() {
        return new Mutable(x.mutable(), y.mutable(), z.mutable());
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public T getZ() {
        return z;
    }

    public AffinePoint asAffine() {
        IntegerModuloP zInv = z.multiplicativeInverse();
        return new AffinePoint(x.multiply(zInv), y.multiply(zInv));
    }

    private static
    <T1 extends IntegerModuloP, T2 extends IntegerModuloP>
    boolean affineEquals(ProjectivePoint<T1> p1,
                         ProjectivePoint<T2> p2) {
        MutableIntegerModuloP x1 = p1.getX().mutable().setProduct(p2.getZ());
        MutableIntegerModuloP x2 = p2.getX().mutable().setProduct(p1.getZ());
        if (!x1.asBigInteger().equals(x2.asBigInteger())) {
            return false;
        }

        MutableIntegerModuloP y1 = p1.getY().mutable().setProduct(p2.getZ());
        MutableIntegerModuloP y2 = p2.getY().mutable().setProduct(p1.getZ());
        if (!y1.asBigInteger().equals(y2.asBigInteger())) {
            return false;
        }

        return true;
    }

    public boolean affineEquals(Point p) {
        if (p instanceof ProjectivePoint) {
            @SuppressWarnings("unchecked")
            ProjectivePoint<IntegerModuloP> pp =
                (ProjectivePoint<IntegerModuloP>) p;
            return affineEquals(this, pp);
        }

        return asAffine().equals(p.asAffine());
    }

    public static class Immutable
        extends ProjectivePoint<ImmutableIntegerModuloP>
        implements ImmutablePoint {

        public Immutable(ImmutableIntegerModuloP x,
                         ImmutableIntegerModuloP y,
                         ImmutableIntegerModuloP z) {
            super(x, y, z);
        }
    }

    public static class Mutable
        extends ProjectivePoint<MutableIntegerModuloP>
        implements MutablePoint {

        public Mutable(MutableIntegerModuloP x,
                       MutableIntegerModuloP y,
                       MutableIntegerModuloP z) {
            super(x, y, z);
        }

        public Mutable(IntegerFieldModuloP field) {
            super(field.get0().mutable(),
                field.get0().mutable(),
                field.get0().mutable());
        }

        @Override
        public Mutable conditionalSet(Point p, int set) {
            if (!(p instanceof ProjectivePoint)) {
                throw new RuntimeException("Incompatible point");
            }
            @SuppressWarnings("unchecked")
            ProjectivePoint<IntegerModuloP> pp =
                (ProjectivePoint<IntegerModuloP>) p;
            return conditionalSet(pp, set);
        }

        private <T extends IntegerModuloP>
        Mutable conditionalSet(ProjectivePoint<T> pp, int set) {

            x.conditionalSet(pp.x, set);
            y.conditionalSet(pp.y, set);
            z.conditionalSet(pp.z, set);

            return this;
        }

        @Override
        public Mutable setValue(AffinePoint p) {
            x.setValue(p.getX());
            y.setValue(p.getY());
            z.setValue(p.getX().getField().get1());

            return this;
        }

        @Override
        public Mutable setValue(Point p) {
            if (!(p instanceof ProjectivePoint)) {
                throw new RuntimeException("Incompatible point");
            }
            @SuppressWarnings("unchecked")
            ProjectivePoint<IntegerModuloP> pp =
                (ProjectivePoint<IntegerModuloP>) p;
            return setValue(pp);
        }

        private <T extends IntegerModuloP>
        Mutable setValue(ProjectivePoint<T> pp) {

            x.setValue(pp.x);
            y.setValue(pp.y);
            z.setValue(pp.z);

            return this;
        }

    }

}
