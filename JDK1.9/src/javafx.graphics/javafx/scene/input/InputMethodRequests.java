/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

import javafx.geometry.Point2D;

/**
 * InputMethodRequests defines the requests that a text editing node
 * has to handle in order to work with input methods. The node can
 * implement this interface itself or use a separate object that
 * implements it. The object implementing this interface must be
 * returned from the node's getInputMethodRequests method.
 *
 * @since JavaFX 2.0
 */
public interface InputMethodRequests {

    /**
     * Gets the location of a specified offset in the current composed text,
     * or of the selection in committed text. This information is, for example,
     * used to position the candidate window near the composed text, or a
     * composition window near the location where committed text will be
     * inserted.
     *
     * @param offset the offset within the composed text, if there is
     *         composed text; null otherwise
     * @return a point representing the screen location of the offset
     */
    Point2D getTextLocation(int offset);

    /**
     * Gets the offset within the composed text for the specified absolute x
     * and y coordinates on the screen. This information is used, for example
     * to handle mouse clicks and the mouse cursor. The offset is relative to
     * the composed text, so offset 0 indicates the beginning of the composed
     * text.
     *
     * @param x the absolute x coordinate on screen
     * @param y the absolute y coordinate on screen
     * @return the offset in the composed text.
     */
    int getLocationOffset(int x, int y);

    /**
     * Gets the latest committed text from the text editing node and removes
     * it from the node's text body. This is used for the "Undo Commit"
     * feature in some input methods, where the committed text reverts to
     * its previous composed state. The composed text will be sent to the
     * node using an InputMethodEvent.
     */
    void cancelLatestCommittedText();

    /**
     * Gets the currently selected text from the text editing node. This may
     * be used for a variety of purposes. One of them is the "Reconvert"
     * feature in some input methods. In this case, the input method will
     * typically send an input method event to replace the selected text
     * with composed text. Depending on the input method's capabilities,
     * this may be the original composed text for the selected text, the
     * latest composed text entered anywhere in the text, or a version of
     * the text that's converted back from the selected text.
     *
     * @return the latest committed text, or null when the "Undo Commit"
     *     feature is not supported
     */
    String getSelectedText();
}
