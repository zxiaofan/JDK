/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font.directwrite;

class IDWriteFontList extends IUnknown {
    IDWriteFontList(long ptr) {
        super(ptr);
    }

    int GetFontCount() {
        return OS.GetFontCount(ptr);
    }

    IDWriteFont GetFont(int index) {
        long result = OS.GetFont(ptr, index);
        return result != 0 ? new IDWriteFont(result) : null;
    }

}
