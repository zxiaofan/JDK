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
import jdk.nashorn.internal.ir.VarNode;

final class FunctionDeclarationTreeImpl extends StatementTreeImpl
    implements FunctionDeclarationTree {
    private final FunctionNode funcNode;
    private final IdentifierTree funcName;
    private final List<? extends ExpressionTree> params;
    private final BlockTree body;

    FunctionDeclarationTreeImpl(final VarNode node,
            final List<? extends ExpressionTree> params,
            final BlockTree body) {
        super(node);
        assert node.getInit() instanceof FunctionNode : "function expected";
        funcNode = (FunctionNode)node.getInit();
        assert funcNode.isDeclared() : "function declaration expected";
        funcName = funcNode.isAnonymous()? null : new IdentifierTreeImpl(node.getName());
        this.params = params;
        this.body = body;
    }

    @Override
    public Kind getKind() {
        return Kind.FUNCTION;
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
    public BlockTree getBody() {
        return body;
    }

    @Override
    public boolean isStrict() {
        return funcNode.isStrict();
    }

    @Override
    public boolean isGenerator() {
        return funcNode.getKind() == FunctionNode.Kind.GENERATOR;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitFunctionDeclaration(this, data);
    }
}
