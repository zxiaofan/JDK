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
 * A tree node for a {@code continue} statement.
 *
 * For example:
 * <pre>
 *   continue;
 *   continue <em>label</em> ;
 * </pre>
 *
 * @jls 14.16 The continue Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ContinueTree extends StatementTree {
    /**
     * Returns the label for this {@code continue} statement.
     * @return the label
     */
    Name getLabel();
}
