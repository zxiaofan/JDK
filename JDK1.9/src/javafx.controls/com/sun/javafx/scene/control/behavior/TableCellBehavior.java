/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.control.behavior;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TablePositionBase;
import javafx.scene.control.TableView;

import javafx.scene.control.TableView.TableViewFocusModel;

/**
 */
public class TableCellBehavior<S,T> extends TableCellBehaviorBase<S, T, TableColumn<S,?>, TableCell<S, T>> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    public TableCellBehavior(TableCell<S,T> control) {
        super(control);
    }



    /***************************************************************************
     *                                                                         *
     * Implement TableCellBehaviorBase Abstract API                            *
     *                                                                         *
     **************************************************************************/

    /** @{@inheritDoc} */
    @Override protected TableView<S> getCellContainer() {
        return getNode().getTableView();
    }

    /** @{@inheritDoc} */
    @Override protected TableColumn<S,T> getTableColumn() {
        return getNode().getTableColumn();
    }

    /** @{@inheritDoc} */
    @Override protected int getItemCount() {
        return getCellContainer().getItems().size();
    }

    /** @{@inheritDoc} */
    @Override protected TableView.TableViewSelectionModel<S> getSelectionModel() {
        return getCellContainer().getSelectionModel();
    }

    /** @{@inheritDoc} */
    @Override protected TableViewFocusModel<S> getFocusModel() {
        return getCellContainer().getFocusModel();
    }

    /** @{@inheritDoc} */
    @Override protected TablePositionBase getFocusedCell() {
        return getCellContainer().getFocusModel().getFocusedCell();
    }

    /** @{@inheritDoc} */
    @Override protected boolean isTableRowSelected() {
        return getNode().getTableRow().isSelected();
    }

    /** @{@inheritDoc} */
    @Override protected int getVisibleLeafIndex(TableColumnBase tc) {
        return getCellContainer().getVisibleLeafIndex((TableColumn) tc);
    }

    /** @{@inheritDoc} */
    @Override protected void focus(int row, TableColumnBase tc) {
        getFocusModel().focus(row, (TableColumn)tc);
    }

    /** @{@inheritDoc} */
    @Override protected void edit(TableCell<S,T> cell) {
        if (cell == null) {
            getCellContainer().edit(-1, null);
        } else {
            getCellContainer().edit(cell.getIndex(), cell.getTableColumn());
        }
    }
}
