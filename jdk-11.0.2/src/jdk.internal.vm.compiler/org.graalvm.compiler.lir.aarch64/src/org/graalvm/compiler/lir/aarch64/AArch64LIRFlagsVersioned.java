/*
 * Copyright (c) 2018, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.aarch64;

import jdk.vm.ci.aarch64.AArch64;
import jdk.vm.ci.aarch64.AArch64.CPUFeature;
import jdk.vm.ci.aarch64.AArch64.Flag;
import jdk.vm.ci.code.Architecture;

public class AArch64LIRFlagsVersioned {
    public static boolean useLSE(Architecture arch) {
        AArch64 aarch64 = (AArch64) arch;
        return aarch64.getFeatures().contains(CPUFeature.LSE) || aarch64.getFlags().contains(Flag.UseLSE);
    }
}