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

import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

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
     * Constructs an {@code AppForegroundEvent}.
     *
     * @throws HeadlessException if {@link GraphicsEnvironment#isHeadless()}
     *         returns {@code true}
     * @throws UnsupportedOperationException if Desktop API is not supported on
     *         the current platform
     * @see Desktop#isDesktopSupported()
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public AppForegroundEvent() {
    }
}
