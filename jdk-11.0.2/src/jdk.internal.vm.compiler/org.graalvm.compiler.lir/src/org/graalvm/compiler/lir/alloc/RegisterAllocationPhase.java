/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.alloc;

import org.graalvm.compiler.lir.phases.AllocationPhase;

/**
 * Marker class for register allocation phases.
 */
public abstract class RegisterAllocationPhase extends AllocationPhase {
    private boolean neverSpillConstants;

    public void setNeverSpillConstants(boolean neverSpillConstants) {
        this.neverSpillConstants = neverSpillConstants;
    }

    public boolean getNeverSpillConstants() {
        return neverSpillConstants;
    }
}
