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
     * Constructs a {@code SystemSleepEvent}.
     *
     * @throws HeadlessException if {@link GraphicsEnvironment#isHeadless()}
     *         returns {@code true}
     * @throws UnsupportedOperationException if Desktop API is not supported on
     *         the current platform
     * @see Desktop#isDesktopSupported()
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public SystemSleepEvent() {
    }
}
