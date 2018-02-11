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

package com.sun.tools.internal.xjc.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Formats error messages.
 */
class Messages
{
    /** Loads a string resource and formats it with specified arguments. */
    static String format( String property, Object... args ) {
        String text = ResourceBundle.getBundle(Messages.class.getPackage().getName() +".MessageBundle").getString(property);
        return MessageFormat.format(text,args);
    }


    static final String ERR_CLASSNAME_COLLISION =
        "CodeModelClassFactory.ClassNameCollision";

    static final String ERR_CLASSNAME_COLLISION_SOURCE =
        "CodeModelClassFactory.ClassNameCollision.Source";

    static final String ERR_INVALID_CLASSNAME =
        "ERR_INVALID_CLASSNAME";

    static final String ERR_CASE_SENSITIVITY_COLLISION = // 2 args
        "CodeModelClassFactory.CaseSensitivityCollision";

    static final String ERR_CHAMELEON_SCHEMA_GONE_WILD = // no argts
        "ERR_CHAMELEON_SCHEMA_GONE_WILD";
}
