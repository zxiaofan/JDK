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

import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * A string tokenizer that supports entries with quotes and nested quotes. If
 * the separators are quoted either by ' and ", or whatever quotes the user
 * supplies they will be ignored and considered part of another token
 */
public final class QuotedStringTokenizer {
    private final LinkedList<String> tokens;

    private final char quotes[];

    /**
     * Constructor
     *
     * @param str string to tokenize
     */
    public QuotedStringTokenizer(final String str) {
        this(str, " ");
    }

    /**
     * Create a quoted string tokenizer
     *
     * @param str
     *            a string to tokenize
     * @param delim
     *            delimiters between tokens
     *
     */
    public QuotedStringTokenizer(final String str, final String delim) {
        this(str, delim, new char[] { '"', '\'' });
    }

    /**
     * Create a quoted string tokenizer
     *
     * @param str
     *            a string to tokenize
     * @param delim
     *            delimiters between tokens
     * @param quotes
     *            all the characters that should be accepted as quotes, default
     *            is ' or "
     */
    private QuotedStringTokenizer(final String str, final String delim, final char[] quotes) {
        this.quotes = quotes;

        boolean delimIsWhitespace = true;
        for (int i = 0; i < delim.length(); i++) {
            if (!Character.isWhitespace(delim.charAt(i))) {
                delimIsWhitespace = false;
                break;
            }
        }

        final StringTokenizer st = new StringTokenizer(str, delim);
        tokens = new LinkedList<>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            while (unmatchedQuotesIn(token)) {
                if (!st.hasMoreTokens()) {
                    throw new IndexOutOfBoundsException(token);
                }
                token += (delimIsWhitespace ? " " : delim) + st.nextToken();
            }
            tokens.add(stripQuotes(token));
        }
    }

    /**
     * @return the number of tokens in the tokenizer
     */
    public int countTokens() {
        return tokens.size();
    }

    /**
     * @return true if there are tokens left
     */
    public boolean hasMoreTokens() {
        return countTokens() > 0;
    }

    /**
     * @return the next token in the tokenizer
     */
    public String nextToken() {
        return tokens.removeFirst();
    }

    private String stripQuotes(final String value0) {
        String value = value0.trim();
        for (final char q : quotes) {
            if (value.length() >= 2 && value.startsWith("" + q) && value.endsWith("" + q)) {
                // also go over the value and remove \q sequences. they are just
                // plain q now
                value = value.substring(1, value.length() - 1);
                value = value.replace("\\" + q, "" + q);
            }
        }
        return value;
    }

    private boolean unmatchedQuotesIn(final String str) {
        final Stack<Character> quoteStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            for (final char q : this.quotes) {
                if (c == q) {
                    if (quoteStack.isEmpty()) {
                        quoteStack.push(c);
                    } else {
                        final char top = quoteStack.pop();
                        if (top != c) {
                            quoteStack.push(top);
                            quoteStack.push(c);
                        }
                    }
                }
            }
        }

        return !quoteStack.isEmpty();
    }
}
