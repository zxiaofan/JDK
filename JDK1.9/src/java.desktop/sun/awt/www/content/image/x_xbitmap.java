/*
 * Copyright (c) 1994, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.www.content.image;

import java.net.*;
import sun.awt.image.*;
import java.awt.Image;
import java.awt.Toolkit;

public class x_xbitmap extends ContentHandler {
    public Object getContent(URLConnection urlc) throws java.io.IOException {
        return new URLImageSource(urlc);
    }

    @SuppressWarnings("rawtypes")
    public Object getContent(URLConnection urlc, Class[] classes) throws java.io.IOException {
        Class<?>[] cls = classes;
        for (int i = 0; i < cls.length; i++) {
            if (cls[i].isAssignableFrom(URLImageSource.class)) {
                return new URLImageSource(urlc);
            }
            if (cls[i].isAssignableFrom(Image.class)) {
                Toolkit tk = Toolkit.getDefaultToolkit();
                return tk.createImage(new URLImageSource(urlc));
            }
        }
        return null;
    }
}
