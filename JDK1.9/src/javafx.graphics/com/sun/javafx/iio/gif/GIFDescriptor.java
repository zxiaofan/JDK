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

package com.sun.javafx.iio.gif;

import com.sun.javafx.iio.common.ImageDescriptor;

public class GIFDescriptor extends ImageDescriptor {
    private static final String formatName = "GIF";

    private static final String[] extensions = { "gif" };

    private static final Signature[] signatures = {
        new Signature(new byte[] { 'G', 'I', 'F', '8', '7', 'a' }),
        new Signature(new byte[] { 'G', 'I', 'F', '8', '9', 'a' })
    };

//    private static final String[] MIMETypes = { "image/gif" };

    private static ImageDescriptor theInstance = null;

    private GIFDescriptor() {
        super(formatName, extensions, signatures);
    }

    public static synchronized ImageDescriptor getInstance() {
        if (theInstance == null) {
            theInstance = new GIFDescriptor();
        }
        return theInstance;
    }
}
