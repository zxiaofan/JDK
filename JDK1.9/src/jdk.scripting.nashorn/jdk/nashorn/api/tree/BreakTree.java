/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.api.tree;

/**
 * A tree node for a 'break' statement.
 *
 * For example:
 * <pre>
 *   break;
 *
 *   break <em>label</em> ;
 * </pre>
 *
 * @since 9
 */
public interface BreakTree extends GotoTree {
    /**
     * Label associated with this break statement. This is null
     * if there is no label associated with this break statement.
     *
     * @return label associated with this break statement.
     */
    @Override
    String getLabel();
}
