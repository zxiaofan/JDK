/*
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.applet;

import java.net.URL;
import java.awt.Image;

/**
 * Part of this class still remains only to support legacy, 100%-impure
 * applications such as HotJava 1.0.1.
 */
@Deprecated
public class AppletResourceLoader {
    public static Image getImage(URL url) {
        return AppletViewer.getCachedImage(url);
    }

    public static void flushImages() {
        AppletViewer.flushImageCache();
    }
}
