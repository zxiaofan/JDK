/*
 * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Collections;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 * A table model which stores its rows as a list. The elements
 * of the list may be sortable by column. The TableModelComparator
 * must be set for sorting to be enabled.
 */
public abstract class SortableTableModel<T> extends AbstractTableModel {

    private TableModelComparator comparator;

    /**
     * All the rows are stored as a List.
     */
    protected java.util.List<T> elements;

    /**
     * This comparator must be set.
     */
    public void setComparator(TableModelComparator comparator) {
        this.comparator = comparator;
    }

    public void sortByColumn(int column, boolean ascending) {
        comparator.addColumn(column);
        comparator.setAscending(ascending);

        Collections.sort(elements, comparator);

        fireTableChanged(new TableModelEvent(this));
    }

    public boolean isAscending() {
        return comparator.isAscending();
    }

    public int getColumn() {
        return comparator.getColumn();
    }

}
