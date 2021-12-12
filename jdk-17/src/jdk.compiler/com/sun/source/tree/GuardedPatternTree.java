/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

import jdk.internal.javac.PreviewFeature;

/**
 * A guard pattern tree.
 *
 * @since 17
 */
@PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
public interface GuardedPatternTree extends PatternTree {

    /**
     * The guarded pattern expression.
     * @return the guarded pattern
     */
    public PatternTree getPattern();

    /**
     * The guard expression.
     * @return the guard expression
     */
    public ExpressionTree getExpression();

}
