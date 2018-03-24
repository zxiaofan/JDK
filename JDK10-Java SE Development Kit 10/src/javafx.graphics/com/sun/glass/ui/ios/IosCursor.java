/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.ios;

import com.sun.glass.ui.Cursor;
import com.sun.glass.ui.Pixels;

/**
 * iOS platform implementation class of glass Cursor.
 * On iOS touch there is no cursor. Keeping this stub class as
 * a starting point for implementing cursor emulation if needed, etc.
 */
final class IosCursor extends Cursor {
    protected IosCursor(int type) {
        super(type);
    }

    protected IosCursor(int x, int y, Pixels pixels) {
        super(x, y, pixels);
    }

    @Override
    native protected long _createCursor(int x, int y, Pixels pixels);
    native private void _set(int type);
    native private void _setCustom(long ptr);

    // Called from IosWindow._setCursor()
    void set() {
        int type = getType();
        setVisible(type != CURSOR_NONE);

        switch (type) {
            case CURSOR_NONE:
                break;
            case CURSOR_CUSTOM:
                _setCustom(getNativeCursor());
                break;
            default:
                _set(type);
                break;
        }
    }
}
