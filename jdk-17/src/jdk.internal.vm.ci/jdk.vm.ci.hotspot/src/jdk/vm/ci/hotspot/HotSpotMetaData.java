/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

import static jdk.vm.ci.hotspot.HotSpotJVMCIRuntime.runtime;

import jdk.vm.ci.code.TargetDescription;

public class HotSpotMetaData {
    private byte[] pcDescBytes;
    private byte[] scopesDescBytes;
    private byte[] relocBytes;
    private byte[] exceptionBytes;
    private byte[] implicitExceptionBytes;
    private byte[] oopMaps;
    private Object[] metadata;

    public HotSpotMetaData(TargetDescription target, HotSpotCompiledCode compiledMethod) {
        // Assign the fields default values...
        pcDescBytes = new byte[0];
        scopesDescBytes = new byte[0];
        relocBytes = new byte[0];
        exceptionBytes = new byte[0];
        oopMaps = new byte[0];
        metadata = new String[0];
        // ...some of them will be overwritten by the VM:
        runtime().getCompilerToVM().getMetadata(target, compiledMethod, this);
    }

    public byte[] pcDescBytes() {
        return pcDescBytes;
    }

    public byte[] scopesDescBytes() {
        return scopesDescBytes;
    }

    public byte[] relocBytes() {
        return relocBytes;
    }

    public byte[] exceptionBytes() {
        return exceptionBytes;
    }

    public byte[] implicitExceptionBytes() {
        return implicitExceptionBytes;
    }

    public byte[] oopMaps() {
        return oopMaps;
    }

    public Object[] metadataEntries() {
        return metadata;
    }
}
