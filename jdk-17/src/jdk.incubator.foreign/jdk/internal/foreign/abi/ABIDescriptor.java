/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.foreign.abi;

import jdk.internal.invoke.ABIDescriptorProxy;

public class ABIDescriptor implements ABIDescriptorProxy {
    final Architecture arch;

    public final VMStorage[][] inputStorage;
    public final VMStorage[][] outputStorage;

    final VMStorage[][] volatileStorage;

    final int stackAlignment;
    final int shadowSpace;

    public ABIDescriptor(Architecture arch, VMStorage[][] inputStorage, VMStorage[][] outputStorage,
                         VMStorage[][] volatileStorage, int stackAlignment, int shadowSpace) {
        this.arch = arch;
        this.inputStorage = inputStorage;
        this.outputStorage = outputStorage;
        this.volatileStorage = volatileStorage;
        this.stackAlignment = stackAlignment;
        this.shadowSpace = shadowSpace;
    }

    @Override
    public int shadowSpaceBytes() {
        return shadowSpace;
    }
}
