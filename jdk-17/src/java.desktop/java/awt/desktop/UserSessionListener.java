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
 * Implementors receive notification when the user session changes.
 * <p>
 * This notification is useful for discontinuing a costly animation, or
 * indicating that the user is no longer present on a network service.
 * <p>
 * Some systems may provide a reason of the user session change.
 *
 * @see UserSessionEvent.Reason#UNSPECIFIED
 * @see UserSessionEvent.Reason#CONSOLE
 * @see UserSessionEvent.Reason#REMOTE
 * @see UserSessionEvent.Reason#LOCK
 * @since 9
 */
public interface UserSessionListener extends SystemEventListener {

    /**
     * Called when the user session has been switched away.
     *
     * @param  e the user session switch event
     */
    public void userSessionDeactivated(UserSessionEvent e);

    /**
     * Called when the user session has been switched to.
     *
     * @param  e the user session switch event
     */
    public void userSessionActivated(UserSessionEvent e);
}
