/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package jdk.tools.jaotc.binformat.pecoff;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class PECoffByteBuffer {

    static ByteBuffer allocate(int size) {
        ByteBuffer buf = ByteBuffer.allocate(size);
        // Only support Little Endian on Windows
        buf.order(ByteOrder.LITTLE_ENDIAN);
        return (buf);
    }

}
