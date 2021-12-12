/*
 * Copyright (c) 2004, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;

public final class PrinterGraphicsConfig extends GraphicsConfiguration {

    static ColorModel theModel;

    private final GraphicsDevice device;
    private final int pageWidth;
    private final int pageHeight;
    private final AffineTransform deviceTransform;

    public PrinterGraphicsConfig(String printerID, AffineTransform deviceTx,
                                 int pageWid, int pageHgt) {
        this.pageWidth = pageWid;
        this.pageHeight = pageHgt;
        this.deviceTransform = deviceTx;
        this.device = new PrinterGraphicsDevice(this, printerID);
    }

    /**
     * Return the graphics device associated with this configuration.
     */
    @Override
    public GraphicsDevice getDevice() {
        return device;
    }

    /**
     * Returns the color model associated with this configuration.
     */
    @Override
    public ColorModel getColorModel() {
        if (theModel == null) {
            BufferedImage bufImg =
                new BufferedImage(1,1, BufferedImage.TYPE_3BYTE_BGR);
            theModel = bufImg.getColorModel();
        }

        return theModel;
    }

    /**
     * Returns the color model associated with this configuration that
     * supports the specified transparency.
     */
    @Override
    public ColorModel getColorModel(int transparency) {
        switch (transparency) {
        case Transparency.OPAQUE:
            return getColorModel();
        case Transparency.BITMASK:
            return new DirectColorModel(25, 0xff0000, 0xff00, 0xff, 0x1000000);
        case Transparency.TRANSLUCENT:
            return ColorModel.getRGBdefault();
        default:
            return null;
        }
    }

    /**
     * Returns the default Transform for this configuration.  This
     * Transform is typically the Identity transform for most normal
     * screens.  Device coordinates for screen and printer devices will
     * have the origin in the upper left-hand corner of the target region of
     * the device, with X coordinates
     * increasing to the right and Y coordinates increasing downwards.
     * For image buffers, this Transform will be the Identity transform.
     */
    @Override
    public AffineTransform getDefaultTransform() {
        return new AffineTransform(deviceTransform);
    }

    /**
     *
     * Returns a Transform that can be composed with the default Transform
     * of a Graphics2D so that 72 units in user space will equal 1 inch
     * in device space.
     * Given a Graphics2D, g, one can reset the transformation to create
     * such a mapping by using the following pseudocode:
     * <pre>
     *      GraphicsConfiguration gc = g.getGraphicsConfiguration();
     *
     *      g.setTransform(gc.getDefaultTransform());
     *      g.transform(gc.getNormalizingTransform());
     * </pre>
     * Note that sometimes this Transform will be identity (e.g. for
     * printers or metafile output) and that this Transform is only
     * as accurate as the information supplied by the underlying system.
     * For image buffers, this Transform will be the Identity transform,
     * since there is no valid distance measurement.
     */
    @Override
    public AffineTransform getNormalizingTransform() {
        return new AffineTransform();
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(0, 0, pageWidth, pageHeight);
    }
}
