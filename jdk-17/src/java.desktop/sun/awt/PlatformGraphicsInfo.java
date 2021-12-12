/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

public class PlatformGraphicsInfo {

    public static GraphicsEnvironment createGE() {
        return new Win32GraphicsEnvironment();
    }

    public static Toolkit createToolkit() {
        return new sun.awt.windows.WToolkit();
    }

    public static boolean getDefaultHeadlessProperty() {
        // On Windows, we assume we can always create headful apps.
        // Here is where we can add code that would actually check.
        return false;
    }

    /*
     * Called from java.awt.GraphicsEnvironment when
     * getDefaultHeadlessProperty() has returned true, and
     * the application has called an API that requires headful.
     */
    public static String getDefaultHeadlessMessage() {
        return
            "\nThe application does not have desktop access,\n" +
            "but this program performed an operation which requires it.";
    }

}
