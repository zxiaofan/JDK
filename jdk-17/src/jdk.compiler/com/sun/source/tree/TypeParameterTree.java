/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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
import javax.lang.model.element.Name;

/**
 * A tree node for a type parameter.
 *
 * For example:
 * <pre>
 *   <em>name</em>
 *
 *   <em>name</em> extends <em>bounds</em>
 *
 *   <em>annotations</em> <em>name</em>
 * </pre>
 *
 * @jls 4.4 Type Variables
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface TypeParameterTree extends Tree {
    /**
     * Returns the name of the type parameter.
     * @return the name
     */
    Name getName();

    /**
     * Returns the bounds of the type parameter.
     * @return the bounds
     */
    List<? extends Tree> getBounds();

    /**
     * Returns annotations on the type parameter declaration.
     *
     * Annotations need Target meta-annotations of
     * {@link java.lang.annotation.ElementType#TYPE_PARAMETER} or
     * {@link java.lang.annotation.ElementType#TYPE_USE}
     * to appear in this position.
     *
     * @return annotations on the type parameter declaration
     * @since 1.8
     */
    List<? extends AnnotationTree> getAnnotations();
}
