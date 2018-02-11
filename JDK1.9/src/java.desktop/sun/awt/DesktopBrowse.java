/*
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
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

import java.net.URL;

public abstract class DesktopBrowse {
    private static volatile DesktopBrowse mInstance;

    public static void setInstance(DesktopBrowse instance) {
        if (mInstance != null) {
            throw new IllegalStateException("DesktopBrowse instance has already been set.");
        }
        mInstance = instance;
    }

    public static DesktopBrowse getInstance() {
        return mInstance;
    }


    public abstract void browse(URL url);
}
