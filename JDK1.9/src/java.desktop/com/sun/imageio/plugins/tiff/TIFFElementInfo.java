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

import javax.imageio.metadata.IIOMetadataFormat;

class TIFFElementInfo {
    String[] childNames;
    String[] attributeNames;
    int childPolicy;

    int minChildren = 0;
    int maxChildren = Integer.MAX_VALUE;

    int objectValueType = IIOMetadataFormat.VALUE_NONE;
    Class<?> objectClass = null;
    Object objectDefaultValue = null;
    Object[] objectEnumerations = null;
    Comparable<Object> objectMinValue = null;
    Comparable<Object> objectMaxValue = null;
    int objectArrayMinLength = 0;
    int objectArrayMaxLength = 0;

    public TIFFElementInfo(String[] childNames,
                           String[] attributeNames,
                           int childPolicy) {
        this.childNames = childNames;
        this.attributeNames = attributeNames;
        this.childPolicy = childPolicy;
    }
}
