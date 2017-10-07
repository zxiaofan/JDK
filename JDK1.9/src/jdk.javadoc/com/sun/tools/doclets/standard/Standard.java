/*
 * Copyright (c) 2003, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.standard;

import com.sun.javadoc.*;
import com.sun.tools.doclets.formats.html.*;

/**
 * This doclet generates HTML-formatted documentation for the specified packages and types.
 * @deprecated The doclet has been superseded by its replacement,
 * {@link jdk.javadoc.doclet.StandardDoclet}.
 */
@Deprecated(forRemoval=true, since="9")
public class Standard {

    public static int optionLength(String option) {
        return HtmlDoclet.optionLength(option);
    }

    public static boolean start(RootDoc root) {
        return HtmlDoclet.start(root);
    }

    public static boolean validOptions(String[][] options,
                                   DocErrorReporter reporter) {
        return HtmlDoclet.validOptions(options, reporter);
    }

    public static LanguageVersion languageVersion() {
        return HtmlDoclet.languageVersion();
    }

}
