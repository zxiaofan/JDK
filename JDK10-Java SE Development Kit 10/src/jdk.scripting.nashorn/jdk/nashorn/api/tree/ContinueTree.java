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
 * A tree node for a 'continue' statement.
 *
 * For example:
 * <pre>
 *   continue;
 *   continue <em>label</em> ;
 * </pre>
 *
 * @since 9
 */
public interface ContinueTree extends GotoTree {
    /**
     * Label associated with this continue statement. This is null
     * if there is no label associated with this continue statement.
     *
     * @return label associated with this continue statement.
     */
    @Override
    String getLabel();
}
