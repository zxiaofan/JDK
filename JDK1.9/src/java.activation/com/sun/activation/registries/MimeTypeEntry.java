/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.activation.registries;

import java.lang.*;

public class MimeTypeEntry {
    private String type;
    private String extension;

    public MimeTypeEntry(String mime_type, String file_ext) {
        type = mime_type;
        extension = file_ext;
    }

    public String getMIMEType() {
        return type;
    }

    public String getFileExtension() {
        return extension;
    }

    public String toString() {
        return "MIMETypeEntry: " + type + ", " + extension;
    }
}
