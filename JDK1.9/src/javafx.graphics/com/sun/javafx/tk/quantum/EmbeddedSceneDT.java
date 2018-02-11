/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk.quantum;

import com.sun.glass.ui.ClipboardAssistance;
import com.sun.javafx.embed.EmbeddedSceneDSInterface;
import com.sun.javafx.embed.EmbeddedSceneDTInterface;
import java.util.concurrent.Callable;
import javafx.application.Platform;
import javafx.scene.input.TransferMode;

final class EmbeddedSceneDT implements EmbeddedSceneDTInterface {

    private final EmbeddedSceneDnD dnd;
    private final GlassSceneDnDEventHandler dndHandler;
    private EmbeddedSceneDSInterface dragSource;
    private ClipboardAssistance assistant;

    public EmbeddedSceneDT(final EmbeddedSceneDnD dnd,
                           final GlassSceneDnDEventHandler dndHandler) {
        this.dnd = dnd;
        this.dndHandler = dndHandler;
    }

    private void close() {
        dnd.onDropTargetReleased(this);
        assistant = null;
    }

    @Override
    public TransferMode handleDragEnter(final int x, final int y, final int xAbs,
                                        final int yAbs,
                                        final TransferMode recommendedDropAction,
                                        final EmbeddedSceneDSInterface ds)
    {
        assert dnd.isHostThread();

        return dnd.executeOnFXThread(() -> {
            assert dragSource == null;
            assert assistant == null;

            dragSource = ds;
            assistant = new EmbeddedDTAssistant(dragSource);

            return dndHandler.handleDragEnter(x, y, xAbs, yAbs,
                                              recommendedDropAction,
                                              assistant);
        });
    }

    @Override
    public void handleDragLeave() {
        assert dnd.isHostThread();

        dnd.executeOnFXThread(() -> {
            assert assistant != null;
            try {
                dndHandler.handleDragLeave(assistant);
            } finally {
                close();
            }
            return null;
        });
    }

    @Override
    public TransferMode handleDragDrop(final int x, final int y, final int xAbs,
                                       final int yAbs,
                                       final TransferMode recommendedDropAction) {
        assert dnd.isHostThread();

        return dnd.executeOnFXThread(() -> {
            assert assistant != null;
            try {
                return dndHandler.handleDragDrop(x, y, xAbs, yAbs,
                                                 recommendedDropAction,
                                                 assistant);
            } finally {
                close();
            }
        });
    }

    @Override
    public TransferMode handleDragOver(final int x, final int y, final int xAbs,
                                       final int yAbs,
                                       final TransferMode recommendedDropAction) {
        assert dnd.isHostThread();

        return dnd.executeOnFXThread(() -> {
            assert assistant != null;
            return dndHandler.handleDragOver(x, y, xAbs, yAbs,
                                             recommendedDropAction,
                                             assistant);
        });
    }

    private static class EmbeddedDTAssistant extends ClipboardAssistance {

        private EmbeddedSceneDSInterface dragSource;

        EmbeddedDTAssistant(EmbeddedSceneDSInterface source) {
            super("DND-Embedded");
            dragSource = source;
        }

        @Override
        public void flush() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object getData(final String mimeType) {
            return dragSource.getData(mimeType);
        }

        @Override
        public int getSupportedSourceActions() {
            return QuantumClipboard.transferModesToClipboardActions(dragSource.getSupportedActions());
        }

        @Override
        public void setTargetAction(int actionDone) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String[] getMimeTypes() {
            return dragSource.getMimeTypes();
        }
    }
}
