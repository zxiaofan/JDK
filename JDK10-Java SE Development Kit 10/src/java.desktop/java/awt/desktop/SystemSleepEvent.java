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
 * Event sent when the system enters and exits power save sleep.
 *
 * @see SystemSleepListener#systemAboutToSleep(SystemSleepEvent)
 * @see SystemSleepListener#systemAwoke(SystemSleepEvent)
 *
 * @since 9
 */
public final class SystemSleepEvent extends AppEvent {

    private static final long serialVersionUID = 11372269824930549L;

    /**
     * Constructs a SystemSleepEvent
     */
    public SystemSleepEvent() {
    }
}
