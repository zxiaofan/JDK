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

package com.sun.tools.internal.xjc.reader.dtd.bindinfo;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Formats error messages.
 */
class Messages
{
    /** Loads a string resource and formats it with specified arguments. */
    static String format( String property, Object... args ) {
        String text = ResourceBundle.getBundle(Messages.class.getPackage().getName() + ".MessageBundle").getString(property);
        return MessageFormat.format(text,args);
    }


    static final String ERR_UNDEFINED_FIELD = // arg:1
        "BIConstructor.UndefinedField";

}
