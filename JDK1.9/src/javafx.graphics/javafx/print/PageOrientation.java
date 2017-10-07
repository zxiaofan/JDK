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

package javafx.print;

/**
 * Specifies the orientation of the media sheet for printed pages.
 * @since JavaFX 8.0
 */
public enum PageOrientation {

    /**
     * The printable area's origin is at the top left of the paper.
     * X coordinates will increase across the short edge of the paper.
     * Y coordinates will increase along the long edge of the paper.
     */
    PORTRAIT,

    /**
     * The printable area's origin is at the bottom left of the paper.
     * X coordinates will increase along the long edge of the paper.
     * Y coordinates will increase along the short edge of the paper.
     */
    LANDSCAPE,

    /**
     * The printable area's origin is at the bottom right of the paper.
     * X coordinates will increase across the short edge of the paper.
     * Y coordinates will increase along the long edge of the paper.
     * i.e. rotated 180 degrees from <code>PORTRAIT</code>.
     */
    REVERSE_PORTRAIT,

    /**
     * The printable area's origin is at the top right of the paper.
     * X coordinates will increase along the long edge of the paper.
     * Y coordinates will increase along the short edge of the paper.
     * i.e. rotated 180 degrees from <code>LANDSCAPE</code>.
     */

    REVERSE_LANDSCAPE,
}
