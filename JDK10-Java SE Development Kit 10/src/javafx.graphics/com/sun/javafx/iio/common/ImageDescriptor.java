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

package com.sun.javafx.iio.common;

import com.sun.javafx.iio.ImageFormatDescription;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImageDescriptor implements ImageFormatDescription {
    private final String formatName;
    private final List<String> extensions;
    private final List<Signature> signatures;
//    private String[] MIMETypes;

    public ImageDescriptor(String formatName, String[] extensions, Signature[] signatures) {
        this.formatName = formatName;
        this.extensions = Collections.unmodifiableList(
                                          Arrays.asList(extensions));
        this.signatures = Collections.unmodifiableList(
                                          Arrays.asList(signatures));
//        this.MIMETypes = MIMETypes;
    }

    public String getFormatName() {
        return formatName;
    }

    public List<String> getExtensions() {
        return extensions;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

//    public String[] getMIMETypes() {
//        return MIMETypes;
//    }
}
