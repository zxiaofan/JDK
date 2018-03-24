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
 * Event sent when the application is asked to open its about window.
 *
 * @see AboutHandler#handleAbout
 *
 * @since 9
 */
public final class AboutEvent extends AppEvent {
    private static final long serialVersionUID = -5987180734802756477L;

    /**
     * Constructs an {@code AboutEvent}
     */
    public AboutEvent() {
    }

}
