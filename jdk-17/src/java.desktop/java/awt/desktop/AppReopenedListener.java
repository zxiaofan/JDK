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
 * Implementors receive notification when the app has been asked to open again.
 * <p>
 * This notification is useful for showing a new document when your app has no
 * open windows.
 *
 * @since 9
 */
public interface AppReopenedListener extends SystemEventListener {

    /**
     * Called when the app has been reopened.
     *
     * @param  e the request to reopen the app
     */
    public void appReopened(AppReopenedEvent e);
}
