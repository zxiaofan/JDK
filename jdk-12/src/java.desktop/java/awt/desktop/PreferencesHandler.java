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
 * An implementor is notified when the app is asked to show its preferences UI.
 *
 * @see java.awt.Desktop#setPreferencesHandler(java.awt.desktop.PreferencesHandler)
 *
 * @since 9
 */
public interface PreferencesHandler {
    /**
     * Called when the app is asked to show its preferences UI.
     * @param e the request to show preferences.
     */
    public void handlePreferences(final PreferencesEvent e);
}
