/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.javafx.sg.prism;

/**
 */
public interface MediaFrameTracker {
    public void incrementDecodedFrameCount(int count);
    public void incrementRenderedFrameCount(int count);
}
