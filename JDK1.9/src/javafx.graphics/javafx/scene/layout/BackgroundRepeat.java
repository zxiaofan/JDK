/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.layout;

/**
 * Enumeration of options for repeating images in backgrounds
 * @since JavaFX 8.0
 */
public enum BackgroundRepeat {
    /**
     * The image is repeated as often as needed to cover the area.
     */
    REPEAT,
    /**
     * The image is repeated as often as will fit within the area without being
     * clipped and then the images are spaced out to fill the area. The first
     * and last images touch the edges of the area.
     */
    SPACE,
    /**
     * The image is repeated as often as will fit within the area. If it
     * doesn't fit a whole number of times, it is reduced in size until it does.
     */
    ROUND,
    /**
     * The image is placed once and not repeated
     */
    NO_REPEAT
}
