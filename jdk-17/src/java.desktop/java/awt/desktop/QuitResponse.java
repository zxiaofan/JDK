/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * @see java.awt.Desktop#setQuitHandler(QuitHandler)
 * @see QuitHandler
 * @see java.awt.Desktop#setQuitStrategy(QuitStrategy)
 * @since 9
 */
public interface QuitResponse {

    /**
     * Notifies the external quit requester that the quit will proceed, and
     * performs the default {@link QuitStrategy}.
     */
    public void performQuit();

    /**
     * Notifies the external quit requester that the user has explicitly
     * canceled the pending quit, and leaves the application running.
     * <p>
     * <b>Note: this will cancel a pending log-out, restart, or shutdown.</b>
     */
    public void cancelQuit();
}
