/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.editpad;

import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;
import jdk.internal.editor.spi.BuildInEditorProvider;

/**
 * Defines the provider of an Edit Pad implementation.
 *
 * @author Robert Field
 */
public class EditPadProvider implements BuildInEditorProvider {

    /**
     * @return the rank of a provider, greater is better.
     */
    @Override
    public int rank() {
        return 5;
    }

    /**
     * Create an Edit Pad minimal editor.
     *
     * @param windowLabel the label string for the Edit Pad window, or null,
     * for default window label
     * @param initialText the source to load in the Edit Pad
     * @param saveHandler a handler for changed source (can be sent the full source)
     * @param errorHandler a handler for unexpected errors
     */
    @Override
    public void edit(String windowLabel, String initialText,
            Consumer<String> saveHandler, Consumer<String> errorHandler) {
        CountDownLatch closeLock = new CountDownLatch(1);
        SwingUtilities.invokeLater(
                new EditPad(windowLabel, errorHandler, initialText, closeLock::countDown, saveHandler));
        do {
            try {
                closeLock.await();
                break;
            } catch (InterruptedException ex) {
                // ignore and loop
            }
        } while (true);
    }
}
