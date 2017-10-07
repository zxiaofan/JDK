/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.null3d;

import com.sun.prism.impl.BaseGraphicsResource;
import com.sun.prism.impl.Disposer;

class DummyResource extends BaseGraphicsResource {

    public final DummyContext context;

    DummyResource(DummyContext context) {
        super(new DummyRecord());
        this.context = context;
    }

    @Override
    public void dispose() {
    }

    static class DummyRecord implements Disposer.Record {
        public void dispose() {
        }
    }
}
