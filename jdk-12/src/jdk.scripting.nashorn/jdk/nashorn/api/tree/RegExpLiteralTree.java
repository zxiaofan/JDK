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
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
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
