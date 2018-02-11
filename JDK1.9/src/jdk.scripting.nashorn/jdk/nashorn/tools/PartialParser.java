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

package jdk.nashorn.tools;

import jdk.nashorn.internal.runtime.Context;

/**
 * Partial parsing support for code completion of expressions.
 */
public interface PartialParser {
    /**
     * Parse potentially partial code and keep track of the start of last expression.
     *
     * @param context the nashorn context
     * @param code code that is to be parsed
     * @return the start index of the last expression parsed in the (incomplete) code.
     */
    public int getLastExpressionStart(final Context context, final String code);
}
