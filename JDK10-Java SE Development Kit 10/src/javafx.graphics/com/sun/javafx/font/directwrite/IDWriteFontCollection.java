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

class IDWriteFontCollection extends IUnknown {
    IDWriteFontCollection(long ptr) {
        super(ptr);
    }

    int GetFontFamilyCount() {
        return OS.GetFontFamilyCount(ptr);
    }

    IDWriteFontFamily GetFontFamily(int index) {
        long result = OS.GetFontFamily(ptr, index);
        return result != 0 ? new IDWriteFontFamily(result) : null;
    }

    int FindFamilyName(String familyName) {
        return OS.FindFamilyName(ptr, (familyName+'\0').toCharArray());
    }

    IDWriteFont GetFontFromFontFace(IDWriteFontFace fontface) {
        long result = OS.GetFontFromFontFace(ptr, fontface.ptr);
        return result != 0 ? new IDWriteFont(result) : null;
    }
}
