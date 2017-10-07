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

package com.sun.pisces;

import java.nio.IntBuffer;

public final class JavaSurface extends AbstractSurface {

    private IntBuffer dataBuffer;

    private int[] dataInt;

    public JavaSurface(int[] dataInt, int dataType, int width, int height) {
        super(width, height);
        if (dataInt.length / width < height) {
            throw new IllegalArgumentException("width(=" + width + ") * height(="
                    + height + ") is greater than dataInt.length(=" + dataInt.length + ")");
        }
        this.dataInt = dataInt;
        this.dataBuffer = IntBuffer.wrap(this.dataInt);

        initialize(dataType, width, height);
    }

    public IntBuffer getDataIntBuffer() {
        return this.dataBuffer;
    }

    private native void initialize(int dataType, int width, int height);
}
