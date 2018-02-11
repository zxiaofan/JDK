/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.api.tree;

/**
 * Represents regular expression literal in the source code.
 *
 * @since 9
 */
public interface RegExpLiteralTree extends ExpressionTree {
    /**
     * Regular expression pattern to match.
     *
     * @return regular expression pattern
     */
    public String getPattern();

    /**
     * Regular expression matching options.
     *
     * @return options like "i" for ignoreCase used
     */
    public String getOptions();
}
