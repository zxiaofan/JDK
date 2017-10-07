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

class IDWriteFontFile extends IUnknown {
    IDWriteFontFile(long ptr) {
        super(ptr);
    }

    int Analyze(boolean[] isSupportedFontType, int[] fontFileType, int[] fontFaceType, int[] numberOfFaces) {
        return OS.Analyze(ptr, isSupportedFontType, fontFileType, fontFaceType, numberOfFaces);
    }
}
