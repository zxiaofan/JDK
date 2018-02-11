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

import com.sun.javafx.image.IntPixelAccessor;
import com.sun.javafx.image.IntPixelGetter;
import com.sun.javafx.image.IntPixelSetter;
import com.sun.javafx.image.IntToIntPixelConverter;
import java.nio.IntBuffer;

public abstract class BaseIntToIntConverter
    implements IntToIntPixelConverter
{
    protected final IntPixelGetter getter;
    protected final IntPixelSetter setter;

    public BaseIntToIntConverter(IntPixelGetter getter, IntPixelSetter setter) {
        this.getter = getter;
        this.setter = setter;
    }

    @Override
    public final IntPixelGetter getGetter() {
        return getter;
    }

    @Override
    public final IntPixelSetter getSetter() {
        return setter;
    }

    abstract void doConvert(int srcarr[], int srcoff, int srcscanints,
                            int dstarr[], int dstoff, int dstscanints,
                            int w, int h);

    abstract void doConvert(IntBuffer srcbuf, int srcoff, int srcscanints,
                            IntBuffer dstbuf, int dstoff, int dstscanints,
                            int w, int h);

    @Override
    public final void convert(int srcarr[], int srcoff, int srcscanints,
                              int dstarr[], int dstoff, int dstscanints,
                              int w, int h)
    {
        if (w <= 0 || h <= 0) return;
        if (srcscanints == w &&
            dstscanints == w)
        {
            w *= h;
            h = 1;
        }
        doConvert(srcarr, srcoff, srcscanints,
                  dstarr, dstoff, dstscanints,
                  w, h);
    }

    @Override
    public final void convert(IntBuffer srcbuf, int srcoff, int srcscanints,
                              IntBuffer dstbuf, int dstoff, int dstscanints,
                              int w, int h)
    {
        if (w <= 0 || h <= 0) return;
        if (srcscanints == w &&
            dstscanints == w)
        {
            w *= h;
            h = 1;
        }
        if (srcbuf.hasArray() && dstbuf.hasArray()) {
            srcoff += srcbuf.arrayOffset();
            dstoff += dstbuf.arrayOffset();
            doConvert(srcbuf.array(), srcoff, srcscanints,
                      dstbuf.array(), dstoff, dstscanints,
                      w, h);
        } else {
            doConvert(srcbuf, srcoff, srcscanints,
                      dstbuf, dstoff, dstscanints,
                      w, h);
        }
    }

    @Override
    public final void convert(IntBuffer srcbuf,   int srcoff, int srcscanints,
                              int       dstarr[], int dstoff, int dstscanints,
                              int w, int h)
    {
        if (w <= 0 || h <= 0) return;
        if (srcscanints == w &&
            dstscanints == w)
        {
            w *= h;
            h = 1;
        }
        if (srcbuf.hasArray()) {
            int srcarr[] = srcbuf.array();
            srcoff += srcbuf.arrayOffset();
            doConvert(srcarr, srcoff, srcscanints,
                      dstarr, dstoff, dstscanints,
                      w, h);
        } else {
            IntBuffer dstbuf = IntBuffer.wrap(dstarr);
            doConvert(srcbuf, srcoff, srcscanints,
                      dstbuf, dstoff, dstscanints,
                      w, h);
        }
    }

    @Override
    public final void convert(int       srcarr[], int srcoff, int srcscanints,
                              IntBuffer dstbuf,   int dstoff, int dstscanints,
                              int w, int h)
    {
        if (w <= 0 || h <= 0) return;
        if (srcscanints == w &&
            dstscanints == w)
        {
            w *= h;
            h = 1;
        }
        if (dstbuf.hasArray()) {
            int dstarr[] = dstbuf.array();
            dstoff += dstbuf.arrayOffset();
            doConvert(srcarr, srcoff, srcscanints,
                      dstarr, dstoff, dstscanints,
                      w, h);
        } else {
            IntBuffer srcbuf = IntBuffer.wrap(srcarr);
            doConvert(srcbuf, srcoff, srcscanints,
                      dstbuf, dstoff, dstscanints,
                      w, h);
        }
    }

    static IntToIntPixelConverter create(IntPixelAccessor fmt) {
        return new IntAnyToSameConverter(fmt);
    }

    static class IntAnyToSameConverter extends BaseIntToIntConverter {
        IntAnyToSameConverter(IntPixelAccessor fmt) {
            super(fmt, fmt);
        }

        @Override
        void doConvert(int srcarr[], int srcoff, int srcscanints,
                       int dstarr[], int dstoff, int dstscanints,
                       int w, int h)
        {
            while (--h >= 0) {
                System.arraycopy(srcarr, srcoff, dstarr, dstoff, w);
                srcoff += srcscanints;
                dstoff += dstscanints;
            }
        }

        @Override
        void doConvert(IntBuffer srcbuf, int srcoff, int srcscanints,
                       IntBuffer dstbuf, int dstoff, int dstscanints,
                       int w, int h)
        {
            int srclimit = srcbuf.limit();
            int origsrcpos = srcbuf.position();
            int origdstpos = dstbuf.position();
            try {
                while (--h >= 0) {
                    int newlimit = srcoff + w;
                    if (newlimit > srclimit) {
                        throw new IndexOutOfBoundsException("" + srclimit);
                    }
                    srcbuf.limit(newlimit);
                    srcbuf.position(srcoff);
                    dstbuf.position(dstoff);
                    dstbuf.put(srcbuf);
                    srcoff += srcscanints;
                    dstoff += dstscanints;
                }
            } finally {
                srcbuf.limit(srclimit);
                srcbuf.position(origsrcpos);
                dstbuf.position(origdstpos);
            }
        }
    }
}
