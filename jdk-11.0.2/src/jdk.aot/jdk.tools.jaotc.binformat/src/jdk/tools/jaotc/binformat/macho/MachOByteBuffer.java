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

package jdk.tools.jaotc.binformat.macho;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import jdk.tools.jaotc.binformat.macho.MachOTargetInfo;

final class MachOByteBuffer {

    static ByteBuffer allocate(int size) {
        ByteBuffer buf = ByteBuffer.allocate(size);
        if (MachOTargetInfo.getMachOEndian() == MachO.mach_header_64.CPU_SUBTYPE_LITTLE_ENDIAN) {
            buf.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            buf.order(ByteOrder.BIG_ENDIAN);
        }
        return (buf);
    }

}
