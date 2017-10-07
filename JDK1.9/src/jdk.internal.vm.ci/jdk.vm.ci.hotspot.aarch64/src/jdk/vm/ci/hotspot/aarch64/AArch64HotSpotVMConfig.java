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
package jdk.vm.ci.hotspot.aarch64;

import jdk.vm.ci.hotspot.HotSpotVMConfigAccess;
import jdk.vm.ci.hotspot.HotSpotVMConfigStore;

/**
 * Used to access native configuration details.
 *
 * All non-static, public fields in this class are so that they can be compiled as constants.
 */
class AArch64HotSpotVMConfig extends HotSpotVMConfigAccess {

    AArch64HotSpotVMConfig(HotSpotVMConfigStore config) {
        super(config);
    }

    final boolean linuxOs = System.getProperty("os.name", "").startsWith("Linux");

    final boolean useCompressedOops = getFlag("UseCompressedOops", Boolean.class);
}
