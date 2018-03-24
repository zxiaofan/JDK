/*
 * Copyright (c) 2009, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Defines where to draw the stroke around the boundary of a Shape node.
 *
 * @see Shape
 * @since JavaFX 2.0
 */
public enum StrokeType {

    /**
     * The stroke is applied by extending the boundary of a closed {@link Shape}
     * node into its interior by a distance specified by the
     * {@link Shape#strokeWidthProperty strokeWidth}.
     * Since the definition of {@code INSIDE} depends on the filled interior
     * of the shape, this {@code StrokeType} is undefined for unclosed shapes.
     *
     * <p>
     * The image shows a shape without stroke and the same shape with a thick
     * inside stroke applied.
     * <p> <img src="doc-files/stroketype-inside.png" alt="A visual rendering
     * of StrokeType.INSIDE"> </p>
     */
    INSIDE,

    /**
     * The stroke is applied by extending the boundary of a closed {@link Shape}
     * node outside of its interior by a distance specified by the
     * {@link Shape#strokeWidthProperty strokeWidth}.
     * Since the definition of {@code OUTSIDE} depends on the filled interior
     * of the shape, this {@code StrokeType} is undefined for unclosed shapes.
     *
     * <p>
     * The image shows a shape without stroke and the same shape with a thick
     * outside stroke applied.
     * <p> <img src="doc-files/stroketype-outside.png" alt="A visual rendering
     * of StrokeType.OUTSIDE"> </p>
     */
    OUTSIDE,

    /**
     * The stroke is applied by thickening the boundary of the {@link Shape}
     * node by a distance of half of the {@link Shape#strokeWidthProperty strokeWidth}
     * on either side of the boundary.
     * Since the definition of {@code CENETERED} is symmetric and agnostic as
     * to the location of any interior of a shape, it can be used for either
     * closed or unclosed shapes.
     *
     * <p>
     * The image shows a shape without stroke and the same shape with a thick
     * centered stroke applied.
     * <p> <img src="doc-files/stroketype-centered.png" alt="A visual rendering
     * of StrokeType.CENTERED"> </p>
     */
    CENTERED
}
