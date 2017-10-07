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

package jdk.nashorn.internal.runtime.regexp;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.MULTILINE;
import static java.util.regex.Pattern.UNICODE_CASE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import jdk.nashorn.internal.runtime.ParserException;

/**
 * Default regular expression implementation based on java.util.regex package.
 *
 * Note that this class is not thread-safe as it stores the current match result
 * and the string being matched in instance fields.
 */
public class JdkRegExp extends RegExp {

    /** Java regexp pattern to use for match. We compile to one of these */
    private Pattern pattern;

    /**
     * Construct a Regular expression from the given {@code source} and {@code flags} strings.
     *
     * @param source RegExp source string
     * @param flags RegExp flag string
     * @throws ParserException if flags is invalid or source string has syntax error.
     */
    public JdkRegExp(final String source, final String flags) throws ParserException {
        super(source, flags);

        int intFlags = 0;

        if (isIgnoreCase()) {
            intFlags |= CASE_INSENSITIVE | UNICODE_CASE;
        }
        if (isMultiline()) {
            intFlags |= MULTILINE;
        }

        try {
            RegExpScanner parsed;

            try {
                parsed = RegExpScanner.scan(source);
            } catch (final PatternSyntaxException e) {
                // refine the exception with a better syntax error, if this
                // passes, just rethrow what we have
                Pattern.compile(source, intFlags);
                throw e;
            }

            if (parsed != null) {
                this.pattern = Pattern.compile(parsed.getJavaPattern(), intFlags);
                this.groupsInNegativeLookahead = parsed.getGroupsInNegativeLookahead();
            }
        } catch (final PatternSyntaxException e2) {
            throwParserException("syntax", e2.getMessage());
        }
    }

    @Override
    public RegExpMatcher match(final String str) {
        if (pattern == null) {
            return null; // never matches or similar, e.g. a[]
        }

        return new DefaultMatcher(str);
    }

    class DefaultMatcher implements RegExpMatcher {
        final String input;
        final Matcher defaultMatcher;

        DefaultMatcher(final String input) {
            this.input = input;
            this.defaultMatcher = pattern.matcher(input);
        }

        @Override
        public boolean search(final int start) {
            return defaultMatcher.find(start);
        }

        @Override
        public String getInput() {
            return input;
        }

        @Override
        public int start() {
            return defaultMatcher.start();
        }

        @Override
        public int start(final int group) {
            return defaultMatcher.start(group);
        }

        @Override
        public int end() {
            return defaultMatcher.end();
        }

        @Override
        public int end(final int group) {
            return defaultMatcher.end(group);
        }

        @Override
        public String group() {
            return defaultMatcher.group();
        }

        @Override
        public String group(final int group) {
            return defaultMatcher.group(group);
        }

        @Override
        public int groupCount() {
            return defaultMatcher.groupCount();
        }
    }

}
