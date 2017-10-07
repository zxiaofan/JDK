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
package com.sun.glass.ui.mac;

final class MacDnDClipboard extends MacSystemClipboard {

    public MacDnDClipboard(String name) {
        super(name);
    }

    @Override public String toString() {
        return "Mac DnD Clipboard";
    }
}
