/*
 * Copyright (c) 1998, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

import java.awt.image.ComponentColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.WritableRaster;
import java.awt.image.Raster;
import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
import java.awt.color.ColorSpace;
import java.awt.Transparency;

/**
 * This class creates a standard ComponentColorModel with the slight
 * difference that it creates its Raster objects with the components
 * in the reverse order from the base ComponentColorModel to match
 * the ordering on a Windows 24-bit display.
 */
public class Win32ColorModel24 extends ComponentColorModel {
    public Win32ColorModel24() {
        super(ColorSpace.getInstance(ColorSpace.CS_sRGB),
              new int[] {8, 8, 8}, false, false,
              Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
    }

    /**
     * Creates a WritableRaster with the specified width and height, that
     * has a data layout (SampleModel) compatible with this ColorModel.
     * @see WritableRaster
     * @see SampleModel
     */
    public WritableRaster createCompatibleWritableRaster (int w, int h) {
        int[] bOffs = {2, 1, 0};
        return Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,
                                              w, h, w*3, 3,
                                              bOffs, null);
    }

    /**
     * Creates a SampleModel with the specified width and height, that
     * has a data layout compatible with this ColorModel.
     * @see SampleModel
     */
    public SampleModel createCompatibleSampleModel(int w, int h) {
        int[] bOffs = {2, 1, 0};
        return new PixelInterleavedSampleModel(DataBuffer.TYPE_BYTE,
                                               w, h, 3, w*3, bOffs);
    }
}
