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
package sun.swing.text;

import javax.swing.undo.UndoableEdit;

/**
 * UndoableEdit support for undo/redo actions synchronization
 * @since 9
 */
public interface UndoableEditLockSupport extends UndoableEdit {
    /**
     * lock the UndoableEdit for threadsafe undo/redo
     */
    void lockEdit();

    /**
     * unlock the UndoableEdit
     */
    void unlockEdit();
}
