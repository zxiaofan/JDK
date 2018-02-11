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
 * A tree node for an 'opens' directive in a module declaration.
 *
 * For example:
 * <pre>
 *    opens   <em>package-name</em>;
 *    opens   <em>package-name</em> to <em>module-name</em>;
 * </pre>
 *
 * @since 9
 */
public interface OpensTree extends DirectiveTree {

    /**
     * Returns the name of the package to be opened.
     * @return  the name of the package to be opened
     */
    ExpressionTree getPackageName();

    /**
     * Returns the names of the modules to which the package is opened,
     * or null, if the package is opened to all modules.
     *
     * @return the names of the modules to which the package is opened, or null
     */
    List<? extends ExpressionTree> getModuleNames();
}
