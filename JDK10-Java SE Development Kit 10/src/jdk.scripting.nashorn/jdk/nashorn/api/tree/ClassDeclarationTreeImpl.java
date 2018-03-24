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
import jdk.nashorn.internal.ir.VarNode;

final class ClassDeclarationTreeImpl extends StatementTreeImpl implements ClassDeclarationTree {

    private final IdentifierTree name;
    private final ExpressionTree classHeritage;
    private final PropertyTree constructor;
    private final List<? extends PropertyTree> classElements;

    ClassDeclarationTreeImpl(final VarNode node, final IdentifierTree name,
            final ExpressionTree classHeritage, final PropertyTree constructor,
            final List<? extends PropertyTree> classElements) {
        super(node);
        this.name = name;
        this.classHeritage = classHeritage;
        this.constructor = constructor;
        this.classElements = classElements;
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.CLASS;
    }

    @Override
    public IdentifierTree getName() {
        return name;
    }

    @Override
    public ExpressionTree getClassHeritage() {
        return classHeritage;
    }

    @Override
    public PropertyTree getConstructor() {
        return constructor;
    }

    @Override
    public List<? extends PropertyTree> getClassElements() {
        return classElements;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitClassDeclaration(this, data);
    }
}