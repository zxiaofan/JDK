/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.css;

import javafx.css.PseudoClass;

/**
 * Implementation details of {@link javafx.css.PseudoClass}
 */
final class PseudoClassImpl extends PseudoClass {


    PseudoClassImpl(String pseudoClassName, int index) {
        this.pseudoClassName = pseudoClassName;
        this.index = index;
    }

    /** @return the pseudo-class state */
    @Override
    public String getPseudoClassName() {
        return pseudoClassName;
    }

    /** @return the pseudo-class state */
    @Override public String toString() {
        return pseudoClassName;
    }

    public int getIndex() {
       return index;
    }

    private final String pseudoClassName;

    // index of this PseudoClass in pseudoClasses list.
    private final int index;

}
