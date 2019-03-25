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

package jdk.tools.jaotc.binformat.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import jdk.tools.jaotc.binformat.elf.Elf.Elf64_Ehdr;
import jdk.tools.jaotc.binformat.elf.ElfTargetInfo;

final class ElfByteBuffer {

    static ByteBuffer allocate(int size) {
        ByteBuffer buf = ByteBuffer.allocate(size);
        if (ElfTargetInfo.getElfEndian() == Elf64_Ehdr.ELFDATA2LSB) {
            buf.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            buf.order(ByteOrder.BIG_ENDIAN);
        }
        return (buf);
    }

}
