/*
 * Copyright (c) 2005, 2019, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.parser;

import com.sun.tools.javac.parser.Tokens.*;
import com.sun.tools.javac.util.Position.LineMap;

/**
 * The lexical analyzer maps an input stream consisting of ASCII
 * characters and Unicode escapes into a token sequence.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */
public interface Lexer {

    /**
     * Consume the next token.
     */
    void nextToken();

    /**
     * Return current token.
     */
    Token token();

    /**
     * Return token with given lookahead.
     */
    Token token(int lookahead);

    /**
     * Return the last character position of the previous token.
     */
    Token prevToken();

    /**
     * Splits the current token in two and return the first (split) token.
     * For instance {@literal '<<<'} is split into two tokens
     * {@literal '<'} and {@literal '<<'} respectively,
     * and the latter is returned.
     */
    Token split();

    /**
     * Return the position where a lexical error occurred;
     */
    int errPos();

    /**
     * Set the position where a lexical error occurred;
     */
    void errPos(int pos);

    /**
     * Build a map for translating between line numbers and
     * positions in the input.
     *
     * @return a LineMap
     */
    LineMap getLineMap();
}
