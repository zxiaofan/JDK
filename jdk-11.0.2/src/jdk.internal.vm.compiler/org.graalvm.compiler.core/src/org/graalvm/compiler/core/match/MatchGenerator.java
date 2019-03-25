/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.match;

import org.graalvm.compiler.core.gen.NodeMatchRules;

/**
 * Code generator for complex match patterns.
 */
public interface MatchGenerator {
    /**
     * @returns null if the match can't be generated or a {@link ComplexMatchResult} that can be
     *          evaluated during LIR generation to produce the final LIR value.
     */
    ComplexMatchResult match(NodeMatchRules matchRules, Object... args);

    /**
     * @return a descriptive name meaningful to the user.
     */
    String getName();
}
