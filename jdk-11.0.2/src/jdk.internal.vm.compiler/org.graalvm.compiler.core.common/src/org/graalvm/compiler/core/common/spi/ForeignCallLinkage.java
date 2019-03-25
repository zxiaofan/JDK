/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.code.CallingConvention;
import jdk.vm.ci.meta.InvokeTarget;
import jdk.vm.ci.meta.Value;

/**
 * The runtime specific details of a {@linkplain ForeignCallDescriptor foreign} call.
 */
public interface ForeignCallLinkage extends InvokeTarget {

    /**
     * Gets the details of where parameters are passed and value(s) are returned from the caller's
     * perspective.
     */
    CallingConvention getOutgoingCallingConvention();

    /**
     * Gets the details of where parameters are passed and value(s) are returned from the callee's
     * perspective.
     */
    CallingConvention getIncomingCallingConvention();

    /**
     * Returns the maximum absolute offset of a PC relative call to this stub from any position in
     * the code cache or -1 when not applicable. Intended for determining the required size of
     * address/offset fields.
     */
    long getMaxCallTargetOffset();

    ForeignCallDescriptor getDescriptor();

    /**
     * Gets the values used/killed by this foreign call.
     */
    Value[] getTemporaries();

    /**
     * Determines if the foreign call target destroys all registers.
     *
     * @return {@code true} if the register allocator must save all live registers around a call to
     *         this target
     */
    boolean destroysRegisters();

    /**
     * Determines if debug info needs to be associated with this call. Debug info is required if the
     * function can raise an exception, try to lock, trigger GC or do anything else that requires
     * the VM to be able to inspect the thread's execution state.
     */
    boolean needsDebugInfo();
}
