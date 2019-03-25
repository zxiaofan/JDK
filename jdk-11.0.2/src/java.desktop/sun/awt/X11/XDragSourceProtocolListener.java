/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.X11;

interface XDragSourceProtocolListener {
    /**
     * Called when a reply from the current drop target is received.
     *
     * @param action is the drop action selected by the drop target
     */
    void handleDragReply(int action);

    /**
     * Called when a reply from the current drop target is received.
     *
     * @param action the drop action selected by the drop target
     * @param x the x coordinate of the pointer location in screen coordinates
     *        for the reply
     * @param y the x coordinate of the pointer location in screen coordinates
     *        for the reply
     */
    void handleDragReply(int action, int x, int y);

    /**
     * Called when a reply from the current drop target is received.
     *
     * @param action the drop action selected by the drop target
     * @param x the x coordinate of the pointer location in screen coordinates
     *        for the reply
     * @param y the x coordinate of the pointer location in screen coordinates
     *        for the reply
     * @param modifiers the keyboard modifiers state for the reply
     */
    void handleDragReply(int action, int x, int y, int modifiers);

    /**
     * Called when the current drop target signals that the drag-and-drop
     * operation is finished.
     */
    void handleDragFinished();

    /**
     * Called when the current drop target signals that the drag-and-drop
     * operation is finished.
     *
     * @param success true if the drop target successfully performed the drop
     *                action
     */
    void handleDragFinished(boolean success);

    /**
     * Called when the current drop target signals that the drag-and-drop
     * operation is finished.
     *
     * @param action the drop action performed by the drop target
     * @param success true if the drop target successfully performed the drop
     *                action
     */
    void handleDragFinished(boolean success, int action);

    /**
     * Called when the current drop target signals that the drag-and-drop
     * operation is finished.
     *
     * @param action the drop action performed by the drop target
     * @param success true if the drop target successfully performed the drop
     *                action
     * @param x the x coordinate of the pointer location in screen coordinates
     *          for the signal
     * @param y the x coordinate of the pointer location in screen coordinates
     *          for the signal
     */
    void handleDragFinished(boolean success, int action, int x, int y);

    /**
     * Terminates the current drag-and-drop operation (if any) and performs
     * the necessary cleanup.
     * @param time the time stamp of the event that triggered drag termination
     *             or XlibWrapper.CurrentTime
     */
    void cleanup(long time);
}
