/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.jxc.api;

import com.sun.tools.internal.xjc.api.JavaCompiler;
import com.sun.tools.internal.jxc.api.impl.j2s.JavaCompilerImpl;

/**
 * User: Iaroslav Savytskyi
 * Date: 25/05/12
 */
public class JXC {
    /**
     * Gets a fresh {@link JavaCompiler}.
     *
     * @return
     *      always return non-null object.
     */
    public static JavaCompiler createJavaCompiler() {
        return new JavaCompilerImpl();
    }
}
