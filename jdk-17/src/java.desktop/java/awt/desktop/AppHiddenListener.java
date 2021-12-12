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
 * Implementors are notified when the app is hidden or shown by the user. This
 * notification is helpful for discontinuing a costly animation if it's not
 * visible to the user.
 *
 * @since 9
 */
public interface AppHiddenListener extends SystemEventListener {

    /**
     * Called when the app is hidden.
     *
     * @param  e event
     */
    public void appHidden(AppHiddenEvent e);

    /**
     * Called when the hidden app is shown again (but not necessarily brought to
     * the foreground).
     *
     * @param  e event
     */
    public void appUnhidden(AppHiddenEvent e);
}
