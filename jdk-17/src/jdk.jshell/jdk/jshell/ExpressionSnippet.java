/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jshell;

import jdk.jshell.Key.ExpressionKey;

/**
 * Snippet for an assignment or variable-value expression.
 * The Kind is {@link jdk.jshell.Snippet.Kind#EXPRESSION}.
 * <p>
 * <code>ExpressionSnippet</code> is immutable: an access to
 * any of its methods will always return the same result.
 * and thus is thread-safe.
 *
 * @since 9
 * @jls 15 Expressions
 */
public class ExpressionSnippet extends Snippet {

    ExpressionSnippet(ExpressionKey key, String userSource, Wrap guts, String name, SubKind subkind) {
        super(key, userSource, guts, name, subkind, null);
    }

    /**
     * Variable name which is the value of the expression. Since the expression
     * is either just a variable identifier or it is an assignment
     * to a variable, there is always a variable which is the subject of the
     * expression. All other forms of expression become temporary variables
     * which are instead referenced by a {@link VarSnippet}.
     * @return the name of the variable which is the subject of the expression.
     */
    @Override
    public String name() {
        return key().name();
    }

    /**
     * Type of the expression
     * @return String representation of the type of the expression.
     */
    public String typeName() {
        return key().typeName();
    }

    /**** internal access ****/

    @Override
    ExpressionKey key() {
        return (ExpressionKey) super.key();
    }
}
