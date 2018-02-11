/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

import java.util.EventListener;

/**
 * The listener interface for receiving display change events.
 * The class that is interested in processing a display change event
 * implements this interface (and all the methods it
 * contains).
 *
 * For Motif, this interface is only used for dragging windows between Xinerama
 * screens.
 *
 * For win32, the listener object created from that class is then registered
 * with the WToolkit object using its {@code addDisplayChangeListener}
 * method. When the display resolution is changed (which occurs,
 * in Windows, either by the user changing the properties of the
 * display through the control panel or other utility or by
 * some other application which has gotten fullscreen-exclusive
 * control of the display), the listener is notified through its
 * displayChanged() or paletteChanged() methods.
 *
 * @author Chet Haase
 * @author Brent Christian
 * @since 1.4
 */
public interface DisplayChangedListener extends EventListener {
    /**
     * Invoked when the display mode has changed.
     */
    public void displayChanged();

    /**
     * Invoked when the palette has changed.
     */
    public void paletteChanged();

}
