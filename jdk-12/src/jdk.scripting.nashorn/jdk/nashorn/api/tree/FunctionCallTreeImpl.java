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

import java.util.List;
import jdk.nashorn.internal.ir.CallNode;

class FunctionCallTreeImpl extends ExpressionTreeImpl implements FunctionCallTree {
    private final List<? extends ExpressionTree> arguments;
    private final ExpressionTree function;
    FunctionCallTreeImpl(final CallNode node,
            final ExpressionTree function,
            final List<? extends ExpressionTree> arguments) {
        super(node);
        this.function = function;
        this.arguments = arguments;
    }

    @Override
    public Kind getKind() {
        return Kind.FUNCTION_INVOCATION;
    }

    @Override
    public ExpressionTree getFunctionSelect() {
        return function;
    }

    @Override
    public List<? extends ExpressionTree> getArguments() {
        return arguments;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitFunctionCall(this, data);
    }
}
