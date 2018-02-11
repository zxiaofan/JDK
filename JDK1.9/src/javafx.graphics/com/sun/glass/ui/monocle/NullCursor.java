/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import com.sun.glass.ui.Size;

/**
 * Provides an implementation of NativeCursor that does nothing and does not
 * show a cursor on the screen.
 */
class NullCursor extends NativeCursor {

    @Override
    Size getBestSize() {
        return new Size(16, 16);
    }

    @Override
    void setVisibility(boolean visibility) {
    }

    @Override
    void setImage(byte[] cursorImage) {
    }

    @Override
    void setLocation(int x, int y) {
    }

    @Override
    void setHotSpot(int hotspotX, int hotspotY) {
    }

    @Override
    void shutdown() {
    }
}
