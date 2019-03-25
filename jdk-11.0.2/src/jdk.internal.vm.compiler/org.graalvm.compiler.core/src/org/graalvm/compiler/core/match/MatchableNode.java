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

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.graalvm.compiler.nodes.ValueNode;

/**
 * Describes the properties of a node for use when building a {@link MatchPattern}. These
 * declarations are required when parsing a {@link MatchRule}. They are expected to be found on a
 * super type of the holder of the method declaring the {@link MatchRule}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(value = MatchableNodes.class)
public @interface MatchableNode {

    /**
     * The {@link ValueNode} subclass this annotation describes. These annotations might work better
     * if they were directly on the node being described but that may complicate the annotation
     * processing.
     */
    Class<? extends ValueNode> nodeClass();

    /**
     * The names of the inputs in the order they should appear in the match.
     */
    String[] inputs() default {};

    /**
     * Can a pattern be matched with the operands swapped. This will cause swapped versions of
     * patterns to be automatically generated.
     */
    boolean commutative() default false;

    /**
     * Can a node with multiple uses be safely matched by a rule.
     */
    boolean shareable() default false;
}
