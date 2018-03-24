/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.ImageCapabilities;
import java.awt.image.BufferedImage;
import sun.java2d.SurfaceData;
import sun.java2d.loops.CompositeType;

/**
 * This SurfaceManager variant manages the default (software) surface of a
 * BufferedImage.
 * All rendering to the image will use the software surface as the destination.
 * This is one of the more minimalist implementations of SurfaceManager.
 */
public class BufImgSurfaceManager extends SurfaceManager {
    /**
     * A reference to the BufferedImage whose contents are being managed.
     */
    protected BufferedImage bImg;

    /**
     * The default (software) surface containing the contents of the
     * BufferedImage.
     */
    protected SurfaceData sdDefault;

    public BufImgSurfaceManager(BufferedImage bImg) {
        this.bImg = bImg;
        this.sdDefault = BufImgSurfaceData.createData(bImg);
    }

    public SurfaceData getPrimarySurfaceData() {
        return sdDefault;
    }

    /**
     * Called from platform-specific SurfaceData objects to attempt to
     * auto-restore the contents of an accelerated surface that has been lost.
     */
    public SurfaceData restoreContents() {
        return sdDefault;
    }
}
