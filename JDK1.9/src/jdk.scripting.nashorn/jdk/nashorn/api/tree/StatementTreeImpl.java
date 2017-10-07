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

import jdk.nashorn.internal.ir.Block;
import jdk.nashorn.internal.ir.Statement;

abstract class StatementTreeImpl extends TreeImpl implements StatementTree {
    StatementTreeImpl(final Statement stat) {
        super(stat);
    }

    StatementTreeImpl(final Block stat) {
        super(stat);
    }
}
