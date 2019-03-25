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
 * Event sent when the application is asked to quit.
 *
 * @see QuitHandler#handleQuitRequestWith(QuitEvent, QuitResponse)
 *
 * @since 9
 */
public final class QuitEvent extends AppEvent {

    private static final long serialVersionUID = -256100795532403146L;

    /**
     * Constructs a {@code QuitEvent}.
     *
     * @throws HeadlessException if {@link GraphicsEnvironment#isHeadless()}
     *         returns {@code true}
     * @throws UnsupportedOperationException if Desktop API is not supported on
     *         the current platform
     * @see Desktop#isDesktopSupported()
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public QuitEvent() {
    }
}
