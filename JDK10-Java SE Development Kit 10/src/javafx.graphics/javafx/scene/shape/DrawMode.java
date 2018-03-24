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
 * Defines how the polygon is drawn when use with {@code Shape3D.drawMode}
 *
 * @see Shape3D#drawModeProperty
 * @since JavaFX 8.0
 */
public enum DrawMode {

    // TODO: 3D - Alternative name RasterizationMode
    /**
     * Render polygonal primitives as lines drawn between consecutive
     * vertices of the polygon.
     */
    // Wireframe
    LINE,

    /**
     * Render polygonal primitives by filling the interior of the polygon.
     */
    // Solid
    FILL
}
