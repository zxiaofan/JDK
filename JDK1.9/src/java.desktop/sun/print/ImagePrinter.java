/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.net.URL;
import java.io.InputStream;
import javax.imageio.ImageIO;

class ImagePrinter implements Printable {

    BufferedImage image;

    ImagePrinter(InputStream stream) {
        try {
            image = ImageIO.read(stream);
        } catch (Exception e) {
        }
    }

    ImagePrinter(URL url) {
        try {
            image = ImageIO.read(url);
        } catch (Exception e) {
        }
    }

    public int print(Graphics g, PageFormat pf, int index) {

        if (index > 0 || image == null) {
            return Printable.NO_SUCH_PAGE;
        }

        ((Graphics2D)g).translate(pf.getImageableX(), pf.getImageableY());
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        int iw = (int)pf.getImageableWidth();
        int ih = (int)pf.getImageableHeight();

        // ensure image will fit
        int dw = w;
        int dh = h;
        if (dw > iw) {
            dh = (int)(dh * ( (float) iw / (float) dw)) ;
            dw = iw;
        }
        if (dh > ih) {
            dw = (int)(dw * ( (float) ih / (float) dh)) ;
            dh = ih;
        }
        // centre on page
        int dx = (iw - dw) / 2;
        int dy = (ih - dh) / 2;

        g.drawImage(image, dx, dy, dx+dw, dy+dh, 0, 0, w, h, null);
        return Printable.PAGE_EXISTS;
    }
}
