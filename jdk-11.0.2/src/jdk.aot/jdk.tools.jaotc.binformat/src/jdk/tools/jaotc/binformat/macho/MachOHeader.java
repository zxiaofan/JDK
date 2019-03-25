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

import jdk.tools.jaotc.binformat.macho.MachO.mach_header_64;
import jdk.tools.jaotc.binformat.macho.MachOTargetInfo;
import jdk.tools.jaotc.binformat.macho.MachOByteBuffer;

final class MachOHeader {
    private final ByteBuffer header;

    MachOHeader() {
        header = MachOByteBuffer.allocate(mach_header_64.totalsize);

        header.putInt(mach_header_64.magic.off, mach_header_64.MH_MAGIC_64);
        header.putInt(mach_header_64.cputype.off, MachOTargetInfo.getMachOArch());
        header.putInt(mach_header_64.cpusubtype.off, MachOTargetInfo.getMachOSubArch());
        header.putInt(mach_header_64.flags.off, 0x2000);
        header.putInt(mach_header_64.filetype.off, mach_header_64.MH_OBJECT);
    }

    void setCmdSizes(int ncmds, int sizeofcmds) {
        header.putInt(mach_header_64.ncmds.off, ncmds);
        header.putInt(mach_header_64.sizeofcmds.off, sizeofcmds);
    }

    int getCmdSize() {
        return (header.getInt(mach_header_64.sizeofcmds.off));
    }

    byte[] getArray() {
        return header.array();
    }
}
