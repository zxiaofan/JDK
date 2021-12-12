/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.doctree;

import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * A tree node to stand in for malformed text.
 *
 * @since 1.8
 */
public interface ErroneousTree extends TextTree {
    /**
     * Returns a diagnostic object giving details about
     * the reason the body text is in error.
     *
     * @return a diagnostic
     */
    Diagnostic<JavaFileObject> getDiagnostic();
}
