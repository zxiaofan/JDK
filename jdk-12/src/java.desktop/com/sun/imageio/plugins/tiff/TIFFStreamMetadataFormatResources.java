/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.imageio.plugins.tiff;

import java.util.ListResourceBundle;

public class TIFFStreamMetadataFormatResources extends ListResourceBundle {

    private static final Object[][] contents = {
        { "ByteOrder", "The stream byte order" },
        { "ByteOrder/value", "One of \"BIG_ENDIAN\" or \"LITTLE_ENDIAN\"" }
    };

    public TIFFStreamMetadataFormatResources() {
    }

    public Object[][] getContents() {
        return contents.clone();
    }
}
