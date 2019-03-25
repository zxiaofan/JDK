/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.doctree;

import java.util.List;

/**
 * A tree node for an @param block tag.
 *
 * <p>
 * &#064;param parameter-name description
 *
 * @since 1.8
 */
public interface ParamTree extends BlockTagTree {
    /**
     * Returns true if this is documenting a type parameter.
     * @return true if this is documenting a type parameter
     */
    boolean isTypeParameter();

    /**
     * Returns the name of the parameter.
     * @return the name of the parameter
     */
    IdentifierTree getName();

    /**
     * Returns the description of the parameter.
     * @return the description
     */
    List<? extends DocTree> getDescription();
}
