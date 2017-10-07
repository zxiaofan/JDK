/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.meta;

/**
 * Manages unique deoptimization reasons. Reasons are embedded in compiled code and can be
 * invalidated at run time. Subsequent compilations then should not speculate again on such
 * invalidated reasons to avoid repeated deoptimization.
 *
 * All methods of this interface are called by the compiler. There is no need for API to register
 * failed speculations during deoptimization, since every VM has different needs there.
 */
public interface SpeculationLog {

    /**
     * Marker interface for speculation objects that can be added to the speculation log.
     */
    public interface SpeculationReason {
    }

    /**
     * Must be called before compilation, i.e., before a compiler calls {@link #maySpeculate}.
     */
    void collectFailedSpeculations();

    /**
     * If this method returns true, the compiler is allowed to {@link #speculate} with the given
     * reason.
     */
    boolean maySpeculate(SpeculationReason reason);

    /**
     * Registers a speculation that was performed by the compiler.
     *
     * @return A compiler constant encapsulating the provided reason. It is usually passed as an
     *         argument to the deoptimization function.
     */
    JavaConstant speculate(SpeculationReason reason);

    /**
     * Returns if this log has speculations.
     *
     * @return true if there are speculations, false otherwise
     */
    boolean hasSpeculations();
}
