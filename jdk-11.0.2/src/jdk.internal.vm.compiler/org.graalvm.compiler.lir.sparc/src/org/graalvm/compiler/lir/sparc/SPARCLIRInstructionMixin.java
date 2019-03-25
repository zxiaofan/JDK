/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.sparc;

public interface SPARCLIRInstructionMixin {

    default boolean leavesRegisterWindow() {
        return false;
    }

    default SizeEstimate estimateSize() {
        return getSPARCLIRInstructionStore().estimate;
    }

    SPARCLIRInstructionMixinStore getSPARCLIRInstructionStore();

    /**
     * This class represents a size estimation of a particular LIR instruction. It contains a
     * pessimistic estimate of emitted SPARC instructions and emitted bytes into the constant
     * section.
     */
    class SizeEstimate {
        /**
         * Cache the first size definition (with just 0 as constant size).
         */
        private static final SizeEstimate[] cache = new SizeEstimate[5];

        static {
            for (int i = 0; i < cache.length; i++) {
                cache[i] = new SizeEstimate(i, 0);
            }
        }

        public final int instructionSize;
        public final int constantSize;

        public SizeEstimate(int instructionSize, int constantSize) {
            this.instructionSize = instructionSize;
            this.constantSize = constantSize;
        }

        public static SizeEstimate create(int instructionSize, int constantSize) {
            if (constantSize == 0 && instructionSize < cache.length) {
                return cache[instructionSize];
            } else {
                return new SizeEstimate(instructionSize, constantSize);
            }
        }

        public static SizeEstimate create(int instructionSize) {
            if (instructionSize < cache.length) {
                return cache[instructionSize];
            } else {
                return new SizeEstimate(instructionSize, 0);
            }
        }

        @Override
        public String toString() {
            return "SE[i=" + instructionSize + ", c=" + constantSize + "]";
        }
    }

    class SPARCLIRInstructionMixinStore {
        public final SizeEstimate estimate;
        public SPARCDelayedControlTransfer delayedControlTransfer = SPARCDelayedControlTransfer.DUMMY;

        public SPARCLIRInstructionMixinStore(SizeEstimate estimate) {
            this.estimate = estimate;
        }

        @Override
        public String toString() {
            return estimate != null ? estimate.toString() : "";
        }
    }
}
