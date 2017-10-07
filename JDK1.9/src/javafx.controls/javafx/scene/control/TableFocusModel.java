/*
 * Copyright (c) 2012, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * The abstract base class for FocusModel implementations that are used within
 * table-like controls (most notably {@link TableView} and {@link TreeTableView}.
 *
 * @param <T> The type of the underlying data model for the UI control.
 * @param <TC> The concrete subclass of {@link TableColumnBase} that is used by the
 *      underlying UI control (e.g. {@link TableColumn} or {@link TreeTableColumn}.
 * @since JavaFX 8.0
 */
public abstract class TableFocusModel<T, TC extends TableColumnBase<T,?>> extends FocusModel<T> {

    /***********************************************************************
     *                                                                     *
     * Public API                                                          *
     *                                                                     *
     **********************************************************************/

    /**
     * Causes the item at the given index to receive the focus.
     *
     * @param row The row index of the item to give focus to.
     * @param column The column of the item to give focus to. Can be null.
     */
    public abstract void focus(int row, TC column);

    /**
     * Tests whether the row / cell at the given location currently has the
     * focus within the UI control.
     * @param row the row
     * @param column the column
     * @return true if the row / cell at the given location currently has the
     * focus within the UI control
     */
    public abstract boolean isFocused(int row, TC column);

    /**
     * Attempts to move focus to the cell above the currently focused cell.
     */
    public abstract void focusAboveCell();

    /**
     * Attempts to move focus to the cell below the currently focused cell.
     */
    public abstract void focusBelowCell();

    /**
     * Attempts to move focus to the cell to the left of the currently focused cell.
     */
    public abstract void focusLeftCell();

    /**
     * Attempts to move focus to the cell to the right of the the currently focused cell.
     */
    public abstract void focusRightCell();



     /***********************************************************************
     *                                                                     *
     * Private Implementation                                              *
     *                                                                     *
     **********************************************************************/

}
