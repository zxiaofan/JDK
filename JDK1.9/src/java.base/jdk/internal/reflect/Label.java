/*
 * Copyright (c) 2001, 2011, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.reflect;

import java.util.List;
import java.util.ArrayList;

/** Allows forward references in bytecode streams emitted by
    ClassFileAssembler. Assumes that the start of the method body is
    the first byte in the assembler's buffer. May be used at more than
    one branch site. */

class Label {
    static class PatchInfo {
        PatchInfo(ClassFileAssembler asm,
                  short instrBCI,
                  short patchBCI,
                  int stackDepth)
        {
            this.asm = asm;
            this.instrBCI   = instrBCI;
            this.patchBCI   = patchBCI;
            this.stackDepth = stackDepth;
        }
        // This won't work for more than one assembler anyway, so this is
        // unnecessary
        final ClassFileAssembler asm;
        final short instrBCI;
        final short patchBCI;
        final int   stackDepth;
    }
    private final List<PatchInfo> patches = new ArrayList<>();

    public Label() {
    }

    void add(ClassFileAssembler asm,
             short instrBCI,
             short patchBCI,
             int stackDepth)
    {
        patches.add(new PatchInfo(asm, instrBCI, patchBCI, stackDepth));
    }

    public void bind() {
        for (PatchInfo patch : patches){
            short curBCI = patch.asm.getLength();
            short offset = (short) (curBCI - patch.instrBCI);
            patch.asm.emitShort(patch.patchBCI, offset);
            patch.asm.setStack(patch.stackDepth);
        }
    }
}
