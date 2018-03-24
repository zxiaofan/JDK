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

package com.sun.webkit;

import com.sun.webkit.graphics.RenderTheme;
import com.sun.webkit.graphics.ScrollBarTheme;

public abstract class ThemeClient {

    private static RenderTheme defaultRenderTheme;

    public static void setDefaultRenderTheme(RenderTheme theme) {
        defaultRenderTheme = theme;
    }

    public static RenderTheme getDefaultRenderTheme() {
        return defaultRenderTheme;
    }

    protected abstract RenderTheme createRenderTheme();

    protected abstract ScrollBarTheme createScrollBarTheme();
}
