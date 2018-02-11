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

package com.sun.javafx.cursor;

public final class StandardCursorFrame extends CursorFrame {
    private CursorType cursorType;

    public StandardCursorFrame(final CursorType cursorType) {
        this.cursorType = cursorType;
    }

    @Override
    public CursorType getCursorType() {
        return cursorType;
    }
}
