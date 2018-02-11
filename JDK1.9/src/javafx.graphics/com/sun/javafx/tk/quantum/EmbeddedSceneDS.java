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

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Callable;
import javafx.scene.input.TransferMode;

final class EmbeddedSceneDS implements EmbeddedSceneDSInterface {

    private final EmbeddedSceneDnD dnd;
    private final ClipboardAssistance assistant;
    private final GlassSceneDnDEventHandler dndHandler;

    public EmbeddedSceneDS(final EmbeddedSceneDnD dnd,
                           final ClipboardAssistance assistant,
                           final GlassSceneDnDEventHandler dndHandler) {
        this.dnd = dnd;
        this.assistant = assistant;
        this.dndHandler = dndHandler;
    }

    @Override
    public Set<TransferMode> getSupportedActions() {
        assert dnd.isHostThread();
        return dnd.executeOnFXThread(() -> QuantumClipboard.clipboardActionsToTransferModes(
                assistant.getSupportedSourceActions()));
    }

    @Override
    public Object getData(final String mimeType) {
        assert dnd.isHostThread();
        return dnd.executeOnFXThread(() -> assistant.getData(mimeType));
    }

    @Override
    public String[] getMimeTypes() {
        assert dnd.isHostThread();
        return dnd.executeOnFXThread(() -> assistant.getMimeTypes());
    }

    @Override
    public boolean isMimeTypeAvailable(final String mimeType) {
        assert dnd.isHostThread();
        return dnd.executeOnFXThread(() -> Arrays.asList(assistant.getMimeTypes()).contains(mimeType));
    }

    @Override
    public void dragDropEnd(final TransferMode performedAction) {
        assert dnd.isHostThread();
        dnd.executeOnFXThread(() -> {
            try {
                dndHandler.handleDragEnd(performedAction, assistant);
            } finally {
                dnd.onDragSourceReleased(EmbeddedSceneDS.this);
            }
            return null;
        });
    }
}
