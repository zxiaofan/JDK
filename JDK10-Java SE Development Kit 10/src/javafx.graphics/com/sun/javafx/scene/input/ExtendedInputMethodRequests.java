/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.input;

import javafx.scene.input.InputMethodRequests;

/**
 * ExtendedInputMethodRequests extends the {@link InputMethodRequests} interface
 * to provide more requests that a text editing node could handle.
 * The text editing node is not required to implement an extended interface,
 * but it could implement it to support input methods when embedded into the
 * JFXPanel
 *
 * @since JavaFX 8.0
 */
public interface ExtendedInputMethodRequests extends InputMethodRequests {


    /**
     * Returns the offset of the insert position in the committed text contained
     * in the text editing node.
     *
     * @return the offset of the insert position
     */
    int getInsertPositionOffset();

    /**
     * Gets the entire text contained in the text editing node except the uncommitted
     * text. The uncommitted text is ignored for index calculations.
     *
     * @param begin the index of the first character
     * @param end the index of the character following the last character
     * @return the committed text
     */
    String getCommittedText(int begin, int end);

    /**
     * Gets the length of the entire text contained in the text editing node except
     * the uncommitted text.
     *
     * @return length of the text except the uncommitted text
     */
    int getCommittedTextLength();
}
