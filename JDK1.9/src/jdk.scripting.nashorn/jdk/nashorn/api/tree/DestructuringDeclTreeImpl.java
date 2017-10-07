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

import jdk.nashorn.internal.ir.ExpressionStatement;
import jdk.nashorn.internal.parser.TokenType;

// This implementation of VariableTree represents a destructuring declaration
final class DestructuringDeclTreeImpl extends StatementTreeImpl
        implements VariableTree {

    private final TokenType declType;
    private final ExpressionTree lhs;
    private final ExpressionTree init;

    DestructuringDeclTreeImpl(final ExpressionStatement exprStat, final ExpressionTree lhs, final ExpressionTree init) {
        super(exprStat);
        assert exprStat.destructuringDeclarationType() != null : "expecting a destructuring decl. statement";

        this.declType = exprStat.destructuringDeclarationType();
        this.lhs = lhs;
        this.init = init;
    }

    @Override
    public Kind getKind() {
        return Kind.VARIABLE;
    }

    @Override
    public ExpressionTree getBinding() {
        return lhs;
    }

    @Override
    public ExpressionTree getInitializer() {
        return init;
    }

    @Override
    public boolean isConst() {
        return declType == TokenType.CONST;
    }

    @Override
    public boolean isLet() {
        return declType == TokenType.LET;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitVariable(this, data);
    }
}
