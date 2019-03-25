/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.spi;

import org.graalvm.compiler.core.common.LIRKind;
import jdk.internal.vm.compiler.word.LocationIdentity;

import jdk.vm.ci.code.ValueKindFactory;

/**
 * Details about a set of supported {@link ForeignCallDescriptor foreign calls}.
 */
public interface ForeignCallsProvider extends ValueKindFactory<LIRKind> {

    /**
     * Determines if a given foreign call is side-effect free. Deoptimization cannot return
     * execution to a point before a foreign call that has a side effect.
     */
    boolean isReexecutable(ForeignCallDescriptor descriptor);

    /**
     * Gets the set of memory locations killed by a given foreign call. Returning the special value
     * {@link LocationIdentity#any()} denotes that the call kills all memory locations. Returning
     * any empty array denotes that the call does not kill any memory locations.
     */
    LocationIdentity[] getKilledLocations(ForeignCallDescriptor descriptor);

    /**
     * Determines if deoptimization can occur during a given foreign call.
     */
    boolean canDeoptimize(ForeignCallDescriptor descriptor);

    /**
     * Identifies foreign calls which are guaranteed to include a safepoint check.
     */
    boolean isGuaranteedSafepoint(ForeignCallDescriptor descriptor);

    /**
     * Gets the linkage for a foreign call.
     */
    ForeignCallLinkage lookupForeignCall(ForeignCallDescriptor descriptor);
}
