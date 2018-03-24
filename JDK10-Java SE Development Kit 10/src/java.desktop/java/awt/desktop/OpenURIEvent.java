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

import java.net.URI;


/**
 * Event sent when the app is asked to open a {@code URI}.
 *
 * @see OpenURIHandler#openURI(OpenURIEvent)
 *
 * @since 9
 */
public final class OpenURIEvent extends AppEvent {
    private static final long serialVersionUID = 221209100935933476L;
    final URI uri;

    /**
     * Constructs an {@code OpenURIEvent}
     * @param uri {@code URI}
     */
    public OpenURIEvent(final URI uri) {
        this.uri = uri;
    }

    /**
     * Get the {@code URI} the app was asked to open
     * @return the {@code URI}
     */
    public URI getURI() {
        return uri;
    }

}
