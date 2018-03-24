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

package javafx.scene.shape;

/**
 * Defines the line join style of a {@code Shape}.
 * @since JavaFX 2.0
 */
public enum StrokeLineJoin {

    /**
     * Joins path segments by extending their outside edges until they meet.
     *
     * <p> <img src="doc-files/strokelinejoin-miter.png" alt="A visual rendering
     * of StrokeLineJoin.MITER"> </p>
     */
    MITER,//(BasicStroke.JOIN_MITER),

    /**
     * Joins path segments by connecting the outer corners
     * of their wide outlines with a straight segment.
     *
     * <p> <img src="doc-files/strokelinejoin-bevel.png" alt="A visual rendering
     * of StrokeLineJoin.BEVEL"> </p>
     */
    BEVEL,//(BasicStroke.JOIN_BEVEL),

    /**
     * Joins path segments by rounding off the corner
     * at a radius of half the line width.
     *
     * <p> <img src="doc-files/strokelinejoin-round.png" alt="A visual rendering
     * of StrokeLineJoin.ROUND"> </p>
     */
    ROUND//(BasicStroke.JOIN_ROUND);
}
