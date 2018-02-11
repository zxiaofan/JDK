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

/**
 * Represents a pointer to some location in the data section that should be {@link DataPatch
 * patched} into the code.
 */
public final class DataSectionReference extends Reference {

    private boolean initialized;
    private int offset;

    public DataSectionReference() {
        // will be set after the data section layout is fixed
        offset = 0xDEADDEAD;
    }

    public int getOffset() {
        assert initialized;

        return offset;
    }

    public void setOffset(int offset) {
        assert !initialized;
        initialized = true;

        this.offset = offset;
    }

    @Override
    public int hashCode() {
        return offset;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataSectionReference) {
            DataSectionReference that = (DataSectionReference) obj;
            return this.offset == that.offset;
        }
        return false;
    }

    @Override
    public String toString() {
        if (initialized) {
            return String.format("DataSection[0x%x]", offset);
        } else {
            return "DataSection[?]";
        }
    }
}
