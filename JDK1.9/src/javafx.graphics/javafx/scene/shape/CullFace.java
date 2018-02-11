/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.shape;

/**
 * Face culling setting for use with {@code Shape3D.cullFace}
 *
 * @see Shape3D#cullFaceProperty
 * @since JavaFX 8.0
 */
public enum CullFace {

    /**
     * Do not perform any face culling.
     */
    NONE,

    /**
     * Cull all back-facing polygons. BACK is defined as clockwise winding
     * order.
     */
    BACK,

    /**
     * Cull all front-facing polygons. FRONT is defined as counter-clockwise
     * winding order.
     */
    FRONT
}
