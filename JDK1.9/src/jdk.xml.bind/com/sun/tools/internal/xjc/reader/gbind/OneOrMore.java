/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.gbind;

/**
 * {@link Expression} that represents kleene-star operation (A+)
 *
 * @author Kohsuke Kawaguchi
 */
public final class OneOrMore extends Expression {
    /**
     * 'A' of 'A+'.
     */
    private final Expression child;

    public OneOrMore(Expression child) {
        this.child = child;
    }

    ElementSet lastSet() {
        return child.lastSet();
    }

    boolean isNullable() {
        return child.isNullable();
    }

    void buildDAG(ElementSet incoming) {
        child.buildDAG(ElementSets.union(incoming,child.lastSet()));
    }

    public String toString() {
        return child.toString()+'+';
    }
}
