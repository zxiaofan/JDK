/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.image.impl;

import com.sun.javafx.image.BytePixelGetter;
import com.sun.javafx.image.ByteToIntPixelConverter;
import com.sun.javafx.image.IntPixelSetter;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public abstract class BaseByteToIntConverter
    implements ByteToIntPixelConverter
{
    protected final BytePixelGetter getter;
    protected final IntPixelSetter  setter;
    protected final int nSrcElems;

    BaseByteToIntConverter(BytePixelGetter getter, IntPixelSetter setter) {
        this.getter = getter;
        this.setter = setter;
        this.nSrcElems = getter.getNumElements();
    }

    @Override
    public final BytePixelGetter getGetter() {
        return getter;
    }

    @Override
    public final IntPixelSetter getSetter() {
        return setter;
    }

    abstract void doConvert(byte srcarr[], int srcoff, int srcscanbytes,
                            int  dstarr[], int dstoff, int dstscanints,
                            int w, int h);

    abstract void doConvert(ByteBuffer srcbuf, int srcoff, int srcscanbytes,
                            IntBuffer  dstbuf, int dstoff, int dstscanints,
                            int w, int h);

    @Override
    public final void convert(byte srcarr[], int srcoff, int srcscanbytes,
                              int  dstarr[], int dstoff, int dstscanints,
                              int w, int h)
    {
        if (w <= 0 || h <= 0) return;
        if (srcscanbytes == w * nSrcElems &&
            dstscanints  == w)
        {
            w *= h;
            h = 1;
        }
        doConvert(srcarr, srcoff, srcscanbytes,
                  dstarr, dstoff, dstscanints,
                  w, h);
    }

    @Override
    public final void convert(ByteBuffer srcbuf, int srcoff, int srcscanbytes,
                              IntBuffer  dstbuf, int dstoff, int dstscanints,
                              int w, int h)
    {
        if (w <= 0 || h <= 0) return;
        if (srcscanbytes == w * nSrcElems &&
            dstscanints  == w)
        {
            w *= h;
            h = 1;
        }
        if (srcbuf.hasArray() && dstbuf.hasArray()) {
            srcoff += srcbuf.arrayOffset();
            dstoff += dstbuf.arrayOffset();
            doConvert(srcbuf.array(), srcoff, srcscanbytes,
                      dstbuf.array(), dstoff, dstscanints,
                      w, h);
        } else {
            doConvert(srcbuf, srcoff, srcscanbytes,
                      dstbuf, dstoff, dstscanints,
                      w, h);
        }
    }

    @Override
    public final void convert(ByteBuffer srcbuf,   int srcoff, int srcscanbytes,
                              int        dstarr[], int dstoff, int dstscanints,
                              int w, int h)
    {
        if (w <= 0 || h <= 0) return;
        if (srcscanbytes == w * nSrcElems &&
            dstscanints  == w)
        {
            w *= h;
            h = 1;
        }
        if (srcbuf.hasArray()) {
            byte srcarr[] = srcbuf.array();
            srcoff += srcbuf.arrayOffset();
            doConvert(srcarr, srcoff, srcscanbytes,
                      dstarr, dstoff, dstscanints,
                      w, h);
        } else {
            IntBuffer dstbuf = IntBuffer.wrap(dstarr);
            doConvert(srcbuf, srcoff, srcscanbytes,
                      dstbuf, dstoff, dstscanints,
                      w, h);
        }
    }

    @Override
    public final void convert(byte      srcarr[], int srcoff, int srcscanbytes,
                              IntBuffer dstbuf,   int dstoff, int dstscanints,
                              int w, int h)
    {
        if (w <= 0 || h <= 0) return;
        if (srcscanbytes == w * nSrcElems &&
            dstscanints  == w)
        {
            w *= h;
            h = 1;
        }
        if (dstbuf.hasArray()) {
            int dstarr[] = dstbuf.array();
            dstoff += dstbuf.arrayOffset();
            doConvert(srcarr, srcoff, srcscanbytes,
                      dstarr, dstoff, dstscanints,
                      w, h);
        } else {
            ByteBuffer srcbuf = ByteBuffer.wrap(srcarr);
            doConvert(srcbuf, srcoff, srcscanbytes,
                      dstbuf, dstoff, dstscanints,
                      w, h);
        }
    }
}
