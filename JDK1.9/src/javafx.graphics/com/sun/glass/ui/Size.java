/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui;

import java.security.AccessController;
import java.security.PrivilegedAction;

public final class Size {
    public int width;
    public int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Size() {
        this(0, 0);
    }

    @Override public String toString() {
        return "Size(" + width + ", " + height + ")";
    }
}

