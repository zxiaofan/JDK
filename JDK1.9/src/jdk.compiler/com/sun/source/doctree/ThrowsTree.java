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
 *
 * A tree node for an @exception or &#064;throws block tag.
 * &#064;exception is a synonym for &#064;throws.
 *
 * <p>
 * &#064;exception class-name description <br>
 * &#064;throws class-name description
 *
 * @since 1.8
 */
public interface ThrowsTree extends BlockTagTree {
    /**
     * Returns the name of the exception being documented.
     * @return the name of the exception
     */
    ReferenceTree getExceptionName();

    /**
     * Returns a description of the reasons why the
     * exception may be thrown.
     * @return the description
     */
    List<? extends DocTree> getDescription();
}
