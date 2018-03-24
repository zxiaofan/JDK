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

package java.awt.desktop;

/**
 * Used to respond to a request to quit the application.
 *
 * @see java.awt.Desktop#setQuitHandler(java.awt.desktop.QuitHandler)
 * @see java.awt.desktop.QuitHandler
 * @see java.awt.Desktop#setQuitStrategy(java.awt.desktop.QuitStrategy)
 *
 * @since 9
 */
public interface QuitResponse {

    /**
     * Notifies the external quit requester that the quit will proceed, and performs the default {@link java.awt.desktop.QuitStrategy}.
     */
    public void performQuit();

    /**
     * Notifies the external quit requester that the user has explicitly canceled the pending quit, and leaves the application running.
     * <b>Note: this will cancel a pending log-out, restart, or shutdown.</b>
     */
    public void cancelQuit();
}
