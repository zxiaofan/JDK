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


package org.graalvm.compiler.lir.asm;

/**
 * Code for managing a method's native frame.
 */
public interface FrameContext {

    /**
     * Emits code common to all entry points of a method. This may include:
     * <ul>
     * <li>setting up the stack frame</li>
     * <li>saving callee-saved registers</li>
     * <li>stack overflow checking</li>
     * </ul>
     */
    void enter(CompilationResultBuilder crb);

    /**
     * Emits code to be executed just prior to returning from a method. This may include:
     * <ul>
     * <li>restoring callee-saved registers</li>
     * <li>performing a safepoint</li>
     * <li>destroying the stack frame</li>
     * </ul>
     */
    void leave(CompilationResultBuilder crb);

    /**
     * Determines if a frame is set up and torn down by this object.
     */
    boolean hasFrame();
}
