/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Specifies the action that should be taken by the runtime in case a certain deoptimization is
 * triggered.
 */
public enum DeoptimizationAction {
    /**
     * Do not invalidate the machine code. This is typically used when deoptimizing at a point where
     * it's highly likely nothing will change the likelihood of the deoptimization happening again.
     * For example, a compiled array allocation where the size is negative.
     */
    None(false),

    /**
     * Do not invalidate the machine code, but schedule a recompilation if this deoptimization is
     * triggered too often.
     */
    RecompileIfTooManyDeopts(true),

    /**
     * Invalidate the machine code and reset the profiling information.
     */
    InvalidateReprofile(true),

    /**
     * Invalidate the machine code and immediately schedule a recompilation. This is typically used
     * when deoptimizing to resolve an unresolved symbol in which case extra profiling is not
     * required to determine that the deoptimization will not re-occur.
     */
    InvalidateRecompile(true),

    /**
     * Invalidate the machine code and stop compiling the outermost method of this compilation.
     */
    InvalidateStopCompiling(true);

    private final boolean invalidatesCompilation;

    DeoptimizationAction(boolean invalidatesCompilation) {
        this.invalidatesCompilation = invalidatesCompilation;
    }

    public boolean doesInvalidateCompilation() {
        return invalidatesCompilation;
    }

}
