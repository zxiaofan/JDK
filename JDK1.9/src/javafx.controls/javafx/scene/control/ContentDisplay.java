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
 * <p>The position to place the content within a Label.</p>
 * @since JavaFX 2.0
 */
public enum ContentDisplay {
    /**
     * <p>Content will be placed at the top of the Label.</p>
     */
    TOP,

    /**
     * <p>Content will be placed at the right of the Label.</p>
     */
    RIGHT,

    /**
     * <p>Content will be placed at the bottom of the Label.</p>
     */
    BOTTOM,

    /**
     * <p>Content will be placed at the left of the Label.</p>
     */
    LEFT,

    /**
     * <p>Content will be placed at the center of the Label.</p>
     */
    CENTER,

    /**
     * <p>Only the content will be displayed.</p>
     */
    GRAPHIC_ONLY,

    /**
     * <p>Only the label's text will be displayed.</p>
     */
    TEXT_ONLY;
}
