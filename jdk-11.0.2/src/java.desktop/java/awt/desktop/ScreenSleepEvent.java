/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

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
     * Constructs a {@code ScreenSleepEvent}.
     *
     * @throws HeadlessException if {@link GraphicsEnvironment#isHeadless()}
     *         returns {@code true}
     * @throws UnsupportedOperationException if Desktop API is not supported on
     *         the current platform
     * @see Desktop#isDesktopSupported()
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public ScreenSleepEvent() {
    }
}
