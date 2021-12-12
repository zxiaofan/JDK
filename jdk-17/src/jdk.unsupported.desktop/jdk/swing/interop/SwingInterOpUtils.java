/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.swing.interop;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.AWTEvent;
import sun.awt.SunToolkit;
import sun.awt.AppContext;
import sun.awt.UngrabEvent;

/**
 * This class provides static utility methods to be used by FX swing interop
 * to access and use jdk internal classes like SunToolkit, AppContext
 * and UngrabEvent.
 *
 * @since 11
 */
public class SwingInterOpUtils {

    /**
     * Constructs a {@code SwingInterOpUtils}.
     */
    public SwingInterOpUtils() {}

    public static void postEvent(Object target, java.awt.AWTEvent e) {
        AppContext context = SunToolkit.targetToAppContext(target);
        if (context != null) {
            SunToolkit.postEvent(context, e);
        }
    }

    public static void grab(Toolkit toolkit, Window window) {
        if (toolkit instanceof SunToolkit) {
            ((SunToolkit)toolkit).grab(window);
        }
    }

    public static void ungrab(Toolkit toolkit, Window window) {
        if (toolkit instanceof SunToolkit) {
            ((SunToolkit)toolkit).ungrab(window);
        }
    }

    public static boolean isUngrabEvent(AWTEvent e) {
        return e instanceof UngrabEvent;
    }

    public static final int GRAB_EVENT_MASK = SunToolkit.GRAB_EVENT_MASK;

}
