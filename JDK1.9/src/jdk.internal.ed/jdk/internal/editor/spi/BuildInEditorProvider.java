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

package jdk.internal.editor.spi;

import java.util.function.Consumer;

/**
 * Defines the provider of a built-in editor.
 */
public interface BuildInEditorProvider {

    /**
     * @return the rank of a provider, greater is better.
     */
    int rank();

    /**
     * Create a simple built-in editor.
     *
     * @param windowLabel the label string for the Edit Pad window, or null,
     * for default window label
     * @param initialText the source to load in the Edit Pad
     * @param saveHandler a handler for changed source (can be sent the full source)
     * @param errorHandler a handler for unexpected errors
     */
    void edit(String windowLabel, String initialText,
            Consumer<String> saveHandler, Consumer<String> errorHandler);
}
