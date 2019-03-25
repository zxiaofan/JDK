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
 * Event sent when the application has been hidden or shown.
 *
 * @see AppHiddenListener#appHidden(AppHiddenEvent)
 * @see AppHiddenListener#appUnhidden(AppHiddenEvent)
 *
 * @since 9
 */
public final class AppHiddenEvent extends AppEvent {

    private static final long serialVersionUID = 2637465279476429224L;

    /**
     * Constructs an {@code AppHiddenEvent}.
     *
     * @throws HeadlessException if {@link GraphicsEnvironment#isHeadless()}
     *         returns {@code true}
     * @throws UnsupportedOperationException if Desktop API is not supported on
     *         the current platform
     * @see Desktop#isDesktopSupported()
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public AppHiddenEvent() {
    }
}
