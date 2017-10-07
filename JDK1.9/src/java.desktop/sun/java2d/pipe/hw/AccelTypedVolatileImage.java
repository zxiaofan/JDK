/*
 * Copyright (c) 2007, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.pipe.hw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import sun.awt.image.SunVolatileImage;
import static sun.java2d.pipe.hw.AccelSurface.*;

/**
 * This is an image with forced type of the accelerated surface.
 */
public class AccelTypedVolatileImage extends SunVolatileImage {

    /**
     * Creates a volatile image with specified type of accelerated surface.
     *
     * @param graphicsConfig a GraphicsConfiguration for which this image should
     *        be created.
     * @param width width
     * @param height width
     * @param transparency type of {@link java.awt.Transparency transparency}
     *        requested for the image
     * @param accType type of the desired accelerated surface as defined in
     *        AccelSurface interface
     * @see sun.java2d.pipe.hw.AccelSurface
     */
    public AccelTypedVolatileImage(GraphicsConfiguration graphicsConfig,
                                   int width, int height, int transparency,
                                   int accType)
    {
        super(null, graphicsConfig, width, height, null, transparency,
              null, accType);
    }

    /**
     * {@inheritDoc}
     *
     * This method will throw {@code UnsupportedOperationException} if it this
     * image's destination surface can not be rendered to.
     */
    @Override
    public Graphics2D createGraphics() {
        if (getForcedAccelSurfaceType() == TEXTURE) {
            throw new UnsupportedOperationException("Can't render " +
                                                    "to a non-RT Texture");
        }
        return super.createGraphics();
    }
}
