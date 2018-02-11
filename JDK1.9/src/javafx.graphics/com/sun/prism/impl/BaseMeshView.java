/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.impl;

import com.sun.prism.MeshView;

/**
 * TODO: 3D - Need documentation
 */
public abstract class BaseMeshView extends BaseGraphicsResource implements MeshView {

    protected BaseMeshView(Disposer.Record disposerRecord) {
        super(disposerRecord);
    }

}
