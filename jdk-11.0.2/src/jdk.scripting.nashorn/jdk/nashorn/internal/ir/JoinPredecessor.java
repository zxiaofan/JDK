/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.ir;

/**
 * Interface implemented by AST nodes that either can occur as predecessors of a control flow join, or contain a control
 * flow join themselves. JoinPredecessor only provides a getter and setter for a {@link LocalVariableConversion}; the
 * semantics of control flow for a particular node implementing the interface are shared between
 * {@code LocalVariableTypesCalculator} that creates the conversions, and {@code CodeGenerator} that uses them.
 */
public interface JoinPredecessor {
    /**
     * Set the local variable conversions needed to unify their types at a control flow join point.
     * @param lc the current lexical context
     * @param conversion the conversions.
     * @return this node or a different node representing the change.
     */
    public JoinPredecessor setLocalVariableConversion(LexicalContext lc, LocalVariableConversion conversion);

    /**
     * Returns the local variable conversions needed to unify their types at a control flow join point.
     * @return the local variable conversions needed to unify their types at a control flow join point. Can be null.
     * Can contain {@link LocalVariableConversion#isLive() dead conversions}.
     */
    public LocalVariableConversion getLocalVariableConversion();
}
