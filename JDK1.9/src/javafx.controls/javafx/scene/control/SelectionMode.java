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

package javafx.scene.control;

/**
 * An enumeration used to specify how many items may be selected in a
 * {@link MultipleSelectionModel}.
 *
 * @see SelectionModel
 * @see MultipleSelectionModel
 * @since JavaFX 2.0
 */
public enum SelectionMode {
    /**
     * Allows for only one item to be selected at a time.
     */
    SINGLE,

    /**
     * Allows for one or more contiguous range of indices to be selected at a time.
     */
    MULTIPLE;
}
