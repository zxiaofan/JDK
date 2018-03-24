/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

public abstract class WCImageFrame extends Ref {

    public abstract WCImage getFrame();

    /**
     * Returns frame size, array[0] represents width and array[1]
     * represents height.
     */
    public abstract int[] getSize();

    protected void destroyDecodedData() {
    }
}
