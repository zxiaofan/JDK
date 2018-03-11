/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt;

import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

/**
 * The <code>TexturePaint</code> class provides a way to fill a
 * {@link Shape} with a texture that is specified as
 * a {@link BufferedImage}. The size of the <code>BufferedImage</code>
 * object should be small because the <code>BufferedImage</code> data
 * is copied by the <code>TexturePaint</code> object.
 * At construction time, the texture is anchored to the upper
 * left corner of a {@link Rectangle2D} that is
 * specified in user space.  Texture is computed for
 * locations in the device space by conceptually replicating the   
 * specified <code>Rectangle2D</code> infinitely in all directions
 * in user space and mapping the <code>BufferedImage</code> to each
 * replicated <code>Rectangle2D</code>.
 * @see Paint
 * @see Graphics2D#setPaint
 * @version %I%, %G%
 */

public class TexturePaint implements Paint {

    BufferedImage bufImg;
    double tx;
    double ty;
    double sx;
    double sy;

    /**
     * Constructs a <code>TexturePaint</code> object.
     * @param txtr the <code>BufferedImage</code> object with the texture
     * used for painting
     * @param anchor the <code>Rectangle2D</code> in user space used to
     * anchor and replicate the texture
     */
    public TexturePaint(BufferedImage txtr,
			Rectangle2D anchor) {
        this.bufImg = txtr;
	this.tx = anchor.getX();
	this.ty = anchor.getY();
	this.sx = anchor.getWidth() / bufImg.getWidth();
	this.sy = anchor.getHeight() / bufImg.getHeight();
    }

    /**
     * Returns the <code>BufferedImage</code> texture used to 
     * fill the shapes.
     * @return a <code>BufferedImage</code>.
     */
    public BufferedImage getImage() {
	return bufImg;
    }

    /**
     * Returns a copy of the anchor rectangle which positions and
     * sizes the textured image.
     * @return the <code>Rectangle2D</code> used to anchor and
     * size this <code>TexturePaint</code>.
     */
    public Rectangle2D getAnchorRect() {
	return new Rectangle2D.Double(tx, ty,
				      sx * bufImg.getWidth(),
				      sy * bufImg.getHeight());
    }

    /**
     * Creates and returns a context used to generate the color pattern.
     * @param cm the {@link ColorModel} that receives the
     * <code>Paint</code> data. This is used only as a hint.
     * @param deviceBounds the device space bounding box of the graphics
     * primitive being rendered
     * @param userBounds the user space bounding box of the graphics
     * primitive being rendered
     * @param xform the {@link AffineTransform} from user space
     *          into device space
     * @param hints a {@link RenderingHints} object that can be used to
     *          specify how the pattern is ultimately rendered
     * @return the {@link PaintContext} used for generating color
     *          patterns.
     * @see PaintContext
     */
    public PaintContext createContext(ColorModel cm,
				      Rectangle deviceBounds,
				      Rectangle2D userBounds,
				      AffineTransform xform,
                                      RenderingHints hints) {
	if (xform == null) {
	    xform = new AffineTransform();
	} else {
	    xform = (AffineTransform) xform.clone();
	}
	xform.translate(tx, ty);
	xform.scale(sx, sy);

	return TexturePaintContext.getContext(bufImg, xform, hints,
					      deviceBounds);
    }

    /**
     * Returns the transparency mode for this <code>TexturePaint</code>.
     * @return the transparency mode for this <code>TexturePaint</code>
     * as an integer value. 
     * @see Transparency
     */
    public int getTransparency() {
        return (bufImg.getColorModel()).getTransparency();
    }

}

