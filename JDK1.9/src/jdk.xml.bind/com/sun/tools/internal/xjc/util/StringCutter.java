/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.util;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class to parse a string
 *
 * @author Kohsuke Kawaguchi
 */
public final class StringCutter {
    private final String original;
    private String s;
    private boolean ignoreWhitespace;

    public StringCutter(String s, boolean ignoreWhitespace) {
        this.s = this.original = s;
        this.ignoreWhitespace = ignoreWhitespace;
    }

    public void skip(String regexp) throws ParseException {
        next(regexp);
    }

    public String next(String regexp) throws ParseException {
        trim();
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(s);
        if(m.lookingAt()) {
            String r = m.group();
            s = s.substring(r.length());
            trim();
            return r;
        } else
            throw error();
    }

    private ParseException error() {
        return new ParseException(original,original.length()-s.length());
    }

    public String until(String regexp) throws ParseException {
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(s);
        if(m.find()) {
            String r =  s.substring(0,m.start());
            s = s.substring(m.start());
            if(ignoreWhitespace)
                r = r.trim();
            return r;
        } else {
            // return everything left
            String r = s;
            s = "";
            return r;
        }
    }

    public char peek() {
        return s.charAt(0);
    }

    private void trim() {
        if(ignoreWhitespace)
            s = s.trim();
    }

    public int length() {
        return s.length();
    }
}
