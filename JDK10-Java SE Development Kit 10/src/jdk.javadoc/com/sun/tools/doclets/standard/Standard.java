/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.RootDoc;

/**
 * This is not the doclet you are looking for.
 * @deprecated The doclet has been superseded by its replacement,
 * {@link jdk.javadoc.doclet.StandardDoclet}.
 */
@Deprecated(forRemoval=true, since="9")
@SuppressWarnings("deprecation")
public class Standard {

    public static boolean start(RootDoc root) {
        root.printNotice("Notice: " + "This is not the Standard Doclet");
        return true;
    }

    public static int optionLength(String option) {
        return 0;  // all options are unsupported
    }
}
