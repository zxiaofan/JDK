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
 * Event sent when the application is asked to re-open itself.
 *
 * @see AppReopenedListener#appReopened(AppReopenedEvent)
 *
 * @since 9
 */
public final class AppReopenedEvent extends AppEvent {
    private static final long serialVersionUID = 1503238361530407990L;

    /**
     * Constructs an {@code AppReopenedEvent}
     */
    public AppReopenedEvent() {
    }

}
