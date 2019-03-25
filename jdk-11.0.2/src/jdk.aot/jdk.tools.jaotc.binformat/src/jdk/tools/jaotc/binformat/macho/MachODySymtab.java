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

import jdk.tools.jaotc.binformat.macho.MachO.dysymtab_command;
import jdk.tools.jaotc.binformat.macho.MachOByteBuffer;

final class MachODySymtab {
    private final ByteBuffer dysymtab;

    MachODySymtab(int nlocal, int nglobal, int nundef) {
        dysymtab = MachOByteBuffer.allocate(dysymtab_command.totalsize);

        dysymtab.putInt(dysymtab_command.cmd.off, dysymtab_command.LC_DYSYMTAB);
        dysymtab.putInt(dysymtab_command.cmdsize.off, dysymtab_command.totalsize);
        dysymtab.putInt(dysymtab_command.ilocalsym.off, 0);
        dysymtab.putInt(dysymtab_command.nlocalsym.off, nlocal);
        dysymtab.putInt(dysymtab_command.iextdefsym.off, nlocal);
        dysymtab.putInt(dysymtab_command.nextdefsym.off, nglobal);
        dysymtab.putInt(dysymtab_command.iundefsym.off, nlocal + nglobal);
        dysymtab.putInt(dysymtab_command.nundefsym.off, nundef);
    }

    byte[] getArray() {
        return dysymtab.array();
    }
}
