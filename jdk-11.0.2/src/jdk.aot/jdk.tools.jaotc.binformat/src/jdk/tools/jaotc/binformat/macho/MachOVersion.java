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

import jdk.tools.jaotc.binformat.macho.MachO.version_min_command;
import jdk.tools.jaotc.binformat.macho.MachOByteBuffer;

final class MachOVersion {
    private final ByteBuffer version;

    MachOVersion() {
        version = MachOByteBuffer.allocate(version_min_command.totalsize);

        version.putInt(version_min_command.cmd.off, version_min_command.LC_VERSION_MIN_MACOSX);
        version.putInt(version_min_command.cmdsize.off, version_min_command.totalsize);
        version.putInt(version_min_command.version.off, (10 << 16) | (10 << 8)); /* MacOSX 10.10 */
        version.putInt(version_min_command.sdk.off, 0); /* N/A SDK */
    }

    byte[] getArray() {
        return version.array();
    }
}
