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

import java.util.Set;

/**
 * This builds content models.
 *
 * @author Kohsuke Kawaguchi
 */
public abstract class Expression {

    /**
     * Computes {@code LAST(exp)}
     */
    abstract ElementSet lastSet();

    /**
     * True of {@code \epsilon \in L(exp)}
     */
    abstract boolean isNullable();

    /**
     * Builds up a DAG among {@link Element}s in this expression.
     */
    abstract void buildDAG(ElementSet incoming);

    /**
     * {@link Expression} that represents epsilon, the length-0 string.
     */
    public static final Expression EPSILON = new Expression() {
        ElementSet lastSet() {
            return ElementSet.EMPTY_SET;
        }

        boolean isNullable() {
            return true;
        }

        void buildDAG(ElementSet incoming) {
            // noop
        }

        public String toString() {
            return "-";
        }
    };
}
