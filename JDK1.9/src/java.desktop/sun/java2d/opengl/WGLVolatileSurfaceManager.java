/*
 * Copyright (c) 2004, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.opengl;

import java.awt.BufferCapabilities;
import static java.awt.BufferCapabilities.FlipContents.*;
import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.Transparency;
import java.awt.image.ColorModel;

import sun.awt.AWTAccessor;
import sun.awt.AWTAccessor.ComponentAccessor;
import sun.awt.image.SunVolatileImage;
import sun.awt.image.VolatileSurfaceManager;
import sun.awt.windows.WComponentPeer;
import sun.java2d.SurfaceData;
import static sun.java2d.opengl.OGLContext.OGLContextCaps.*;
import static sun.java2d.pipe.hw.AccelSurface.*;
import sun.java2d.pipe.hw.ExtendedBufferCapabilities;
import static sun.java2d.pipe.hw.ExtendedBufferCapabilities.VSyncType.*;

public class WGLVolatileSurfaceManager extends VolatileSurfaceManager {

    private final boolean accelerationEnabled;

    public WGLVolatileSurfaceManager(SunVolatileImage vImg, Object context) {
        super(vImg, context);

        /*
         * We will attempt to accelerate this image only under the
         * following conditions:
         *   - the image is not bitmask AND the GraphicsConfig supports the FBO
         *     extension
         */
        int transparency = vImg.getTransparency();
        WGLGraphicsConfig gc = (WGLGraphicsConfig) vImg.getGraphicsConfig();
        accelerationEnabled = gc.isCapPresent(CAPS_EXT_FBOBJECT)
                && transparency != Transparency.BITMASK;
    }

    protected boolean isAccelerationEnabled() {
        return accelerationEnabled;
    }

    /**
     * Create a FBO-based SurfaceData object (or init the backbuffer
     * of an existing window if this is a double buffered GraphicsConfig).
     */
    protected SurfaceData initAcceleratedSurface() {
        SurfaceData sData;
        Component comp = vImg.getComponent();
        final ComponentAccessor acc = AWTAccessor.getComponentAccessor();
        WComponentPeer peer = (comp != null) ? acc.getPeer(comp) : null;

        try {
            boolean createVSynced = false;
            boolean forceback = false;
            if (context instanceof Boolean) {
                forceback = ((Boolean)context).booleanValue();
                if (forceback) {
                    BufferCapabilities caps = peer.getBackBufferCaps();
                    if (caps instanceof ExtendedBufferCapabilities) {
                        ExtendedBufferCapabilities ebc =
                            (ExtendedBufferCapabilities)caps;
                        if (ebc.getVSync() == VSYNC_ON &&
                            ebc.getFlipContents() == COPIED)
                        {
                            createVSynced = true;
                            forceback = false;
                        }
                    }
                }
            }

            if (forceback) {
                // peer must be non-null in this case
                sData = WGLSurfaceData.createData(peer, vImg, FLIP_BACKBUFFER);
            } else {
                WGLGraphicsConfig gc =
                    (WGLGraphicsConfig)vImg.getGraphicsConfig();
                ColorModel cm = gc.getColorModel(vImg.getTransparency());
                int type = vImg.getForcedAccelSurfaceType();
                // if acceleration type is forced (type != UNDEFINED) then
                // use the forced type, otherwise choose FBOBJECT
                if (type == OGLSurfaceData.UNDEFINED) {
                    type = OGLSurfaceData.FBOBJECT;
                }
                if (createVSynced) {
                    sData = WGLSurfaceData.createData(peer, vImg, type);
                } else {
                    sData = WGLSurfaceData.createData(gc,
                                                      vImg.getWidth(),
                                                      vImg.getHeight(),
                                                      cm, vImg, type);
                }
            }
        } catch (NullPointerException ex) {
            sData = null;
        } catch (OutOfMemoryError er) {
            sData = null;
        }

        return sData;
    }

    @Override
    protected boolean isConfigValid(GraphicsConfiguration gc) {
        return ((gc == null) ||
                ((gc instanceof WGLGraphicsConfig) &&
                 (gc == vImg.getGraphicsConfig())));
    }

    @Override
    public void initContents() {
        if (vImg.getForcedAccelSurfaceType() != OGLSurfaceData.TEXTURE) {
            super.initContents();
        }
    }
}
