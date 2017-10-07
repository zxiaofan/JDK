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

import jdk.nashorn.internal.runtime.Source;

final class LineMapImpl implements LineMap {
    private final Source source;

    LineMapImpl(final Source source) {
        this.source = source;
    }

    @Override
    public long getLineNumber(final long pos) {
        return source.getLine((int)pos);
    }

    @Override
    public long getColumnNumber(final long pos) {
        return source.getColumn((int)pos);
    }
}
