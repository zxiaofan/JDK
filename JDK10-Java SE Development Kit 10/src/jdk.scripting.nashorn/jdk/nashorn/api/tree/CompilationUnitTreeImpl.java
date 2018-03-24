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
import jdk.nashorn.internal.ir.FunctionNode;

final class CompilationUnitTreeImpl extends TreeImpl
    implements CompilationUnitTree {
    private final FunctionNode funcNode;
    private final List<? extends Tree> elements;
    private final ModuleTree module;

    CompilationUnitTreeImpl(final FunctionNode node,
            final List<? extends Tree> elements,
            final ModuleTree module) {
        super(node);
        this.funcNode = node;
        assert funcNode.getKind() == FunctionNode.Kind.SCRIPT ||
                funcNode.getKind() == FunctionNode.Kind.MODULE :
                "script or module function expected";
        this.elements = elements;
        this.module = module;
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.COMPILATION_UNIT;
    }

    @Override
    public List<? extends Tree> getSourceElements() {
        return elements;
    }

    @Override
    public String getSourceName() {
        return funcNode.getSourceName();
    }

    @Override
    public boolean isStrict() {
        return funcNode.isStrict();
    }

    @Override
    public LineMap getLineMap() {
        return new LineMapImpl(funcNode.getSource());
    }

    @Override
    public ModuleTree getModule() {
        return module;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitCompilationUnit(this, data);
    }
}
