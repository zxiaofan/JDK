/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Enumeration of reasons for why a deoptimization is happening.
 */
public enum DeoptimizationReason {
    None,
    NullCheckException,
    BoundsCheckException,
    ClassCastException,
    ArrayStoreException,
    UnreachedCode,
    TypeCheckedInliningViolated,
    OptimizedTypeCheckViolated,
    NotCompiledExceptionHandler,
    Unresolved,
    JavaSubroutineMismatch,
    ArithmeticException,
    RuntimeConstraint,
    LoopLimitCheck,
    Aliasing,
    TransferToInterpreter,
}
