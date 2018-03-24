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

class IDWriteFont extends IUnknown {
    IDWriteFont(long ptr) {
        super(ptr);
    }

    IDWriteFontFace CreateFontFace() {
        long result = OS.CreateFontFace(ptr);
        return result != 0 ? new IDWriteFontFace(result) : null;
    }

    IDWriteLocalizedStrings GetFaceNames() {
        long result = OS.GetFaceNames(ptr);
        return result != 0 ? new IDWriteLocalizedStrings(result) : null;
    }

    IDWriteFontFamily GetFontFamily() {
        long result = OS.GetFontFamily(ptr);
        return result != 0 ? new IDWriteFontFamily(result) : null;
    }

    IDWriteLocalizedStrings GetInformationalStrings(int informationalStringID) {
        long result = OS.GetInformationalStrings(ptr, informationalStringID);
        return result != 0 ? new IDWriteLocalizedStrings(result) : null;
    }

    int GetSimulations() {
        return OS.GetSimulations(ptr);
    }

    int GetStretch() {
        return OS.GetStretch(ptr);
    }

    int GetStyle() {
        return OS.GetStyle(ptr);
    }

    int GetWeight() {
        return OS.GetWeight(ptr);
    }
}
