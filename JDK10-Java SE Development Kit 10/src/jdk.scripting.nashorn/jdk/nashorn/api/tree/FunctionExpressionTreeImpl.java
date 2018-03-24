/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
import jdk.nashorn.internal.ir.FunctionNode;

final class FunctionExpressionTreeImpl extends ExpressionTreeImpl
    implements FunctionExpressionTree {
    private final FunctionNode funcNode;
    private final IdentifierTree funcName;
    private final List<? extends ExpressionTree> params;
    private final Tree body;

    FunctionExpressionTreeImpl(final FunctionNode node,
            final List<? extends ExpressionTree> params,
            final BlockTree body) {
        super(node);
        funcNode = node;
        assert !funcNode.isDeclared() || funcNode.isAnonymous() : "function expression expected";

        final FunctionNode.Kind kind = node.getKind();
        if (node.isAnonymous() || kind == FunctionNode.Kind.GETTER || kind == FunctionNode.Kind.SETTER) {
            funcName = null;
        } else {
            funcName = new IdentifierTreeImpl(node.getIdent());
        }

        this.params = params;
        if (node.getFlag(FunctionNode.HAS_EXPRESSION_BODY)) {
            final StatementTree first = body.getStatements().get(0);
            assert first instanceof ReturnTree : "consise func. expression should have a return statement";
            this.body = ((ReturnTree)first).getExpression();
        } else {
            this.body = body;
        }
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.FUNCTION_EXPRESSION;
    }

    @Override
    public IdentifierTree getName() {
        return funcName;
    }

    @Override
    public List<? extends ExpressionTree> getParameters() {
        return params;
    }

    @Override
    public Tree getBody() {
        return body;
    }

    @Override
    public boolean isStrict() {
        return funcNode.isStrict();
    }

    @Override
    public boolean isArrow() {
        return funcNode.getKind() == FunctionNode.Kind.ARROW;
    }

    @Override
    public boolean isGenerator() {
        return funcNode.getKind() == FunctionNode.Kind.GENERATOR;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitFunctionExpression(this, data);
    }
}
