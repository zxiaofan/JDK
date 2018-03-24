/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.css.parser;


public class LexerState {

    /**
     * Determine whether or not this state accepts the character. If the
     * character is accepted, then this state will be entered.
     * @param c the character to test
     * @return true if this state should be entered
     */
    public boolean accepts(int c) {
        final int nRecognizers = recognizers != null ? recognizers.length : 0;
        for(int n=0; n<nRecognizers; n++) {
            if (this.recognizers[n].recognize(c)) return true;
        }
        return false;
    }

    public int getType() {
        return type;
    }

    public LexerState(int type, String name, Recognizer recognizer, Recognizer... others) {
        assert(name != null);
        this.type = type;
        this.name = name;
        if (recognizer != null) {
            final int nRecognizers = 1 + (others != null ? others.length : 0);
            this.recognizers = new Recognizer[nRecognizers];
            this.recognizers[0] = recognizer;
            for(int n=1; n<recognizers.length; n++) {
                this.recognizers[n] = others[n-1];
            }
        } else {
            this.recognizers = null;
        }
    }

    public LexerState(String name, Recognizer recognizer, Recognizer... others) {
        this(Token.INVALID, name, recognizer, others);
    }

    private LexerState() {
        this(Token.INVALID, "invalid", null);
    }

    private final int type;
    private final String name;
    private final Recognizer[] recognizers;

    @Override public String toString() {
        return name;
    }

    @Override public boolean equals(Object other) {
        if (this == other) return true;
        return (other instanceof LexerState) ?
                this.name.equals(((LexerState)other).name) : false;
    }

    @Override public int hashCode() {
        return name.hashCode();
    }

}
