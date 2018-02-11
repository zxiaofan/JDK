/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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
 * Enum indicating the repetition rules for border images.
 * @since JavaFX 8.0
 */
public enum BorderRepeat {
    /**
     * The image is stretched to fill the area.
     */
    STRETCH,
    /**
     * The image is tiled (repeated) to fill the area.
     */
    REPEAT,
    /**
     * The image is tiled (repeated) and rescaled (if necessary) to fill the area with a whole number of tiles.
     */
    ROUND,
    /**
     * The image is tiled (repeated) to fill the area with a whole number of tiles, and any
     * extra space is distributed around the tiles.
     */
    SPACE
}
