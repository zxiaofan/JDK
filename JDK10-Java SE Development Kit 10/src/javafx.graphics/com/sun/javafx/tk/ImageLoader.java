/*
 * Copyright (c) 2008, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk;


public interface ImageLoader {
    public Exception getException();
    public int getFrameCount();
    public PlatformImage getFrame(int index);
    public int getFrameDelay(int index);
    public int getLoopCount();
    public double getWidth();
    public double getHeight();
}
