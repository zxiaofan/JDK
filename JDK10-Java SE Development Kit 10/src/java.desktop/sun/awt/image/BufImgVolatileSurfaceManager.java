/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.image;

import sun.java2d.SurfaceData;

/**
 * This SurfaceManager variant manages an unaccelerated volatile surface.
 * This class is created in the event that someone requested a VolatileImage
 * to be created from a BufferedImageGraphicsConfig, which is not platform-
 * or hardware-based, thus the resulting surface and surface manager
 * are unaccelerated.  All we do in this class is implement the abstract
 * methods of VolatileSurfaceManager to return values that indicate that
 * we cannot accelerate surfaces through this SurfaceManager, thus the
 * parent class will handle things through the unaccelerated backup mechanism.
 */
public class BufImgVolatileSurfaceManager extends VolatileSurfaceManager {

    /**
     * This constructor simply defers to the superclass since all of the real
     * functionality of this class is implemented in VolatileSurfaceManager.
     */
    public BufImgVolatileSurfaceManager(SunVolatileImage vImg, Object context) {
        super(vImg, context);
    }

    /**
     * Returns false to indicate that this surface manager cannot accelerate
     * the image.
     */
    protected boolean isAccelerationEnabled() {
        return false;
    }

    /**
     * Returns null to indicate failure in creating the accelerated surface.
     * Note that this method should not ever be called since creation of
     * accelerated surfaces should be preceded by calls to the above
     * isAccelerationEnabled() method.  But we need to override this method
     * since it is abstract in our parent class.
     */
    protected SurfaceData initAcceleratedSurface() {
        return null;
    }
}
