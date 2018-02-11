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

package com.sun.tools.internal.xjc.reader.xmlschema.bindinfo;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Formats error messages.
 */
enum Messages
{
    ERR_CANNOT_BE_BOUND_TO_SIMPLETYPE,
    ERR_UNDEFINED_SIMPLE_TYPE,
    ERR_ILLEGAL_FIXEDATTR
    ;

    /** Loads a string resource and formats it with specified arguments. */
    String format( Object... args ) {
        String text = ResourceBundle.getBundle(Messages.class.getPackage().getName() + ".MessageBundle").getString(name());
        return MessageFormat.format(text,args);
    }
}
