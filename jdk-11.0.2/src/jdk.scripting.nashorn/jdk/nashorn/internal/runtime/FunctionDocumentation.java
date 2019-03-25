/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Utility class to fetch documentation for built-in functions, constructors.
 */
final class FunctionDocumentation {
    private FunctionDocumentation() {}

    private static final String DOCS_RESOURCE = "jdk.nashorn.internal.runtime.resources.Functions";

    private static final ResourceBundle FUNC_DOCS;
    static {
        FUNC_DOCS = ResourceBundle.getBundle(DOCS_RESOURCE, Locale.getDefault());
    }

    static String getDoc(final String docKey) {
        try {
            return FUNC_DOCS.getString(docKey);
        } catch (final RuntimeException ignored) {
            return null;
        }
    }
}
