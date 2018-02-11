/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui.gtk;

import com.sun.glass.ui.Cursor;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.Size;

final class GtkCursor extends Cursor {

    GtkCursor(int type) {
        super(type);
    }

    GtkCursor(int x, int y, Pixels pixels) {
        super(x, y, pixels);
    }

    @Override
    protected native long _createCursor(int x, int y, Pixels pixels);

    native static Size _getBestSize(int width, int height);
}
