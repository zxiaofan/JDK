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
 * Event sent when the application is asked to open its preferences window.
 *
 * @see PreferencesHandler#handlePreferences
 *
 * @since 9
 */
public final class PreferencesEvent extends AppEvent {
    private static final long serialVersionUID = -6398607097086476160L;

    /**
     * Constructs a {@code PreferencesEvent}
     */
    public PreferencesEvent() {
    }

}
