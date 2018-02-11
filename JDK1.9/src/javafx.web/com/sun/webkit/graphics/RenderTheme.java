/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.graphics;

import java.nio.ByteBuffer;

import java.lang.annotation.Native;

public abstract class RenderTheme extends Ref {

    @Native public static final int TEXT_FIELD = 0;
    @Native public static final int BUTTON = 1;
    @Native public static final int CHECK_BOX = 2;
    @Native public static final int RADIO_BUTTON = 3;
    @Native public static final int MENU_LIST = 4;
    @Native public static final int MENU_LIST_BUTTON = 5;
    @Native public static final int SLIDER = 6;
    @Native public static final int PROGRESS_BAR = 7;
    @Native public static final int METER = 8;

    @Native public static final int CHECKED = 1 << 0;
    @Native public static final int INDETERMINATE = 1 << 1;
    @Native public static final int ENABLED = 1 << 2;
    @Native public static final int FOCUSED = 1 << 3;
    @Native public static final int PRESSED = 1 << 4;
    @Native public static final int HOVERED = 1 << 5;
    @Native public static final int READ_ONLY = 1 << 6;

    @Native public static final int BACKGROUND = 0;
    @Native public static final int FOREGROUND = 1;

    protected abstract Ref createWidget(long id, int widgetIndex, int state, int w, int h, int bgColor, ByteBuffer extParams);

    public abstract void drawWidget(WCGraphicsContext g, Ref widget, int x, int y);

    protected abstract int getRadioButtonSize();

    protected abstract int getSelectionColor(int index);

    public abstract WCSize getWidgetSize(Ref widget);
}
