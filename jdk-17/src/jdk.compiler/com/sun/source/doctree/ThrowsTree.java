/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for an {@code @exception} or {@code @throws} block tag.
 * {@code @exception} is a synonym for {@code @throws}.
 *
 * <pre>
 *    &#064;exception class-name description
 *    &#064;throws class-name description
 * </pre>
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
