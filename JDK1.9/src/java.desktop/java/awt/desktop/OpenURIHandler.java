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
 * An implementor is notified when the application is asked to open a URI.
 *
 * @see java.awt.Desktop#setOpenURIHandler(java.awt.desktop.OpenURIHandler)
 *
 * @since 9
 */
public interface OpenURIHandler {
    /**
     * Called when the application is asked to open a {@code URI}
     * @param e the request to open a {@code URI}
     */
    public void openURI(final OpenURIEvent e);
}
