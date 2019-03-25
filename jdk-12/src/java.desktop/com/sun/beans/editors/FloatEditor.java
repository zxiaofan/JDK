/*
 * Copyright (c) 1996, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.beans.editors;

/**
 * Property editor for a java builtin "float" type.
 *
 */

import java.beans.*;

public class FloatEditor extends NumberEditor {

    public String getJavaInitializationString() {
        Object value = getValue();
        return (value != null)
                ? value + "F"
                : "null";
    }

    public void setAsText(String text) throws IllegalArgumentException {
        setValue((text == null) ? null : Float.valueOf(text));
    }

}
