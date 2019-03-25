/*
 * Copyright (c) 1996, 1999, Oracle and/or its affiliates. All rights reserved.
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

package java.awt;

/**
 * The {@code Stroke} interface allows a
 * {@link Graphics2D} object to obtain a {@link Shape} that is the
 * decorated outline, or stylistic representation of the outline,
 * of the specified {@code Shape}.
 * Stroking a {@code Shape} is like tracing its outline with a
 * marking pen of the appropriate size and shape.
 * The area where the pen would place ink is the area enclosed by the
 * outline {@code Shape}.
 * <p>
 * The methods of the {@code Graphics2D} interface that use the
 * outline {@code Shape} returned by a {@code Stroke} object
 * include {@code draw} and any other methods that are
 * implemented in terms of that method, such as
 * {@code drawLine}, {@code drawRect},
 * {@code drawRoundRect}, {@code drawOval},
 * {@code drawArc}, {@code drawPolyline},
 * and {@code drawPolygon}.
 * <p>
 * The objects of the classes implementing {@code Stroke}
 * must be read-only because {@code Graphics2D} does not
 * clone these objects either when they are set as an attribute
 * with the {@code setStroke} method or when the
 * {@code Graphics2D} object is itself cloned.
 * If a {@code Stroke} object is modified after it is set in
 * the {@code Graphics2D} context then the behavior
 * of subsequent rendering would be undefined.
 * @see BasicStroke
 * @see Graphics2D#setStroke
 */
public interface Stroke {
    /**
     * Returns an outline {@code Shape} which encloses the area that
     * should be painted when the {@code Shape} is stroked according
     * to the rules defined by the
     * object implementing the {@code Stroke} interface.
     * @param p a {@code Shape} to be stroked
     * @return the stroked outline {@code Shape}.
     */
    Shape createStrokedShape (Shape p);
}
