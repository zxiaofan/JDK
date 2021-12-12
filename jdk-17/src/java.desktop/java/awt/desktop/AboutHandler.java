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
 * An implementer receives notification when the app is asked to show its about
 * dialog.
 *
 * @see java.awt.Desktop#setAboutHandler(AboutHandler)
 * @since 9
 */
public interface AboutHandler {

    /**
     * Called when the application is asked to show its about dialog.
     *
     * @param  e the request to show the about dialog
     */
    public void handleAbout(AboutEvent e);
}
