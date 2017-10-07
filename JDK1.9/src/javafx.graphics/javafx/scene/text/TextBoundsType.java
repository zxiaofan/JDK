/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.text;

/**
 * Specifies the behaviour of bounds reporting by {@code Text} nodes.
 * The setting affects {@code layoutBounds}, {@code boundsInLocal} and
 * {@code boundsInParent}
 *
 * The geometry of text can be measured either in terms of the bounds of
 * the particular text to be rendered - visual bounds, or as properties
 * of the font and the characters to be rendered - logical bounds.
 * Visual bounds are more useful for positioning text as graphics, and
 * for obtaining tight enclosing bounds around the text.
 * <p>
 * Logical bounds are important for laying out text relative to other
 * text and other components, particularly those which also contain text.
 * The bounds isn't specific to the text being rendered, and so will
 * report heights which account for the potential ascent and descent of
 * text using the font at its specified size. Also leading and trailing
 * spaces are part of the logical advance width of the text.
 * <p>
 *
 * @since JavaFX 2.0
 */
public enum TextBoundsType {

    /**
     * Use logical bounds as the basis for calculating the bounds.
     * <p>
     * The logical bounds are based on font metrics information. The width is
     * based on the glyph advances and the height on the ascent, descent, and
     * line gap. Except for the last line which does not include the line gap.
     * <p>
     * Note: This is usually the fastest option.
     */
    LOGICAL,

    /**
     * Use visual bounds as the basis for calculating the bounds.
     * <p>
     * Note: This is likely to be slower than using logical bounds.
     */
    VISUAL,

    /**
     * Use logical vertical centered bounds as the basis for calculating the bounds.
     * <p>
     * This bounds type is typically used to center {@code Text} nodes vertically
     * within the bounds of its parent.
     * @since JavaFX 8.0
     */
    LOGICAL_VERTICAL_CENTER

}
