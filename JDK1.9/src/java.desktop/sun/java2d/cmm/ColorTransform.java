/*
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.cmm;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public interface ColorTransform {
    public int Any = -1;/* any rendering type, whichever is
                           available */
                        /* search order is icPerceptual,
                           icRelativeColorimetric, icSaturation */

    /* Transform types */
    public int In = 1;
    public int Out = 2;
    public int Gamut = 3;
    public int Simulation = 4;

    public int getNumInComponents();
    public int getNumOutComponents();
    public void colorConvert(BufferedImage src, BufferedImage dst);
    public void colorConvert(Raster src, WritableRaster dst,
                             float[] srcMinVal, float[]srcMaxVal,
                             float[] dstMinVal, float[]dstMaxVal);
    public void colorConvert(Raster src, WritableRaster dst);
    public short[] colorConvert(short[] src, short[] dest);
    public byte[] colorConvert (byte[] src, byte[] dest);
}
