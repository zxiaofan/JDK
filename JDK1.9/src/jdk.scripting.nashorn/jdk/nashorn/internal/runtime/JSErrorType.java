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

package jdk.nashorn.internal.runtime;

/**
 * Native ECMAScript Error types.
 */
public enum JSErrorType {
    /** Generic error */
    ERROR,
    /** EvalError */
    EVAL_ERROR,
    /** RangeError */
    RANGE_ERROR,
    /** Reference Error */
    REFERENCE_ERROR,
    /** Syntax Error */
    SYNTAX_ERROR,
    /** Type Error */
    TYPE_ERROR,
    /** URI Error */
    URI_ERROR
}
