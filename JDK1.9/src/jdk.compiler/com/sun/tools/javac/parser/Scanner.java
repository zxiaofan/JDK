/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.*;
import java.util.List;
import java.util.ArrayList;

import com.sun.tools.javac.util.Position.LineMap;
import com.sun.tools.javac.parser.JavaTokenizer.*;

import static com.sun.tools.javac.parser.Tokens.*;

/** The lexical analyzer maps an input stream consisting of
 *  ASCII characters and Unicode escapes into a token sequence.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class Scanner implements Lexer {

    private Tokens tokens;

    /** The token, set by nextToken().
     */
    private Token token;

    /** The previous token, set by nextToken().
     */
    private Token prevToken;

    /** Buffer of saved tokens (used during lookahead)
     */
    private List<Token> savedTokens = new ArrayList<>();

    private JavaTokenizer tokenizer;

    /**
     * Create a scanner from the input array.  This method might
     * modify the array.  To avoid copying the input array, ensure
     * that {@code inputLength < input.length} or
     * {@code input[input.length -1]} is a white space character.
     *
     * @param fac the factory which created this Scanner
     * @param buf the input, might be modified
     * Must be positive and less than or equal to input.length.
     */
    protected Scanner(ScannerFactory fac, CharBuffer buf) {
        this(fac, new JavaTokenizer(fac, buf));
    }

    protected Scanner(ScannerFactory fac, char[] buf, int inputLength) {
        this(fac, new JavaTokenizer(fac, buf, inputLength));
    }

    protected Scanner(ScannerFactory fac, JavaTokenizer tokenizer) {
        this.tokenizer = tokenizer;
        tokens = fac.tokens;
        token = prevToken = DUMMY;
    }

    public Token token() {
        return token(0);
    }

    public Token token(int lookahead) {
        if (lookahead == 0) {
            return token;
        } else {
            ensureLookahead(lookahead);
            return savedTokens.get(lookahead - 1);
        }
    }
    //where
        private void ensureLookahead(int lookahead) {
            for (int i = savedTokens.size() ; i < lookahead ; i ++) {
                savedTokens.add(tokenizer.readToken());
            }
        }

    public Token prevToken() {
        return prevToken;
    }

    public void nextToken() {
        prevToken = token;
        if (!savedTokens.isEmpty()) {
            token = savedTokens.remove(0);
        } else {
            token = tokenizer.readToken();
        }
    }

    public Token split() {
        Token[] splitTokens = token.split(tokens);
        prevToken = splitTokens[0];
        token = splitTokens[1];
        return token;
    }

    public LineMap getLineMap() {
        return tokenizer.getLineMap();
    }

    public int errPos() {
        return tokenizer.errPos();
    }

    public void errPos(int pos) {
        tokenizer.errPos(pos);
    }
}
