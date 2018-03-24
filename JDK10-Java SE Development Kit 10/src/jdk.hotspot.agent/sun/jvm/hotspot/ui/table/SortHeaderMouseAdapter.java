/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.ui.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;

import com.sun.java.swing.ui.CommonUI;

/**
 * A mouse adapater which is attached to the header of a JTable. It listens
 * for mouse clicks on a column and sorts that column.
 */
public class SortHeaderMouseAdapter extends MouseAdapter {

    private SortableTableModel model;
    private JTable table;

    public SortHeaderMouseAdapter(JTable table, SortableTableModel model) {
        this.model = model;
        this.table = table;
    }

    public void mouseClicked(MouseEvent evt) {
        // XXX Benchmark sort performance
        //long start = System.currentTimeMillis();
        CommonUI.setWaitCursor(SwingUtilities.getRoot(table));

        TableColumnModel columnModel = table.getColumnModel();
        int viewColumn = columnModel.getColumnIndexAtX(evt.getX());
        int column = table.convertColumnIndexToModel(viewColumn);
        if (evt.getClickCount() == 1 && column != -1) {
            // Reverse the sorting direction.
            model.sortByColumn(column, !model.isAscending());
        }

        // XXX Benchmark performance
        //      System.out.println("Sort time: " +
        //         (System.currentTimeMillis() - start));
        CommonUI.setDefaultCursor(SwingUtilities.getRoot(table));
    }
}
