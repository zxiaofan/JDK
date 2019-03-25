/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.pipe;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.geom.AffineTransform;
import sun.java2d.SunGraphics2D;

/**
 * This interface defines the set of calls that pipeline objects
 * can use to pass on responsibility for performing various
 * image copy commands.
 * There are 3 types of image copies handled by this class:
 *    - copyImage: These methods simply copy the pixels
 *      from the src to dest, either from (0, 0) (implicit)
 *      or from a given (sx, sy) location.
 *    - scaleImage: These methods copy from src to dest while
 *      scaling the source image.  The src and dest rectangles
 *      are used to specify the scale.
 *    - copyImageBg: These methods behave the same as the
 *      copyImage methods except they substitute the given
 *      background color for any transparent pixels.
 *    - scaleImageBg: These methods behave the same as the
 *      scaleImage methods except they substitute the given
 *      background color for any transparent pixels.
 *    - transformImage....
 */
public interface DrawImagePipe {

    public boolean copyImage(SunGraphics2D sg, Image img,
                             int x, int y,
                             Color bgColor,
                             ImageObserver observer);

    public boolean copyImage(SunGraphics2D sg, Image img,
                             int dx, int dy, int sx, int sy, int w, int h,
                             Color bgColor,
                             ImageObserver observer);

    public boolean scaleImage(SunGraphics2D sg, Image img, int x, int y,
                              int width, int height,
                              Color bgColor,
                              ImageObserver observer);

    public boolean scaleImage(SunGraphics2D sg, Image img,
                              int dx1, int dy1, int dx2, int dy2,
                              int sx1, int sy1, int sx2, int sy2,
                              Color bgColor,
                              ImageObserver observer);

    public boolean transformImage(SunGraphics2D sg, Image img,
                                  AffineTransform atfm,
                                  ImageObserver observer);

    public void transformImage(SunGraphics2D sg, BufferedImage img,
                               BufferedImageOp op, int x, int y);


}
