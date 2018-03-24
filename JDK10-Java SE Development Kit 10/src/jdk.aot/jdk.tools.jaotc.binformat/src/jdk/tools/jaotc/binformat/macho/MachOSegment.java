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

import jdk.tools.jaotc.binformat.macho.MachO.segment_command_64;
import jdk.tools.jaotc.binformat.macho.MachOByteBuffer;

public class MachOSegment {
    ByteBuffer segment;

    public MachOSegment(int size, int fileoff, int filesize, int nsects) {
        segment = MachOByteBuffer.allocate(segment_command_64.totalsize);

        segment.putInt(segment_command_64.cmd.off, segment_command_64.LC_SEGMENT_64);
        segment.putInt(segment_command_64.cmdsize.off, size);
        segment.putInt(segment_command_64.maxprot.off, 7);
        segment.putInt(segment_command_64.initprot.off, 7);
        segment.putInt(segment_command_64.nsects.off, nsects);
        segment.putInt(segment_command_64.flags.off, 0);
        segment.putLong(segment_command_64.vmaddr.off, 0);
        segment.putLong(segment_command_64.vmsize.off, filesize);
        segment.putLong(segment_command_64.fileoff.off, fileoff);
        segment.putLong(segment_command_64.filesize.off, filesize);
    }

    public byte[] getArray() {
        return segment.array();
    }
}
