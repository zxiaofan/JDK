/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism;

import com.sun.glass.ui.Screen;

public interface RenderTarget extends Surface {
    public Screen getAssociatedScreen();
    public Graphics createGraphics();
    public boolean isOpaque();
    public void setOpaque(boolean opaque);
    public boolean isMSAA();
}
