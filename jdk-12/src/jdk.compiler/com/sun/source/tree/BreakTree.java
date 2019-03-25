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

import javax.lang.model.element.Name;

/**
 * A tree node for a {@code break} statement.
 *
 * For example:
 * <pre>
 *   break;
 *
 *   break <em>label</em> ;
 *
 *   break <em>expression</em> ;
 * </pre>
 *
 * @jls section 14.15
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface BreakTree extends StatementTree {
    /**
     * Returns the label for this {@code break} statement.
     * @return the label
     */
    Name getLabel();

    /**
     * Returns the expression for this {@code break} statement.
     *
     * @return the expression
     * @since 12
     *
     * @deprecated This method is modeling value breaks, which are part of
     * a preview feature and may be removed if the preview feature
     * is removed.
     *
     */
    @Deprecated(forRemoval=true, since="12")
    ExpressionTree getValue();
}
