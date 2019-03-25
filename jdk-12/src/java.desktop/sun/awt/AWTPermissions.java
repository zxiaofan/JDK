/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.AWTPermission;

/**
 * Defines the {@code AWTPermission} objects used for permission checks.
 */

public final class AWTPermissions {
    private AWTPermissions() { }

    public static final AWTPermission TOPLEVEL_WINDOW_PERMISSION =
        new AWTPermission("showWindowWithoutWarningBanner");

    public static final AWTPermission ACCESS_CLIPBOARD_PERMISSION =
        new AWTPermission("accessClipboard");

    public static final AWTPermission CHECK_AWT_EVENTQUEUE_PERMISSION =
        new AWTPermission("accessEventQueue");

    public static final AWTPermission TOOLKIT_MODALITY_PERMISSION =
        new AWTPermission("toolkitModality");

    public static final AWTPermission READ_DISPLAY_PIXELS_PERMISSION =
        new AWTPermission("readDisplayPixels");

    public static final AWTPermission CREATE_ROBOT_PERMISSION =
        new AWTPermission("createRobot");

    public static final AWTPermission WATCH_MOUSE_PERMISSION =
        new AWTPermission("watchMousePointer");

    public static final AWTPermission SET_WINDOW_ALWAYS_ON_TOP_PERMISSION =
        new AWTPermission("setWindowAlwaysOnTop");

    public static final AWTPermission ALL_AWT_EVENTS_PERMISSION =
        new AWTPermission("listenToAllAWTEvents");

    public static final AWTPermission ACCESS_SYSTEM_TRAY_PERMISSION =
        new AWTPermission("accessSystemTray");
}
