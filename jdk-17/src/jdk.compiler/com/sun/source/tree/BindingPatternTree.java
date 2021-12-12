/*
 * Copyright (c) 2017, 2019, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

/**
 * A binding pattern tree
 *
 * @since 16
 */
public interface BindingPatternTree extends PatternTree {

    /**
     * Returns the binding variable.
     * @return the binding variable
     */
    VariableTree getVariable();

}
