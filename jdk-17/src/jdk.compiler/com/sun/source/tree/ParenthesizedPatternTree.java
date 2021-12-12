/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for a parenthesized pattern.
 *
 * For example:
 * <pre>
 *   ( <em>pattern</em> )
 * </pre>
 *
 * @jls 14.30.1 Kinds of Patterns
 *
 * @since 17
 */
@PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
public interface ParenthesizedPatternTree extends PatternTree {
    /**
     * Returns the pattern within the parentheses.
     * @return the pattern
     */
    PatternTree getPattern();
}
