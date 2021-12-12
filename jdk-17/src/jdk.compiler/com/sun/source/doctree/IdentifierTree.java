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

import javax.lang.model.element.Name;

/**
 * An identifier in a documentation comment.
 *
 * <pre>
 *    name
 * </pre>
 *
 * @since 1.8
 */
public interface IdentifierTree extends DocTree {
    /**
     * Returns the name of the identifier.
     * @return the name
     */
    Name getName();
}
