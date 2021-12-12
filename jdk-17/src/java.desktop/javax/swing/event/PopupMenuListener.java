/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.event;

import java.util.EventListener;

/**
 * A popup menu listener
 *
 * @author Arnaud Weber
 */
public interface PopupMenuListener extends EventListener {

    /**
     *  This method is called before the popup menu becomes visible
     *
     * @param e a {@code PopupMenuEvent} containing the source of the event
     */
    void popupMenuWillBecomeVisible(PopupMenuEvent e);

    /**
     * This method is called before the popup menu becomes invisible
     * Note that a JPopupMenu can become invisible any time
     *
     * @param e a {@code PopupMenuEvent} containing the source of the event
     */
    void popupMenuWillBecomeInvisible(PopupMenuEvent e);

    /**
     * This method is called when the popup menu is canceled
     *
     * @param e a {@code PopupMenuEvent} containing the source of the event
     */
    void popupMenuCanceled(PopupMenuEvent e);
}
