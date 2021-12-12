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
 * An implementor is notified when the application is asked to open a URI.
 *
 * @see java.awt.Desktop#setOpenURIHandler(OpenURIHandler)
 * @since 9
 */
public interface OpenURIHandler {

    /**
     * Called when the application is asked to open a {@code URI}.
     *
     * @param  e the request to open a {@code URI}
     */
    public void openURI(OpenURIEvent e);
}
