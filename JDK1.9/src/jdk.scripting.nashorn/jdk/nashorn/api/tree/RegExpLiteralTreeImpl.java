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

import jdk.nashorn.internal.ir.LiteralNode;
import jdk.nashorn.internal.parser.Lexer;

final class RegExpLiteralTreeImpl extends ExpressionTreeImpl
    implements RegExpLiteralTree {
    private final String pattern;
    private final String options;
    RegExpLiteralTreeImpl(final LiteralNode<?> node) {
        super(node);
        assert node.getValue() instanceof Lexer.RegexToken : "regexp expected";
        final Lexer.RegexToken regex = (Lexer.RegexToken) node.getValue();
        this.pattern = regex.getExpression();
        this.options = regex.getOptions();
    }

    @Override
    public Kind getKind() {
        return Kind.REGEXP_LITERAL;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

    @Override
    public String getOptions() {
        return options;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitRegExpLiteral(this, data);
    }
}
