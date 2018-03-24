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

class IWICBitmapLock extends IUnknown {
    IWICBitmapLock(long ptr) {
        super(ptr);
    }

    byte[] GetDataPointer() {
        return OS.GetDataPointer(ptr);
    }

    int GetStride() {
        return OS.GetStride(ptr);
    }
}
