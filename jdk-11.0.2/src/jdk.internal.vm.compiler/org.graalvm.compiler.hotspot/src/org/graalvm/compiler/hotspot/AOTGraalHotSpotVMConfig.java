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


package org.graalvm.compiler.hotspot;

import org.graalvm.compiler.core.common.CompressEncoding;

import jdk.vm.ci.hotspot.HotSpotVMConfigStore;

public class AOTGraalHotSpotVMConfig extends GraalHotSpotVMConfig {
    private final CompressEncoding aotOopEncoding;
    private final CompressEncoding aotKlassEncoding;

    public AOTGraalHotSpotVMConfig(HotSpotVMConfigStore store) {
        super(store);
        // AOT captures VM settings during compilation. For compressed oops this
        // presents a problem for the case when the VM selects a zero-shift mode
        // (i.e., when the heap is less than 4G). Compiling an AOT binary with
        // zero-shift limits its usability. As such we force the shift to be
        // always equal to alignment to avoid emitting zero-shift AOT code.
        CompressEncoding vmOopEncoding = super.getOopEncoding();
        aotOopEncoding = new CompressEncoding(vmOopEncoding.getBase(), logMinObjAlignment());
        CompressEncoding vmKlassEncoding = super.getKlassEncoding();
        aotKlassEncoding = new CompressEncoding(vmKlassEncoding.getBase(), logKlassAlignment);
        assert check();
    }

    @Override
    public CompressEncoding getOopEncoding() {
        return aotOopEncoding;
    }

    @Override
    public CompressEncoding getKlassEncoding() {
        return aotKlassEncoding;
    }
}
