/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.transform;

import com.sun.javafx.geom.transform.Affine3D;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.util.Utils;
import javafx.scene.Node;
import javafx.scene.transform.Transform;

/**
 * Used to access internal methods of Transform.
 */
public class TransformHelper {

    private static TransformAccessor transformAccessor;

    static {
        Utils.forceInit(Transform.class);
    }

    private TransformHelper() {
    }

    public static void add(Transform transform, Node node) {
        transformAccessor.add(transform, node);
    }

    public static void remove(Transform transform, Node node) {
        transformAccessor.remove(transform, node);
    }

    public static void apply(Transform transform, Affine3D affine3D) {
        transformAccessor.apply(transform, affine3D);
    }

    public static BaseTransform derive(Transform transform, BaseTransform baseTransform) {
        return transformAccessor.derive(transform, baseTransform);
    }

    public static Transform createImmutableTransform() {
        return transformAccessor.createImmutableTransform();
    }

    public static Transform createImmutableTransform(
            double mxx, double mxy, double mxz, double tx,
            double myx, double myy, double myz, double ty,
            double mzx, double mzy, double mzz, double tz) {
        return transformAccessor.createImmutableTransform(mxx, mxy, mxz, tx,
                myx, myy, myz, ty, mzx, mzy, mzz, tz);
    }

    public static Transform createImmutableTransform(Transform transform,
            double mxx, double mxy, double mxz, double tx,
            double myx, double myy, double myz, double ty,
            double mzx, double mzy, double mzz, double tz) {
        return transformAccessor.createImmutableTransform(transform, mxx, mxy, mxz, tx,
                myx, myy, myz, ty, mzx, mzy, mzz, tz);
    }

    public static Transform createImmutableTransform(Transform transform,
            Transform left, Transform right) {
        return transformAccessor.createImmutableTransform(transform, left, right);
    }

    public static void setTransformAccessor(final TransformAccessor newAccessor) {
        if (transformAccessor != null) {
            throw new IllegalStateException();
        }

        transformAccessor = newAccessor;
    }

    public interface TransformAccessor {

        void add(Transform transform, Node node);

        void remove(Transform transform, Node node);

        void apply(Transform transform, Affine3D affine3D);

        BaseTransform derive(Transform transform, BaseTransform baseTransform);

        Transform createImmutableTransform();

        Transform createImmutableTransform(
                double mxx, double mxy, double mxz, double tx,
                double myx, double myy, double myz, double ty,
                double mzx, double mzy, double mzz, double tz);

        Transform createImmutableTransform(Transform transform,
                double mxx, double mxy, double mxz, double tx,
                double myx, double myy, double myz, double ty,
                double mzx, double mzy, double mzz, double tz);

        Transform createImmutableTransform(Transform transform,
                Transform left, Transform right);
    }

}
