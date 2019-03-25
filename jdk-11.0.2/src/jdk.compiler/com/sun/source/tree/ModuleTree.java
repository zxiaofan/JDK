/*
 * Copyright (c) 2009, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.util.List;


/**
 * A tree node for a module declaration.
 *
 * For example:
 * <pre>
 *    <em>annotations</em>
 *    [open] module <em>module-name</em> {
 *        <em>directives</em>
 *    }
 * </pre>
 *
 * @since 9
 */
public interface ModuleTree extends Tree {
    /**
     * Returns the annotations associated with this module declaration.
     * @return the annotations
     */
    List<? extends AnnotationTree> getAnnotations();

    /**
     * Returns the type of this module.
     * @return the type of this module
     */
    ModuleKind getModuleType();

    /**
     * Returns the name of the module.
     * @return the name of the module
     */
    ExpressionTree getName();

    /**
     * Returns the directives in the module declaration.
     * @return the directives in the module declaration
     */
    List<? extends DirectiveTree> getDirectives();

    /**
     * The kind of the module.
     */
    enum ModuleKind {
        /**
         * Open module.
         */
        OPEN,
        /**
         * Strong module.
         */
        STRONG;
    }

}
