/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.text;

import java.util.Locale;

final class StringCase {

    // Note that we should perform case-conversion with neutral locale to
    // match the behavior of other WebKit Unicode implementations.

    private static String toLowerCase(String src) {
        return src.toLowerCase(Locale.ROOT);
    }

    private static String toUpperCase(String src) {
        return src.toUpperCase(Locale.ROOT);
    }

    private static String foldCase(String src) {
        return src.toUpperCase(Locale.ROOT).toLowerCase(Locale.ROOT);
    }
}
