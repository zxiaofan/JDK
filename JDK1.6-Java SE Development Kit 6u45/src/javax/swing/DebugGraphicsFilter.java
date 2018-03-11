/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.swing;

import java.awt.*;
import java.awt.image.*;

/** Color filter for DebugGraphics, used for images only.
  * 
  * @version %I% %G%
  * @author Dave Karlton
  */
class DebugGraphicsFilter extends RGBImageFilter {
    Color color;

    DebugGraphicsFilter(Color c) {
        canFilterIndexColorModel = true;
        color = c;
    }

    public int filterRGB(int x, int y, int rgb) {
        return color.getRGB() | (rgb & 0xFF000000);
    }
}
