/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.control;

/**
 * Defines the behavior of a labeled Control when the space for rendering the
 * text is smaller than the space needed to render the entire string.
 * @since JavaFX 2.0
 */
public enum OverrunStyle {
    /**
     * Any text which exceeds the bounds of the label will be clipped.
     */
    CLIP,
    /**
     * If the text of the label exceeds the bounds of the label, then the last
     * three characters which can be displayed will be "...". If the label is
     * too short to even display that, then only as many "." as possible will
     * be shown.
     */
    ELLIPSIS,
    /**
     * Same as ELLIPSIS, but first removes any partial words at the label
     * boundary and then applies the ellipsis. This ensures that the last
     * characters displayed prior to the ellipsis are part of a full word.
     * Where a full word cannot be displayed, this acts like ELLIPSIS and
     * displays as many characters as possible.
     */
    WORD_ELLIPSIS,
    /**
     * Trims out the center of the string being displayed and replaces the
     * middle three characters with "...". The first and last characters of
     * the string are always displayed in the label, unless the label becomes
     * so short that it cannot display anything other than the ellipsis.
     */
    CENTER_ELLIPSIS,
    /**
     * Same as CENTER_ELLIPSIS but ensures that the "..." occurs between full
     * words. If the label becomes so short that it is not possible to trim
     * any additional words, then partial words are displayed and this behaves
     * the same as CENTER_ELLIPSIS
     */
    CENTER_WORD_ELLIPSIS,
    /**
     * Same as ELLIPSIS but puts the "..." at the beginning of the text instead
     * of at the end
     */
    LEADING_ELLIPSIS,
    /**
     * Same as WORD_ELLIPSIS but puts the "..." at the beginning of the text
     * instead of at the end
     */
    LEADING_WORD_ELLIPSIS
    /**
     * Indicates that the entire text should be available, but should scroll
     * as if in a ticker tape
     */
    //TICKER
}

