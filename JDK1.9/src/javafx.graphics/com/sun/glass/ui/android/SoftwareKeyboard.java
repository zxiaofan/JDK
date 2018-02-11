/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui.android;


public class SoftwareKeyboard {

    public static void show() {
        _show();
    }

    public static void hide() {
        _hide();
    }

    private static native void _show();

    private static native void _hide();
}
