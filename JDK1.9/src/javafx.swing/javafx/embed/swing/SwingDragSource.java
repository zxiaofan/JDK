/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javafx.embed.swing;

import com.sun.javafx.embed.EmbeddedSceneDSInterface;
import com.sun.javafx.tk.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javafx.scene.input.TransferMode;

/**
 * Drag source to deliver data from Swing environment to embedded FX scene.
 */
final class SwingDragSource extends CachingTransferable implements EmbeddedSceneDSInterface {

    private int sourceActions;

    SwingDragSource() {
    }

    void updateContents(final DropTargetDragEvent e, boolean fetchData) {
        sourceActions = e.getSourceActions();
        updateData(e.getTransferable(), fetchData);
    }

    void updateContents(final DropTargetDropEvent e, boolean fetchData) {
        sourceActions = e.getSourceActions();
        updateData(e.getTransferable(), fetchData);
    }

    @Override
    public Set<TransferMode> getSupportedActions() {
        assert Toolkit.getToolkit().isFxUserThread();
        return SwingDnD.dropActionsToTransferModes(sourceActions);
    }

    @Override
    public void dragDropEnd(TransferMode performedAction) {
        throw new UnsupportedOperationException();
    }
}
