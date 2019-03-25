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

package jdk.nashorn.internal.parser;

/**
 * Classification of token types.
 */
public enum TokenKind {
    /** Error, EOF, EOL...*/
    SPECIAL,
    /** Unary operators. */
    UNARY,
    /** Binary operators. */
    BINARY,
    /** [] () {} */
    BRACKET,
    /** String recognized as a keyword. */
    KEYWORD,
    /** Literal constant. */
    LITERAL,
    /** IR only token. */
    IR,
    /** Token reserved for future usage. */
    FUTURE,
    /** Token reserved for future in strict mode. */
    FUTURESTRICT
}
