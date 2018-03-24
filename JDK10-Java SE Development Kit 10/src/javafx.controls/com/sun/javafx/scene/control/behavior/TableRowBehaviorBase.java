/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import javafx.collections.ObservableList;
import javafx.scene.control.Cell;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TablePositionBase;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.List;

public abstract class TableRowBehaviorBase<T extends Cell> extends CellBehaviorBase<T> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    public TableRowBehaviorBase(T control) {
        super(control);
    }



    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/

    @Override public void mousePressed(MouseEvent e) {
        // we only care about clicks to the right of the right-most column
        if (! isClickPositionValid(e.getX(), e.getY())) return;

        super.mousePressed(e);
    }

    @Override protected abstract TableSelectionModel<?> getSelectionModel();

    protected abstract TablePositionBase<?> getFocusedCell();

    protected abstract ObservableList getVisibleLeafColumns();



    /***************************************************************************
     *                                                                         *
     * Private implementation                                                  *
     *                                                                         *
     **************************************************************************/

    @Override protected void doSelect(final double x, final double y, final MouseButton button,
                   final int clickCount, final boolean shiftDown, final boolean shortcutDown) {
        final Control table = getCellContainer();
        if (table == null) return;

        // if the user has clicked on the disclosure node, we do nothing other
        // than expand/collapse the tree item (if applicable). We do not do editing!
        if (handleDisclosureNode(x,y)) {
            return;
        }

        final TableSelectionModel<?> sm = getSelectionModel();
        if (sm == null || sm.isCellSelectionEnabled()) return;

        final int index = getIndex();
        final boolean isAlreadySelected = sm.isSelected(index);
        if (clickCount == 1) {
            // we only care about clicks to the right of the right-most column
            if (! isClickPositionValid(x, y)) return;

            // In the case of clicking to the right of the rightmost
            // TreeTableCell, we should still support selection, so that
            // is what we are doing here.
            if (isAlreadySelected && shortcutDown) {
                sm.clearSelection(index);
            } else {
                if (shortcutDown) {
                    sm.select(getIndex());
                } else if (shiftDown) {
                    // we add all rows between the current focus and
                    // this row (inclusive) to the current selection.
                    TablePositionBase<?> anchor = getAnchor(table, getFocusedCell());
                    final int anchorRow = anchor.getRow();
                    selectRows(anchorRow, index);
                } else {
                    simpleSelect(button, clickCount, shortcutDown);
                }
            }
        } else {
            simpleSelect(button, clickCount, shortcutDown);
        }
    }

    @Override protected boolean isClickPositionValid(final double x, final double y) {
        // get width of all visible columns (we only care about clicks to the
        // right of the right-most column)
        List<TableColumnBase<T, ?>> columns = getVisibleLeafColumns();
        double width = 0.0;
        for (int i = 0; i < columns.size(); i++) {
            width += columns.get(i).getWidth();
        }

        return x > width;
    }
}
