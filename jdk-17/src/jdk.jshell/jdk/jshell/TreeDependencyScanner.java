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

package jdk.jshell;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.ImportTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.PackageTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.TreeScanner;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.lang.model.element.Name;

/**
 * Search a compiler API parse tree for dependencies.
 */
class TreeDependencyScanner extends TreeScanner<Void, Set<String>> {

    private final Set<String> decl = new HashSet<>();
    private final Set<String> body = new HashSet<>();

    public void scan(Tree node) {
        scan(node, decl);
    }

    public Collection<String> declareReferences() {
        return decl;
    }

    public Collection<String> bodyReferences() {
        return body;
    }

    private void add(Set<String> p, Name name) {
        p.add(name.toString());
    }

    // -- Differentiate declaration references from body references ---

    @Override
    @SuppressWarnings("preview")
    public Void visitClass(ClassTree node, Set<String> p) {
        scan(node.getModifiers(), p);
        scan(node.getTypeParameters(), p);
        scan(node.getExtendsClause(), p);
        scan(node.getImplementsClause(), p);
        scan(node.getPermitsClause(), p);
        scan(node.getMembers(), body);
        return null;
    }

    @Override
    public Void visitMethod(MethodTree node, Set<String> p) {
        scan(node.getModifiers(), p);
        scan(node.getReturnType(), p);
        scan(node.getTypeParameters(), p);
        scan(node.getParameters(), p);
        scan(node.getReceiverParameter(), p);
        scan(node.getThrows(), p);
        scan(node.getBody(), body);
        scan(node.getDefaultValue(), body);
        return null;
    }

    @Override
    public Void visitVariable(VariableTree node, Set<String> p) {
        scan(node.getModifiers(), p);
        scan(node.getType(), p);
        scan(node.getNameExpression(), p);
        scan(node.getInitializer(), body);
        return null;
    }

    // --- Ignore these ---

    @Override
    public Void visitPackage(PackageTree node, Set<String> p) {
        return null;
    }

    @Override
    public Void visitImport(ImportTree node, Set<String> p) {
        return null;
    }


    // -- Actual Symbol names ---

    @Override
    public Void visitMemberSelect(MemberSelectTree node, Set<String> p) {
        add(p, node.getIdentifier());
        return super.visitMemberSelect(node, p);
    }

    @Override
    public Void visitIdentifier(IdentifierTree node, Set<String> p) {
        add(p, node.getName());
        return super.visitIdentifier(node, p);
    }
}
