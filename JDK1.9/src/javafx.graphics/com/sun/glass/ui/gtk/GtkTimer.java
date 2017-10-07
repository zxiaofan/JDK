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
package com.sun.glass.ui.gtk;

import com.sun.glass.ui.Timer;

final class GtkTimer extends Timer{

    public GtkTimer(Runnable runnable) {
        super(runnable);
    }

    @Override protected long _start(Runnable runnable) {
        throw new RuntimeException("vsync timer not supported");
    }

    @Override
    protected native long _start(Runnable runnable, int period);

    @Override
    protected native void _stop(long timer);

}
