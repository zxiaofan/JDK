/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.input;

import java.io.Serializable;
import javafx.beans.NamedArg;

/**
 * Represents a single run in which the characters have the same
 * set of highlights in the input method text.
 * <p>
 * Note: this is a conditional feature. See
 * {@link javafx.application.ConditionalFeature#INPUT_METHOD ConditionalFeature.INPUT_METHOD}
 * for more information.
 * @since JavaFX 2.0
 */
public class InputMethodTextRun implements Serializable {

    /**
     * Constructs a single text run of an input method.
     * @param text the text in the text run
     * @param highlight the highlighting of the text
     * @since JavaFX 8.0
     */
    public InputMethodTextRun(@NamedArg("text") String text,
            @NamedArg("highlight") InputMethodHighlight highlight) {
        this.text = text;
        this.highlight = highlight;
    }
    /**
     * The text in this run.
     *
     * @defaultValue empty string
     */
    private final String text;

    /**
     * Gets the text in this run.
     * @return the text in this run
     */
    public final String getText() {
        return text;
    }
    /**
     * The highlight used for displaying this text.
     *
     * @defaultValue null
     */
    private final InputMethodHighlight highlight;

    /**
     * Gets the highlight used for displaying this text.
     * @return the highlight used for displaying this text
     */
    public final InputMethodHighlight getHighlight() {
        return highlight;
    }

    /**
     * Returns a string representation of this {@code InputMethodTextRun} object.
     * @return a string representation of this {@code InputMethodTextRun} object.
     */
    @Override public String toString() {
        return "InputMethodTextRun text [" + getText()
                + "], highlight [" + getHighlight() + "]";
    }
}
