/*
 * Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Classes for matching character sequences against patterns specified
 * by regular expressions.
 *
 * <p> An instance of the {@link java.util.regex.Pattern} class
 * represents a regular expression that is specified in string form in
 * a syntax similar to that used by Perl.
 *
 * <p> Instances of the {@link java.util.regex.Matcher} class are used
 * to match character sequences against a given pattern.  Input is
 * provided to matchers via the {@link java.lang.CharSequence}
 * interface in order to support matching against characters from a
 * wide variety of input sources. </p>
 *
 * <p> Unless otherwise noted, passing a {@code null} argument to a
 * method in any class or interface in this package will cause a
 * {@link java.lang.NullPointerException NullPointerException} to be
 * thrown.
 *
 * <h2>Related Documentation</h2>
 *
 * <p> An excellent tutorial and overview of regular expressions is <a
 * href="http://www.oreilly.com/catalog/regex/"><i>Mastering Regular
 * Expressions</i>, Jeffrey E. F. Friedl, O'Reilly and Associates,
 * 1997.</a> </p>
 *
 * @since 1.4
 * @author Mike McCloskey
 * @author Mark Reinhold
 */
package java.util.regex;
