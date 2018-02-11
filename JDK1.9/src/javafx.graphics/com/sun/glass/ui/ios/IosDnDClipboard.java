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

package com.sun.glass.ui.ios;

/*
 * Clipboard for Drag And Drop operations on iOS.
 */
final class IosDnDClipboard extends IosSystemClipboard {

    public IosDnDClipboard(String name) {
        super(name);
    }

    static IosDnDClipboard getInstance() {
        return (IosDnDClipboard)get(DND);
    }

    @Override public String toString() {
        return "iOS DnD Clipboard";
    }
}
