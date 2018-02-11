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
import jdk.nashorn.internal.ir.SwitchNode;

final class SwitchTreeImpl extends StatementTreeImpl implements SwitchTree {
    private final ExpressionTree expr;
    private final List<? extends CaseTree> cases;
    SwitchTreeImpl(final SwitchNode node,
            final ExpressionTree expr,
            final List<? extends CaseTree> cases) {
        super(node);
        this.expr = expr;
        this.cases = cases;
    }

    @Override
    public Kind getKind() {
        return Kind.SWITCH;
    }

    @Override
    public ExpressionTree getExpression() {
        return expr;
    }

    @Override
    public List<? extends CaseTree> getCases() {
        return cases;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitSwitch(this, data);
    }
}
