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

import javax.swing.event.ChangeEvent;
import java.util.EventListener;

/**
 * CellEditorListener defines the interface for an object that listens
 * to changes in a CellEditor
 *
 * @author Alan Chung
 */

public interface CellEditorListener extends java.util.EventListener {

    /**
     * This tells the listeners the editor has ended editing
     *
     * @param e the {@code ChangeEvent} containing the source of the event
     */
    public void editingStopped(ChangeEvent e);

    /**
     * This tells the listeners the editor has canceled editing
     *
     * @param e the {@code ChangeEvent} containing the source of the event
     */
    public void editingCanceled(ChangeEvent e);
}
