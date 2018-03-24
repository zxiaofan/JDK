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

package jdk.nashorn.internal.ir.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Reference node in AST, i.e. anything not a copy. Important for
 * AST traversal and cloning. Cloning currently as a rule uses
 * existingOrSame for references and otherwise existingOrCopy
 */
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Reference {
    // EMPTY
}
