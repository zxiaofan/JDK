/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.ws.processor.generator;

import com.sun.tools.internal.ws.wscompile.Options;


/**
 *
 * @author WS Development Team
 */
public class GeneratorUtil {

    public static boolean classExists(
        Options options,
        String className) {
        try {
            // Takes care of inner classes.
            getLoadableClassName(className, options.getClassLoader());
            return true;
        } catch(ClassNotFoundException ce) {
            return false;
        }
    }

    private static String getLoadableClassName(
        String className,
        ClassLoader classLoader)
        throws ClassNotFoundException {

        try {
            Class.forName(className, true, classLoader);
        } catch (ClassNotFoundException e) {
            int idx = className.lastIndexOf(GeneratorConstants.DOTC.getValue());
            if (idx > -1) {
                String tmp = className.substring(0, idx) + GeneratorConstants.SIG_INNERCLASS.getValue();
                tmp += className.substring(idx + 1);
                return getLoadableClassName(tmp, classLoader);
            }
            throw e;
        }
        return className;
    }
}
