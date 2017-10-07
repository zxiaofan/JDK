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

package jdk.nashorn.internal.ir.visitor;

import jdk.nashorn.internal.ir.LexicalContext;

/**
 * Convenience base class for a {@link NodeVisitor} with a plain {@link LexicalContext}.
 */
public abstract class SimpleNodeVisitor extends NodeVisitor<LexicalContext> {

    /**
     * Creates a new simple node visitor.
     */
    public SimpleNodeVisitor() {
        super(new LexicalContext());
    }
}
