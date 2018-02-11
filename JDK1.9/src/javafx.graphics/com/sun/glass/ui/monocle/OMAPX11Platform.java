/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

class OMAPX11Platform extends OMAPPlatform {

    @Override
    protected NativeScreen createScreen() {
        return new X11Screen(false);
    }

    @Override
    public synchronized AcceleratedScreen getAcceleratedScreen(
            int[] attributes) throws GLException {
        if (accScreen == null) {
            accScreen = new X11AcceleratedScreen(attributes);
        }
        return accScreen;
    }

}
