/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.plugin;

import java.net.URL;

interface PluginHandler {
    String getName();
    String getFileName();
    String getDescription();

    String[] supportedMIMETypes();
    boolean isSupportedMIMEType(String mimeType);
    boolean isSupportedPlatform();
    Plugin createPlugin(URL url, String mimeType,
                           String[] pNames, String[] pValues);
}
