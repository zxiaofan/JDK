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

class ID2D1Factory extends IUnknown {
    ID2D1Factory(long ptr) {
        super(ptr);
    }

    ID2D1RenderTarget CreateWicBitmapRenderTarget(IWICBitmap target, D2D1_RENDER_TARGET_PROPERTIES renderTargetProperties) {
        long result = OS.CreateWicBitmapRenderTarget(ptr, target.ptr, renderTargetProperties);
        return result != 0 ? new ID2D1RenderTarget(result) : null;
    }
}
