/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.graphics;

import java.lang.annotation.Native;

public interface WCPathIterator {

    @Native public static final int SEG_MOVETO = 0;
    @Native public static final int SEG_LINETO = 1;
    @Native public static final int SEG_QUADTO = 2;
    @Native public static final int SEG_CUBICTO = 3;
    @Native public static final int SEG_CLOSE = 4;

    public int getWindingRule();

    public boolean isDone();

    public void next();

    public int currentSegment(double[] floats);
}
