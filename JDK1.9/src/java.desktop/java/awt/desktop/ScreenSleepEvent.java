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
 * Event sent when the displays attached to the system enter and exit power save
 * sleep.
 *
 * @see ScreenSleepListener#screenAboutToSleep(ScreenSleepEvent)
 * @see ScreenSleepListener#screenAwoke(ScreenSleepEvent)
 *
 * @since 9
 */
public final class ScreenSleepEvent extends AppEvent {

    private static final long serialVersionUID = 7521606180376544150L;

    /**
     * Constructs a ScreenSleepEvent
     */
    public ScreenSleepEvent() {
    }
}
