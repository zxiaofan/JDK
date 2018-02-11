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

package jdk.nashorn.api.tree;

import jdk.nashorn.internal.ir.DebuggerNode;

final class DebuggerTreeImpl extends StatementTreeImpl implements DebuggerTree {
    DebuggerTreeImpl(final DebuggerNode node) {
        super(node);
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.DEBUGGER;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitDebugger(this, data);
    }
}
