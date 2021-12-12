/*
 * Copyright (c) 2018, Google LLC. All rights reserved.
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.comp;

import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCFieldAccess;
import com.sun.tools.javac.tree.JCTree.JCIdent;
import com.sun.tools.javac.tree.JCTree.JCLiteral;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.TreeInfo;
import com.sun.tools.javac.tree.TreeScanner;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** A tree visitor that computes a hash code. */
public class TreeHasher extends TreeScanner {

    private final Map<Symbol, Integer> symbolHashes;
    private int result = 17;

    public TreeHasher(Map<Symbol, Integer> symbolHashes) {
        this.symbolHashes = Objects.requireNonNull(symbolHashes);
    }

    public static int hash(JCTree tree, Collection<? extends Symbol> symbols) {
        if (tree == null) {
            return 0;
        }
        Map<Symbol, Integer> symbolHashes = new HashMap<>();
        symbols.forEach(s -> symbolHashes.put(s, symbolHashes.size()));
        TreeHasher hasher = new TreeHasher(symbolHashes);
        tree.accept(hasher);
        return hasher.result;
    }

    private void hash(Object object) {
        result = 31 * result + Objects.hashCode(object);
    }

    @Override
    public void scan(JCTree tree) {
        if (tree == null) {
            return;
        }
        tree = TreeInfo.skipParens(tree);
        if (tree.type != null) {
            Object value = tree.type.constValue();
            if (value != null) {
                hash(value);
                return;
            }
        }
        hash(tree.getTag());
        tree.accept(this);
    }

    @Override
    public void visitLiteral(JCLiteral tree) {
        hash(tree.value);
        super.visitLiteral(tree);
    }

    @Override
    public void visitIdent(JCIdent tree) {
        Symbol sym = tree.sym;
        if (sym != null) {
            Integer hash = symbolHashes.get(sym);
            if (hash != null) {
                hash(hash);
                return;
            }
        }
        hash(sym);
    }

    @Override
    public void visitSelect(JCFieldAccess tree) {
        hash(tree.sym);
        super.visitSelect(tree);
    }

    @Override
    public void visitVarDef(JCVariableDecl tree) {
        symbolHashes.computeIfAbsent(tree.sym, k -> symbolHashes.size());
        super.visitVarDef(tree);
    }
}
