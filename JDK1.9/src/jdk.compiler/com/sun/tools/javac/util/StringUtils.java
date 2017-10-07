/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** A collection of utilities for String manipulation.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class StringUtils {

    /**Converts the given String to lower case using the {@link Locale#US US Locale}. The result
     * is independent of the default Locale in the current JVM instance.
     */
    public static String toLowerCase(String source) {
        return source.toLowerCase(Locale.US);
    }

    /**Converts the given String to upper case using the {@link Locale#US US Locale}. The result
     * is independent of the default Locale in the current JVM instance.
     */
    public static String toUpperCase(String source) {
        return source.toUpperCase(Locale.US);
    }

    /**Case insensitive version of {@link String#indexOf(java.lang.String)}. Equivalent to
     * {@code text.indexOf(str)}, except the matching is case insensitive.
     */
    public static int indexOfIgnoreCase(String text, String str) {
        return indexOfIgnoreCase(text, str, 0);
    }

    /**Case insensitive version of {@link String#indexOf(java.lang.String, int)}. Equivalent to
     * {@code text.indexOf(str, startIndex)}, except the matching is case insensitive.
     */
    public static int indexOfIgnoreCase(String text, String str, int startIndex) {
        Matcher m = Pattern.compile(Pattern.quote(str), Pattern.CASE_INSENSITIVE).matcher(text);
        return m.find(startIndex) ? m.start() : -1;
    }

}
