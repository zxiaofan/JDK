/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.web;

import javafx.beans.NamedArg;


/**
 * This class encapsulates data passed into JavaScript {@code prompt()} function:
 * a message and a default value. Instances are passed into {@code prompt}
 * handlers registered on a {@code WebEngine} using
 * {@link WebEngine#setPromptHandler} method.
 *
 * @see WebEngine
 * @see WebEngine#setPromptHandler
 * @since JavaFX 2.0
 */
public final class PromptData {

    private final String message;
    private final String defaultValue;

    /**
     * Creates a new instance.
     * @param message the message carried by this data object
     * @param defaultValue the default value carried by this data object
     */
    public PromptData(@NamedArg("message") String message, @NamedArg("defaultValue") String defaultValue) {
        this.message = message;
        this.defaultValue = defaultValue;
    }

    /**
     * Returns the message carried by this data object.
     * @return the message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Returns the default value carried by this data object.
     * @return the default value
     */
    public final String getDefaultValue() {
        return defaultValue;
    }
}
