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

class IDWriteTextLayout extends IUnknown {
    IDWriteTextLayout(long ptr) {
        super(ptr);
    }

    int Draw(long clientData, JFXTextRenderer renderer, float x , float y) {
        return OS.Draw(ptr, clientData, renderer.ptr, x, y);
    }
}
