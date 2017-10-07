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

class IDWriteFontFamily extends IDWriteFontList {
    IDWriteFontFamily(long ptr) {
        super(ptr);
    }

    IDWriteLocalizedStrings GetFamilyNames() {
        long result = OS.GetFamilyNames(ptr);
        return result != 0 ? new IDWriteLocalizedStrings(result) : null;
    }

    IDWriteFont GetFirstMatchingFont(int weight, int stretch, int style) {
        long result = OS.GetFirstMatchingFont(ptr, weight, stretch, style);
        return result != 0 ? new IDWriteFont(result) : null;
    }
}
