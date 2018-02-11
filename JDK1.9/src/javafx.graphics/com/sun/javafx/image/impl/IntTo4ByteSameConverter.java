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

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import com.sun.javafx.image.BytePixelSetter;
import com.sun.javafx.image.IntPixelGetter;

class IntTo4ByteSameConverter extends BaseIntToByteConverter {

    IntTo4ByteSameConverter(IntPixelGetter getter, BytePixelSetter setter) {
        super(getter, setter);
    }

    @Override
    void doConvert(int  srcarr[], int srcoff, int srcscanints,
                   byte dstarr[], int dstoff, int dstscanbytes,
                   int w, int h)
    {
        srcscanints -= w;
        dstscanbytes -= w * 4;
        while (--h >= 0) {
            for (int x = 0; x < w; x++) {
                int pixel = srcarr[srcoff++];
                dstarr[dstoff++] = (byte) (pixel      );
                dstarr[dstoff++] = (byte) (pixel >>  8);
                dstarr[dstoff++] = (byte) (pixel >> 16);
                dstarr[dstoff++] = (byte) (pixel >> 24);
            }
            srcoff += srcscanints;
            dstoff += dstscanbytes;
        }
    }

    @Override
    void doConvert(IntBuffer srcbuf, int srcoff, int srcscanints,
                   ByteBuffer dstbuf, int dstoff, int dstscanbytes,
                   int w, int h)
    {
        dstscanbytes -= w * 4;
        while (--h >= 0) {
            for (int x = 0; x < w; x++) {
                int pixel = srcbuf.get(srcoff + x);
                dstbuf.put(dstoff    , (byte) (pixel      ));
                dstbuf.put(dstoff + 1, (byte) (pixel >>  8));
                dstbuf.put(dstoff + 2, (byte) (pixel >> 16));
                dstbuf.put(dstoff + 3, (byte) (pixel >> 24));
                dstoff += 4;
            }
            srcoff += srcscanints;
            dstoff += dstscanbytes;
        }
    }
}
