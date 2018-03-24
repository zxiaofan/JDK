/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk.quantum;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.Pixels;
import com.sun.javafx.iio.ImageFormatDescription;
import com.sun.javafx.iio.ImageStorage;
import com.sun.javafx.image.impl.ByteRgb;
import com.sun.prism.Image;
import com.sun.prism.PixelFormat;

class PixelUtils {

    private PixelUtils() {
    }

    private static ImageFormatDescription[] supportedFormats =
                                ImageStorage.getSupportedDescriptions();

    protected static boolean supportedFormatType(String type) {
        for (ImageFormatDescription ifd: supportedFormats) {
            for (String ext: ifd.getExtensions()) {
                if (type.endsWith(ext)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Pixels imageToPixels(Image image) {
        PixelFormat.DataType pixelType = image.getDataType();
        Application app = Application.GetApplication();
        int nativeFormat = Pixels.getNativeFormat();
        Pixels pixels;

        if (pixelType == PixelFormat.DataType.BYTE) {
            ByteBuffer bytes = (ByteBuffer)image.getPixelBuffer();
            int w = image.getWidth();
            int h = image.getHeight();
            int scanBytes = image.getScanlineStride();

            if (image.getBytesPerPixelUnit() == 3) {
                switch (nativeFormat) {
                    case Pixels.Format.BYTE_ARGB:
                    {
                        byte newbytes[] = new byte[w * h * 4];
                        ByteRgb.ToByteArgbConverter().convert(bytes, 0, scanBytes,
                                                              newbytes, 0, w * 4,
                                                              w, h);
                        bytes = ByteBuffer.wrap(newbytes);
                        break;
                    }
                    case Pixels.Format.BYTE_BGRA_PRE:
                    {
                        byte newbytes[] = new byte[w * h * 4];
                        ByteRgb.ToByteBgraPreConverter().convert(bytes, 0, scanBytes,
                                                                 newbytes, 0, w * 4,
                                                                 w, h);
                        bytes = ByteBuffer.wrap(newbytes);
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("unhandled native format: " + nativeFormat);
                }
            } else if (image.getPixelFormat() != PixelFormat.BYTE_BGRA_PRE) {
                throw new IllegalArgumentException("non-RGB image format");
            }
            pixels = app.createPixels(image.getWidth(),
                                      image.getHeight(), bytes);
            return pixels;
        } else if (pixelType == PixelFormat.DataType.INT) {
            if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) {
                final String MSG = "INT_ARGB_PRE only supported for LITTLE_ENDIAN machines";
                throw new UnsupportedOperationException(MSG);
            }
            /*
             * Glass only returns BYTE_BGRA_PRE and our only INT PixelFormat
             * is INT_ARGB_PRE == BYTE_BGRA_PRE.  No conversion necessary.
             */
            IntBuffer ints = (IntBuffer)image.getPixelBuffer();
            pixels = app.createPixels(image.getWidth(),
                                      image.getHeight(), ints);
            return pixels;
        } else {
            throw new IllegalArgumentException("unhandled image type: " + pixelType);
        }
    }

    public static Image pixelsToImage(Pixels pix) {
        Buffer pixbuf = pix.getPixels();
        if (pix.getBytesPerComponent() == 1) {
            ByteBuffer buf = ByteBuffer.allocateDirect(pixbuf.capacity());
            buf.put((ByteBuffer)pixbuf);
            buf.rewind();
            return (Image.fromByteBgraPreData(buf, pix.getWidth(), pix.getHeight()));
        } else if (pix.getBytesPerComponent() == 4) {
            IntBuffer buf = IntBuffer.allocate(pixbuf.capacity());
            buf.put((IntBuffer)pixbuf);
            buf.rewind();
            return (Image.fromIntArgbPreData((IntBuffer)pixbuf,
                                             pix.getWidth(), pix.getHeight()));
        } else {
            throw new IllegalArgumentException("unhandled pixel buffer: " +
                                               pixbuf.getClass().getName());
        }
    }
}
