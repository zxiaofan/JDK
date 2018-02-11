/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.event;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ChangeEvent;
import java.util.EventListener;

/**
 * TableColumnModelListener defines the interface for an object that listens
 * to changes in a TableColumnModel.
 *
 * @author Alan Chung
 * @see TableColumnModelEvent
 */

public interface TableColumnModelListener extends java.util.EventListener
{
    /**
     * Tells listeners that a column was added to the model.
     *
     * @param e a {@code TableColumnModelEvent}
     */
    public void columnAdded(TableColumnModelEvent e);

    /**
     * Tells listeners that a column was removed from the model.
     *
     * @param e a {@code TableColumnModelEvent}
     */
    public void columnRemoved(TableColumnModelEvent e);

    /**
     * Tells listeners that a column was repositioned.
     *
     * @param e a {@code TableColumnModelEvent}
     */
    public void columnMoved(TableColumnModelEvent e);

    /**
     * Tells listeners that a column was moved due to a margin change.
     *
     * @param e a {@code ChangeEvent}
     */
    public void columnMarginChanged(ChangeEvent e);

    /**
     * Tells listeners that the selection model of the
     * TableColumnModel changed.
     *
     * @param e a {@code ListSelectionEvent}
     */
    public void columnSelectionChanged(ListSelectionEvent e);
}
