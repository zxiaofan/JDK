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

package com.sun.tools.internal.xjc.generator.bean.field;


import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Message resources
 */
public enum Messages {
    DEFAULT_GETTER_JAVADOC,     // 1 arg
    DEFAULT_SETTER_JAVADOC,     // 1 arg
    ;

    private static final ResourceBundle rb = ResourceBundle.getBundle(Messages.class.getName().substring(0, Messages.class.getName().lastIndexOf('.'))+ ".MessageBundle");

    public String toString() {
        return format();
    }

    public String format( Object... args ) {
        return MessageFormat.format( rb.getString(name()), args );
    }
}
