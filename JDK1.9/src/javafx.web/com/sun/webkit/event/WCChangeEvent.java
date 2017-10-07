/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.event;

public final class WCChangeEvent {
    private final Object source;

    public WCChangeEvent(Object source) {
        if (source == null) {
            throw new IllegalArgumentException("null source");
        }
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[source=" + source + "]";
    }
}
