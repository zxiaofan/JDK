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

class IDWriteLocalizedStrings extends IUnknown {
    IDWriteLocalizedStrings(long ptr) {
        super(ptr);
    }

    int FindLocaleName(String locale) {
        return OS.FindLocaleName(ptr, (locale+'\0').toCharArray());
    }

    int GetStringLength(int index) {
        return OS.GetStringLength(ptr, index);
    }

    String GetString(int index, int size) {
        char[] buffer = OS.GetString(ptr, index, size + 1);//length must include space for null-terminator
        return buffer != null ? new String(buffer, 0, size) : null;
    }
}
