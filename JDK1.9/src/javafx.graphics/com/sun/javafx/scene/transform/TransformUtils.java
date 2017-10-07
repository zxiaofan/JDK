/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

import javafx.scene.transform.Transform;

/**
 * Internal utilities for transformations
 */
public class TransformUtils {

    /**
     * Creates an immutable arbitrary transformation.
     * This method is not intended for public use, users should use the Affine
     * class.
     */
    public static Transform immutableTransform(
                double mxx, double mxy, double mxz, double tx,
                double myx, double myy, double myz, double ty,
                double mzx, double mzy, double mzz, double tz) {
        return TransformHelper.createImmutableTransform(
                mxx, mxy, mxz, tx,
                myx, myy, myz, ty,
                mzx, mzy, mzz, tz);
    }

    /**
     * Creates an immutable transformation filled with current values
     * from the given transformation.
     * This method is not intended for public use, users should use the Affine
     * class.
     */
    public static Transform immutableTransform(Transform t) {
        return TransformHelper.createImmutableTransform(
                t.getMxx(), t.getMxy(), t.getMxz(), t.getTx(),
                t.getMyx(), t.getMyy(), t.getMyz(), t.getTy(),
                t.getMzx(), t.getMzy(), t.getMzz(), t.getTz());
    }

    /**
     * Creates an immutable arbitrary transformation.
     * If the given instance is not null, it is reused.
     * This method is not intended for public use, users should use the Affine
     * class.
     * @throws ClassCastException if the given transform to be reused
     *                            is not instance of ImmutableTransform
     */
    public static Transform immutableTransform(Transform reuse,
                double mxx, double mxy, double mxz, double tx,
                double myx, double myy, double myz, double ty,
                double mzx, double mzy, double mzz, double tz) {

        return TransformHelper.createImmutableTransform(reuse,
                mxx, mxy, mxz, tx,
                myx, myy, myz, ty,
                mzx, mzy, mzz, tz);
    }

    /**
     * Creates an immutable transformation filled with current values
     * from the given transformation.
     * If the given instance is not null, it is reused.
     * This method is not intended for public use, users should use the Affine
     * class.
     * @throws ClassCastException if the given transform to be reused
     *                            is not instance of ImmutableTransform
     */
    public static Transform immutableTransform(Transform reuse,
                Transform t) {
        return TransformHelper.createImmutableTransform(reuse,
                t.getMxx(), t.getMxy(), t.getMxz(), t.getTx(),
                t.getMyx(), t.getMyy(), t.getMyz(), t.getTy(),
                t.getMzx(), t.getMzy(), t.getMzz(), t.getTz());
    }

    /**
     * Creates an immutable transformation filled with concatenation
     * of the given transformations.
     * If the given instance is not null, it is reused.
     * This method is not intended for public use, users should use the Affine
     * class.
     * @throws ClassCastException if one of the given transforms
     *                            is not instance of ImmutableTransform
     */
    public static Transform immutableTransform(Transform reuse,
            Transform left, Transform right) {

        return TransformHelper.createImmutableTransform(reuse, left, right);
    }

}
