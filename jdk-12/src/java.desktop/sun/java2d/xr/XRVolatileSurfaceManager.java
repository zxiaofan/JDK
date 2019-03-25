/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.xr;

import java.awt.GraphicsConfiguration;
import java.awt.ImageCapabilities;
import java.awt.image.ColorModel;
import sun.awt.image.SunVolatileImage;
import sun.awt.image.VolatileSurfaceManager;
import sun.java2d.SurfaceData;

/**
 * XRender platform implementation of the VolatileSurfaceManager class.
 */
public class XRVolatileSurfaceManager extends VolatileSurfaceManager {

    public XRVolatileSurfaceManager(SunVolatileImage vImg, Object context) {
        super(vImg, context);
    }

    protected boolean isAccelerationEnabled() {
        return true;
    }

    /**
     * Create a pixmap-based SurfaceData object
     */
    protected SurfaceData initAcceleratedSurface() {
        SurfaceData sData;

        try {
            XRGraphicsConfig gc = (XRGraphicsConfig) vImg.getGraphicsConfig();
            ColorModel cm = gc.getColorModel();
            long drawable = 0;
            if (context instanceof Long) {
                drawable = ((Long)context).longValue();
            }
            sData = XRSurfaceData.createData(gc,
                                             vImg.getWidth(),
                                             vImg.getHeight(),
                                             cm, vImg, drawable,
                                             vImg.getTransparency(), false);
        } catch (NullPointerException ex) {
            sData = null;
        } catch (OutOfMemoryError er) {
            sData = null;
        }

        return sData;
    }

   /**
    * XRender should allow copies between different formats and depths.
    * TODO: verify that this assumption is correct.
    */
    protected boolean isConfigValid(GraphicsConfiguration gc) {
        return true;
    }

    /**
     * Need to override the default behavior because Pixmaps-based
     * images are accelerated but not volatile.
     */
    @Override
    public ImageCapabilities getCapabilities(GraphicsConfiguration gc) {
        if (isConfigValid(gc) && isAccelerationEnabled()) {
            return new ImageCapabilities(true);
        }
        return new ImageCapabilities(false);
    }
}
