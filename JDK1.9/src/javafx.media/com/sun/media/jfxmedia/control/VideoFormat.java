/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmedia.control;

import java.lang.annotation.Native;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum VideoFormat {
    /** Packed ARGB, in memory A,R,G,B alpha is NOT pre-multiplied.
     *  This is synonymous with BYTE_ARGB */
    ARGB(FormatTypes.FORMAT_TYPE_ARGB),
    /** Packed BGRA, in memory B,G,R,A alpha is pre-multiplied.
     *  This format is synonymous with BYTE_BGRA_PRE or little endian INT_ARGB_PRE */
    BGRA_PRE(FormatTypes.FORMAT_TYPE_BGRA_PRE),
    /** Planar YCbCr 4:2:0, alpha channel is optional. The presence of a fourth
     *  plane indicates alpha is present */
    YCbCr_420p(FormatTypes.FORMAT_TYPE_YCBCR_420P),
    /** Packed YCbCr 4:2:2, no alpha support (Only used on Mac currently). This
     *  format is synonymous with the 'yuvs' pixel format in QuickTime (tm) */
    YCbCr_422(FormatTypes.FORMAT_TYPE_YCBCR_422);

    private int nativeType; // value passed down to native code to represent this format
    private static final Map<Integer, VideoFormat> lookupMap = new HashMap<Integer, VideoFormat>();
    static {
        for (VideoFormat fmt : EnumSet.allOf(VideoFormat.class)) {
            lookupMap.put(fmt.getNativeType(), fmt);
        }
    }

    private VideoFormat(int ntype) {
        nativeType = ntype;
    }

    public int getNativeType() {
        return nativeType;
    }

    public boolean isRGB() {
        return this == ARGB || this == BGRA_PRE;
    }

    public boolean isEqualTo(int ntype) {
        return nativeType == ntype;
    }

    public static VideoFormat formatForType(int ntype) {
        return lookupMap.get(Integer.valueOf(ntype));
    }

    // Constants for JNI headers
    public static class FormatTypes {
        @Native public static final int FORMAT_TYPE_ARGB = 1;
        @Native public static final int FORMAT_TYPE_BGRA_PRE = 2;
        @Native public static final int FORMAT_TYPE_YCBCR_420P = 100;
        @Native public static final int FORMAT_TYPE_YCBCR_422 = 101;
    }
}
