/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

module jdk.internal.vm.ci {
    exports jdk.vm.ci.services to jdk.internal.vm.compiler;
    exports jdk.vm.ci.runtime to
        jdk.internal.vm.compiler,
        jdk.internal.vm.compiler.management;

    uses jdk.vm.ci.services.JVMCIServiceLocator;
    uses jdk.vm.ci.hotspot.HotSpotJVMCIBackendFactory;

    provides jdk.vm.ci.hotspot.HotSpotJVMCIBackendFactory with
        jdk.vm.ci.hotspot.aarch64.AArch64HotSpotJVMCIBackendFactory,
        jdk.vm.ci.hotspot.amd64.AMD64HotSpotJVMCIBackendFactory,
        jdk.vm.ci.hotspot.sparc.SPARCHotSpotJVMCIBackendFactory;
}
