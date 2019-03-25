/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
 * Represents the package declaration.
 *
 * @jls sections 7.3, and 7.4
 *
 * @author Paul Govereau
 * @since 9
 */
public interface PackageTree extends Tree {
    /**
     * Returns the annotations associated with this package declaration.
     * @return the annotations
     */
    List<? extends AnnotationTree> getAnnotations();

    /**
     * Returns the name of the package being declared.
     * @return the name
     */
    ExpressionTree getPackageName();
}
