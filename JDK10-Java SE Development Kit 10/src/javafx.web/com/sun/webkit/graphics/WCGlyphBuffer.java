/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.graphics;

public class WCGlyphBuffer {
    public int[] glyphs;
    public float[] advances;
    public float initialAdvance;

    public WCGlyphBuffer(int[] glyphs, float[] advances, float initialAdvance) {
        this.glyphs = glyphs;
        this.advances = advances;
        this.initialAdvance = initialAdvance;
    }
}
