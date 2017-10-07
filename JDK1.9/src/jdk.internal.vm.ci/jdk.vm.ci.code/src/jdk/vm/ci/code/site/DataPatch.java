/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.code.site;

import java.util.Objects;

import jdk.vm.ci.meta.VMConstant;

/**
 * Represents a code site that references some data. The associated data can be either a
 * {@link DataSectionReference reference} to the data section, or it may be an inlined
 * {@link VMConstant} that needs to be patched.
 */
public final class DataPatch extends Site {

    public Reference reference;
    public Object note;

    public DataPatch(int pcOffset, Reference reference) {
        super(pcOffset);
        this.reference = reference;
        this.note = null;
    }

    public DataPatch(int pcOffset, Reference reference, Object note) {
        super(pcOffset);
        this.reference = reference;
        this.note = note;
    }

    @Override
    public String toString() {
        if (note != null) {
            return String.format("%d[<data patch referring to %s>, note: %s]", pcOffset, reference.toString(), note.toString());
        } else {
            return String.format("%d[<data patch referring to %s>]", pcOffset, reference.toString());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataPatch) {
            DataPatch that = (DataPatch) obj;
            if (this.pcOffset == that.pcOffset && Objects.equals(this.reference, that.reference) && Objects.equals(this.note, that.note)) {
                return true;
            }
        }
        return false;
    }
}
