/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.iio.jpeg;

import com.sun.javafx.iio.common.ImageDescriptor;

public class JPEGDescriptor extends ImageDescriptor {
    public static final int SOI = 0xD8;

    private static final String formatName = "JPEG";

    private static final String[] extensions = { "jpg", "jpeg" };

    // 0xD8 == SOI, start of image
    private static final Signature[] signatures = { new Signature((byte) 0xff, (byte) 0xD8) };

//    private static final String[] MIMETypes = { "image/jpeg" };

    private static ImageDescriptor theInstance = null;

    private JPEGDescriptor() {
        super(formatName, extensions, signatures);
    }

    public static synchronized ImageDescriptor getInstance() {
        if (theInstance == null) {
            theInstance = new JPEGDescriptor();
        }
        return theInstance;
    }
}
