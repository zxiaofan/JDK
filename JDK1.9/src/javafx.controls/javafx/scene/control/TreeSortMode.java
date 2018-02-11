/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Specifies how the tree items in tree-like UI controls should be sorted.
 * @since JavaFX 8.0
 */
public enum TreeSortMode {
    /**
     * Default; sort all nodes.
     */
    ALL_DESCENDANTS,

    /**
     * Sort first level nodes only regardless of whether the root is
     * actually being shown or not.
     */
    ONLY_FIRST_LEVEL;
}
