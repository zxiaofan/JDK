/*
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
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
import java.io.Serial;
import java.net.URI;

/**
 * Event sent when the app is asked to open a {@code URI}.
 *
 * @see OpenURIHandler#openURI(OpenURIEvent)
 * @since 9
 */
public final class OpenURIEvent extends AppEvent {

    /**
     * Use serialVersionUID from JDK 9 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 221209100935933476L;

    /**
     * The {@code URI} the app was asked to open.
     */
    final URI uri;

    /**
     * Constructs an {@code OpenURIEvent}.
     *
     * @param  uri the {@code URI} the app was asked to open
     * @throws HeadlessException if {@link GraphicsEnvironment#isHeadless()}
     *         returns {@code true}
     * @throws UnsupportedOperationException if Desktop API is not supported on
     *         the current platform
     * @see Desktop#isDesktopSupported()
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public OpenURIEvent(final URI uri) {
        this.uri = uri;
    }

    /**
     * Get the {@code URI} the app was asked to open.
     *
     * @return the {@code URI}
     */
    public URI getURI() {
        return uri;
    }
}
