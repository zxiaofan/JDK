/*
 * Copyright (c) 2005, 2011, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.AWTEvent;
import java.awt.Component;

/**
 * Sent when one of the following events occur on the grabbed window: <ul>
 * <li> it looses focus, but not to one of the owned windows
 * <li> mouse click on the outside area happens (except for one of the owned windows)
 * <li> switch to another application or desktop happens
 * <li> click in the non-client area of the owning window or this window happens
 * </ul>
 *
 * <p>Notice that this event is not generated on mouse click inside of the window area.
 * <p>To listen for this event, install AWTEventListener with {@value sun.awt.SunToolkit#GRAB_EVENT_MASK}
 */
@SuppressWarnings("serial")
public class UngrabEvent extends AWTEvent {

    private static final int UNGRAB_EVENT_ID = 1998;

    public UngrabEvent(Component source) {
        super(source, UNGRAB_EVENT_ID);
    }

    public String toString() {
        return "sun.awt.UngrabEvent[" + getSource() + "]";
    }
}
