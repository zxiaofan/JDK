/*
 * Copyright (c) 1996, Oracle and/or its affiliates. All rights reserved.
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

/*
 * AppletViewerFactory.java
 */

package sun.applet;

import java.util.Hashtable;
import java.net.URL;
import java.awt.MenuBar;

@Deprecated(since = "9")
public interface AppletViewerFactory {
        public AppletViewer createAppletViewer(int x, int y, URL doc,
                                               Hashtable<String, String> atts);
        public MenuBar getBaseMenuBar();
        public boolean isStandalone();
}
