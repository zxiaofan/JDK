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
 * Event sent when the application is asked to quit.
 *
 * @see QuitHandler#handleQuitRequestWith(QuitEvent, QuitResponse)
 *
 * @since 9
 */
public final class QuitEvent extends AppEvent {

    private static final long serialVersionUID = -256100795532403146L;

    /**
     * Constructs a {@code QuitEvent}
     */
    public QuitEvent() {
    }
}
