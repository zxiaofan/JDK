/*
 * Copyright (c) 2011, 2019, Oracle and/or its affiliates. All rights reserved.
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

import static jdk.vm.ci.hotspot.CompilerToVM.compilerToVM;

import jdk.vm.ci.code.InstalledCode;

/**
 * Implementation of {@link InstalledCode} for HotSpot representing a {@code CodeBlob}. The address
 * of the {@code CodeBlob} is stored in {@link InstalledCode#address}.
 */
public abstract class HotSpotInstalledCode extends InstalledCode {

    /**
     * Total size of the code blob (i.e. {@code CodeBlob::size()}).
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "field is set by the native part") private int size;

    /**
     * Start address of the code (i.e. {@code CodeBlob::code_begin()}).
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "field is set by the native part") private long codeStart;

    /**
     * Size of the code (i.e. {@code CodeBlob::code_size()}).
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "field is set by the native part") private int codeSize;

    public HotSpotInstalledCode(String name) {
        super(name);
    }

    /**
     * Gets the value of {@code CodeBlob::size()}.
     */
    public int getSize() {
        return size;
    }

    @Override
    public abstract String toString();

    /**
     * Gets the value of {@code CodeBlob::code_begin()} if {@linkplain #isValid() valid}, 0
     * otherwise.
     */
    @Override
    public long getStart() {
        return codeStart;
    }

    /**
     * Gets the value of {@code CodeBlob::code_size()} if {@linkplain #isValid() valid}, 0
     * otherwise.
     */
    public long getCodeSize() {
        return codeSize;
    }

    @Override
    public byte[] getCode() {
        return compilerToVM().getCode(this);
    }
}
