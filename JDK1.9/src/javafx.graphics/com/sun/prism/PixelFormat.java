/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism;

public enum PixelFormat {
    // Note: do not change the order of the formats as their ordinals may
    // be used for determining the format

    // 4-BYTE types
    INT_ARGB_PRE (DataType.INT,   1, true,  false),

    // the same format as INT_ARGB_PRE
    BYTE_BGRA_PRE(DataType.BYTE,  4, true,  false),

    // 3-BYTE types:
    BYTE_RGB     (DataType.BYTE,  3, true,  true),

    // L8, A8 types:
    // NOTE : we might need L8A8 16-bit type
    BYTE_GRAY    (DataType.BYTE,  1, true,  true),
    BYTE_ALPHA   (DataType.BYTE,  1, false, false),

    // Media types
    MULTI_YCbCr_420(DataType.BYTE,  1, false, true), // Multitexture format, requires pixel shader support
    BYTE_APPLE_422 (DataType.BYTE, 2, false, true),

    // flating point types:
    FLOAT_XYZW     (DataType.FLOAT, 4, false, true);

    /*
     * NOTE: BYTE_APPLE_422 is assumed to be '2vuy' component data, NOT 'yuvs'!
     */

    public enum DataType {
        BYTE (1),
        INT  (4),
        FLOAT(4);

        private int sizeInBytes;

        private DataType(int sizeInBytes) {
            this.sizeInBytes = sizeInBytes;
        }

        public int getSizeInBytes() {
            return sizeInBytes;
        }
    }

    // these need to match the plane indexes from JFXMedia
    public final static int YCBCR_PLANE_LUMA = 0;
    public final static int YCBCR_PLANE_CHROMARED = 1;
    public final static int YCBCR_PLANE_CHROMABLUE = 2;
    public final static int YCBCR_PLANE_ALPHA = 3;

    private DataType dataType;
    private int elemsPerPixelUnit;
    private boolean rgb;
    private boolean opaque;

    private PixelFormat(DataType dataType, int elemsPerPixelUnit,
                        boolean rgb, boolean opaque)
    {
        this.dataType = dataType;
        this.elemsPerPixelUnit = elemsPerPixelUnit;
        this.rgb = rgb;
        this.opaque = opaque;
    }

    public DataType getDataType() {
        return dataType;
    }

    public int getBytesPerPixelUnit() {
        return elemsPerPixelUnit * dataType.getSizeInBytes();
    }

    public int getElemsPerPixelUnit() {
        return elemsPerPixelUnit;
    }

    public boolean isRGB() {
        return rgb;
    }

    public boolean isOpaque() {
        return opaque;
    }
}
