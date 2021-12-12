/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.util;

import jdk.internal.util.StaticProperty;

import java.io.File;

public class FilePaths {
    public static String cacerts() {
        return StaticProperty.javaHome() + File.separator + "lib"
                + File.separator + "security" + File.separator + "cacerts";
    }
}
