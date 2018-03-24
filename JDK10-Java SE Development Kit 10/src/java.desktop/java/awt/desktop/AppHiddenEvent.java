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
     * Constructs an {@code AppHiddenEvent}
     */
    public AppHiddenEvent() {
    }

}
