/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.hotspot;

import static jdk.vm.ci.hotspot.UnsafeAccess.UNSAFE;

import jdk.internal.misc.Unsafe;
import jdk.vm.ci.code.InstalledCode;

/**
 * Implementation of {@link InstalledCode} for HotSpot.
 */
public abstract class HotSpotInstalledCode extends InstalledCode {

    /**
     * Total size of the code blob.
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "field is set by the native part") private int size;

    /**
     * Start address of the code.
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "field is set by the native part") private long codeStart;

    /**
     * Size of the code.
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "field is set by the native part") private int codeSize;

    public HotSpotInstalledCode(String name) {
        super(name);
    }

    /**
     * @return the total size of this code blob
     */
    public int getSize() {
        return size;
    }

    @Override
    public abstract String toString();

    @Override
    public long getStart() {
        return codeStart;
    }

    public long getCodeSize() {
        return codeSize;
    }

    @Override
    public byte[] getCode() {
        if (!isValid()) {
            return null;
        }
        byte[] code = new byte[codeSize];
        UNSAFE.copyMemory(null, codeStart, code, Unsafe.ARRAY_BYTE_BASE_OFFSET, codeSize);
        return code;
    }
}
