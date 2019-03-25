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

import javax.swing.undo.*;

/**
 * Interface implemented by a class interested in hearing about
 * undoable operations.
 *
 * @author Ray Ryan
 */

public interface UndoableEditListener extends java.util.EventListener {

    /**
     * An undoable edit happened
     *
     * @param e an {@code UndoableEditEvent} object
     */
    void undoableEditHappened(UndoableEditEvent e);
}
