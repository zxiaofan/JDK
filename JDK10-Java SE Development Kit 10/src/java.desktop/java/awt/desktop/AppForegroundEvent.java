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
 * Event sent when the application has become the foreground app, and when it is
 * no longer the foreground app.
 *
 * @see AppForegroundListener#appRaisedToForeground(AppForegroundEvent)
 * @see AppForegroundListener#appMovedToBackground(AppForegroundEvent)
 *
 * @since 9
 */
public final class AppForegroundEvent extends AppEvent {
    private static final long serialVersionUID = -5513582555740533911L;

    /**
     * Constructs an {@code AppForegroundEvent}
     */
    public AppForegroundEvent() {
    }

}
