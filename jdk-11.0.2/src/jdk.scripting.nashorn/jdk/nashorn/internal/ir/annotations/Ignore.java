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
import jdk.nashorn.internal.ir.debug.ASTWriter;

/**
 * This signifies a node that should be ignored in traversal, for example
 * a reference to an already traversed node, or various metadata that
 * has no actual IR representations, but yet reside in the node.
 *
 * @see ASTWriter
 * @see jdk.nashorn.internal.ir.Node
 */
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Ignore {
    // Empty
}
