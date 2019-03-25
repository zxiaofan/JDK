/*
 * Copyright (c) 2006, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Property editor for a java builtin "boolean" type.
 */

import java.beans.*;

public class BooleanEditor extends PropertyEditorSupport {


    public String getJavaInitializationString() {
        Object value = getValue();
        return (value != null)
                ? value.toString()
                : "null";
    }

    public String getAsText() {
        Object value = getValue();
        return (value instanceof Boolean)
             ? getValidName((Boolean) value)
             : null;
    }

    public void setAsText(String text) throws java.lang.IllegalArgumentException {
        if (text == null) {
            setValue(null);
        } else if (isValidName(true, text)) {
            setValue(Boolean.TRUE);
        } else if (isValidName(false, text)) {
            setValue(Boolean.FALSE);
        } else {
            throw new java.lang.IllegalArgumentException(text);
        }
    }

    public String[] getTags() {
        return new String[] {getValidName(true), getValidName(false)};
    }

    // the following method should be localized (4890258)

    private String getValidName(boolean value) {
        return value ? "True" : "False";
    }

    private boolean isValidName(boolean value, String name) {
        return getValidName(value).equalsIgnoreCase(name);
    }
}
