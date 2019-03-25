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
     * Marker class that indicates that a speculation has no reason.
     */
    final class NoSpeculationReason implements SpeculationReason {
    }

    class Speculation {
        private SpeculationReason reason;

        public Speculation(SpeculationReason reason) {
            this.reason = reason;
        }

        public SpeculationReason getReason() {
            return reason;
        }

        @Override
        public String toString() {
            return reason.toString();
        }
    }

    Speculation NO_SPECULATION = new Speculation(new NoSpeculationReason());

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
     * Registers a speculation performed by the compiler. The compiler must guard every call to this
     * method for a specific reason with a call to {@link #maySpeculate(SpeculationReason)}.
     *
     * This API is subject to a benign race where a during the course of a compilation another
     * thread might fail a speculation such that {@link #maySpeculate(SpeculationReason)} will
     * return false but an earlier call returned true. This method will still return a working
     * {@link Speculation} in that case but the compile will eventually be invalidated and the
     * compile attempted again without the now invalid speculation.
     *
     * @param reason an object representing the reason for the speculation
     * @return a compiler constant encapsulating the provided reason. It is usually passed as an
     *         argument to the deoptimization function.
     */
    Speculation speculate(SpeculationReason reason);

    /**
     * Returns if this log has speculations.
     *
     * @return true if there are speculations, false otherwise
     */
    boolean hasSpeculations();

    /**
     * Given a {@link JavaConstant} previously returned from
     * {@link MetaAccessProvider#encodeSpeculation(Speculation)} return the original
     * {@link Speculation} object.
     */
    Speculation lookupSpeculation(JavaConstant constant);
}
