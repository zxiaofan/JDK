/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.image.AlphaType;
import com.sun.javafx.image.BytePixelAccessor;
import com.sun.javafx.image.BytePixelGetter;
import com.sun.javafx.image.BytePixelSetter;
import com.sun.javafx.image.ByteToBytePixelConverter;
import com.sun.javafx.image.PixelUtils;
import java.nio.ByteBuffer;

public class ByteGrayAlpha {
    public static final BytePixelGetter     getter = Accessor.nonpremul;
    public static final BytePixelSetter     setter = Accessor.nonpremul;
    public static final BytePixelAccessor accessor = Accessor.nonpremul;

    public static ByteToBytePixelConverter ToByteGrayAlphaPreConverter() {
        return ToByteGrayAlphaPreConv.instance;
    }

    public static ByteToBytePixelConverter ToByteBgraConverter() {
        return ToByteBgraSameConv.nonpremul;
    }

    static class Accessor implements BytePixelAccessor {
        static final BytePixelAccessor nonpremul = new Accessor(false);
        static final BytePixelAccessor    premul = new Accessor(true);

        private boolean isPremult;
        private Accessor(boolean isPremult) {
            this.isPremult = isPremult;
        }

        @Override
        public AlphaType getAlphaType() {
            return isPremult ? AlphaType.PREMULTIPLIED : AlphaType.NONPREMULTIPLIED;
        }

        @Override
        public int getNumElements() {
            return 2;
        }

        @Override
        public int getArgb(byte arr[], int offset) {
            int g = arr[offset    ] & 0xff;
            int a = arr[offset + 1] & 0xff;
            if (isPremult) g = PixelUtils.PreToNonPre(g, a);
            return ((a << 24) | (g << 16) | (g << 8) | g);
        }

        @Override
        public int getArgbPre(byte arr[], int offset) {
            int g = arr[offset    ] & 0xff;
            int a = arr[offset + 1] & 0xff;
            if (!isPremult) g = PixelUtils.NonPretoPre(g, a);
            return ((a << 24) | (g << 16) | (g << 8) | g);
        }

        @Override
        public int getArgb(ByteBuffer buf, int offset) {
            int g = buf.get(offset    ) & 0xff;
            int a = buf.get(offset + 1) & 0xff;
            if (isPremult) g = PixelUtils.PreToNonPre(g, a);
            return ((a << 24) | (g << 16) | (g << 8) | g);
        }

        @Override
        public int getArgbPre(ByteBuffer buf, int offset) {
            int g = buf.get(offset    ) & 0xff;
            int a = buf.get(offset + 1) & 0xff;
            if (!isPremult) g = PixelUtils.NonPretoPre(g, a);
            return ((a << 24) | (g << 16) | (g << 8) | g);
        }

        @Override
        public void setArgb(byte arr[], int offset, int argb) {
            int g = PixelUtils.RgbToGray(argb);
            int a = (argb >>> 24);
            if (isPremult) g = PixelUtils.NonPretoPre(g, a);
            arr[offset    ] = (byte) g;
            arr[offset + 1] = (byte) a;
        }

        @Override
        public void setArgbPre(byte arr[], int offset, int argbpre) {
            int g = PixelUtils.RgbToGray(argbpre);
            int a = (argbpre >>> 24);
            if (!isPremult) g = PixelUtils.PreToNonPre(g, a);
            arr[offset    ] = (byte) g;
            arr[offset + 1] = (byte) a;
        }

        @Override
        public void setArgb(ByteBuffer buf, int offset, int argb) {
            int g = PixelUtils.RgbToGray(argb);
            int a = (argb >>> 24);
            if (isPremult) g = PixelUtils.NonPretoPre(g, a);
            buf.put(offset    , (byte) g);
            buf.put(offset + 1, (byte) a);
        }

        @Override
        public void setArgbPre(ByteBuffer buf, int offset, int argbpre) {
            int g = PixelUtils.RgbToGray(argbpre);
            int a = (argbpre >>> 24);
            if (!isPremult) g = PixelUtils.PreToNonPre(g, a);
            buf.put(offset    , (byte) g);
            buf.put(offset + 1, (byte) a);
        }
    }

    static class ToByteGrayAlphaPreConv extends BaseByteToByteConverter {
        static final ByteToBytePixelConverter instance =
            new ToByteGrayAlphaPreConv();

        private ToByteGrayAlphaPreConv() {
            super(ByteGrayAlpha.getter, ByteGrayAlphaPre.setter);
        }

        @Override
        void doConvert(byte srcarr[], int srcoff, int srcscanbytes,
                       byte dstarr[], int dstoff, int dstscanbytes,
                       int w, int h)
        {
            srcscanbytes -= w * 2;
            dstscanbytes -= w * 2;
            while (--h >= 0) {
                for (int x = 0; x < w; x++) {
                    int g = srcarr[srcoff++] & 0xff;
                    int a = srcarr[srcoff++];
                    if (a != -1) {
                        if (a == 0) {
                            g = 0;
                        } else {
                            g = (g * (a & 0xff) + 0x7f) / 0xff;
                        }
                    }
                    dstarr[dstoff++] = (byte) g;
                    dstarr[dstoff++] = (byte) a;
                }
                srcoff += srcscanbytes;
                dstoff += dstscanbytes;
            }
        }

        @Override
        void doConvert(ByteBuffer srcbuf, int srcoff, int srcscanbytes,
                       ByteBuffer dstbuf, int dstoff, int dstscanbytes,
                       int w, int h)
        {
            srcscanbytes -= w * 2;
            dstscanbytes -= w * 2;
            while (--h >= 0) {
                for (int x = 0; x < w; x++) {
                    int g = srcbuf.get(srcoff++) & 0xff;
                    int a = srcbuf.get(srcoff++);
                    if (a != -1) {
                        if (a == 0) {
                            g = 0;
                        } else {
                            g = (g * (a & 0xff) + 0x7f) / 0xff;
                        }
                    }
                    dstbuf.put(dstoff++, (byte) g);
                    dstbuf.put(dstoff++, (byte) a);
                }
                srcoff += srcscanbytes;
                dstoff += dstscanbytes;
            }
        }
    }

    static class ToByteBgraSameConv extends BaseByteToByteConverter {
        static final ByteToBytePixelConverter nonpremul =
            new ToByteBgraSameConv(false);
        static final ByteToBytePixelConverter    premul =
            new ToByteBgraSameConv(true);

        private ToByteBgraSameConv(boolean isPremult) {
            super(isPremult ? ByteGrayAlphaPre.getter : ByteGrayAlpha.getter,
                  isPremult ?      ByteBgraPre.setter :      ByteBgra.setter);
        }

        @Override
        void doConvert(byte srcarr[], int srcoff, int srcscanbytes,
                       byte dstarr[], int dstoff, int dstscanbytes,
                       int w, int h)
        {
            srcscanbytes -= w * 2;
            dstscanbytes -= w * 4;
            while (--h >= 0) {
                for (int x = 0; x < w; x++) {
                    byte g = srcarr[srcoff++];
                    byte a = srcarr[srcoff++];
                    dstarr[dstoff++] = g;
                    dstarr[dstoff++] = g;
                    dstarr[dstoff++] = g;
                    dstarr[dstoff++] = a;
                }
                srcoff += srcscanbytes;
                dstoff += dstscanbytes;
            }
        }

        @Override
        void doConvert(ByteBuffer srcbuf, int srcoff, int srcscanbytes,
                       ByteBuffer dstbuf, int dstoff, int dstscanbytes,
                       int w, int h)
        {
            srcscanbytes -= w * 2;
            dstscanbytes -= w * 4;
            while (--h >= 0) {
                for (int x = 0; x < w; x++) {
                    byte g = srcbuf.get(srcoff++);
                    byte a = srcbuf.get(srcoff++);
                    dstbuf.put(dstoff++, g);
                    dstbuf.put(dstoff++, g);
                    dstbuf.put(dstoff++, g);
                    dstbuf.put(dstoff++, a);
                }
                srcoff += srcscanbytes;
                dstoff += dstscanbytes;
            }
        }
    }
}
