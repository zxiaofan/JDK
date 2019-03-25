/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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

/**
 * SharedSecrets interface used for the access from java.text.Bidi
 */

package jdk.internal.access;

public interface JavaAWTFontAccess {

    // java.awt.font.TextAttribute constants
    public Object getTextAttributeConstant(String name);

    // java.awt.font.NumericShaper
    public void shape(Object shaper, char[] text, int start, int count);
}
