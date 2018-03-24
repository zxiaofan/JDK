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

package javafx.stage;

/**
 * This enum defines the possible modality types for a {@code Stage}.
 * @since JavaFX 2.0
 */
public enum Modality {

    /**
     * Defines a top-level window that is not modal and does not block any other
     * window.
     */
    NONE,

    /**
     * Defines a modal window that block events from being delivered to its
     * entire owner window hierarchy.
     *
     * Note: A Stage with modality set to WINDOW_MODAL, but its owner is null,
     * is treated as if its modality is set to NONE.
     */
    WINDOW_MODAL,

    /**
     * Defines a modal window that blocks events from being delivered to any
     * other application window.
     */
    APPLICATION_MODAL

}
