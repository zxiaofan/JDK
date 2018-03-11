/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt;

import java.awt.image.ColorModel;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * This <code>Paint</code> interface defines how color patterns
 * can be generated for {@link Graphics2D} operations.  A class
 * implementing the <code>Paint</code> interface is added to the
 * <code>Graphics2D</code> context in order to define the color 
 * pattern used by the <code>draw</code> and <code>fill</code> methods.
 * <p>
 * Instances of classes implementing <code>Paint</code> must be 
 * read-only because the <code>Graphics2D</code> does not clone
 * these objects when they are set as an attribute with the 
 * <code>setPaint</code> method or when the <code>Graphics2D</code>
 * object is itself cloned.
 * @see PaintContext
 * @see Color
 * @see GradientPaint
 * @see TexturePaint
 * @see Graphics2D#setPaint
 * @version %I%, %G%
 */

public interface Paint extends Transparency {
    /**
     * Creates and returns a {@link PaintContext} used to 
     * generate the color pattern.
     * Since the ColorModel argument to createContext is only a
     * hint, implementations of Paint should accept a null argument
     * for ColorModel.  Note that if the application does not
     * prefer a specific ColorModel, the null ColorModel argument
     * will give the Paint implementation full leeway in using the
     * most efficient ColorModel it prefers for its raster processing.
     * <p>
     * Since the API documentation was not specific about this in
     * releases before 1.4, there may be implementations of 
     * <code>Paint</code> that do not accept a null 
     * <code>ColorModel</code> argument.
     * If a developer is writing code which passes a null 
     * <code>ColorModel</code> argument to the 
     * <code>createContext</code> method of <code>Paint</code> 
     * objects from arbitrary sources it would be wise to code defensively
     * by manufacturing a non-null <code>ColorModel</code> for those
     * objects which throw a <code>NullPointerException</code>.
     * @param cm the {@link ColorModel} that receives the
     * <code>Paint</code> data. This is used only as a hint.
     * @param deviceBounds the device space bounding box
     *                     of the graphics primitive being rendered
     * @param userBounds the user space bounding box 
     *                     of the graphics primitive being rendered
     * @param xform the {@link AffineTransform} from user
     *      space into device space
     * @param hints the hint that the context object uses to
     *              choose between rendering alternatives
     * @return the <code>PaintContext</code> for
     *              generating color patterns
     * @see PaintContext
     */
    public PaintContext createContext(ColorModel cm,
				      Rectangle deviceBounds,
				      Rectangle2D userBounds,
				      AffineTransform xform,
                                      RenderingHints hints);

}

