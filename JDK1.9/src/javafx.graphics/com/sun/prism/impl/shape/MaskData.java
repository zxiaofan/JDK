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

package com.sun.prism.impl.shape;

import com.sun.prism.PixelFormat;
import com.sun.prism.Texture;
import java.nio.ByteBuffer;

public class MaskData {

    private ByteBuffer maskBuffer;
    private int originX;
    private int originY;
    private int width;
    private int height;

    public MaskData() {
    }

    public ByteBuffer getMaskBuffer() {
        return maskBuffer;
    }

    public int getOriginX() {
        return originX;
    }

    public int getOriginY() {
        return originY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void uploadToTexture(Texture tex, int dstx, int dsty,
                                boolean skipFlush)
    {
        int scan = width * tex.getPixelFormat().getBytesPerPixelUnit();
        tex.update(maskBuffer, tex.getPixelFormat(),
                   dstx, dsty, 0, 0, width, height,
                   scan, skipFlush);
    }

    public void update(ByteBuffer maskBuffer,
                       int originX, int originY, int width, int height)
    {
        this.maskBuffer = maskBuffer;
        this.originX = originX;
        this.originY = originY;
        this.width = width;
        this.height = height;
    }

    public static MaskData create(byte[] pixels,
                                  int originX, int originY,
                                  int width, int height)
    {
        MaskData maskData = new MaskData();
        maskData.update(ByteBuffer.wrap(pixels), originX, originY, width, height);
        return maskData;
    }
}
