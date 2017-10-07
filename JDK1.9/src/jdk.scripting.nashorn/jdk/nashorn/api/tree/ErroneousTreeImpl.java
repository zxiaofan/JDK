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

import jdk.nashorn.internal.ir.ErrorNode;

final class ErroneousTreeImpl extends ExpressionTreeImpl implements ErroneousTree {
    ErroneousTreeImpl(final ErrorNode errorNode) {
        super(errorNode);
    }

    @Override
    public Kind getKind() {
        return Kind.ERROR;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitErroneous(this, data);
    }
}
