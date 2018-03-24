/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.prism.GraphicsResource;

public abstract class BaseGraphicsResource implements GraphicsResource {
    private final Object disposerReferent;
    protected final Disposer.Record disposerRecord;

    public BaseGraphicsResource(BaseGraphicsResource sharedResource) {
        this.disposerReferent = sharedResource.disposerReferent;
        this.disposerRecord = sharedResource.disposerRecord;
    }

    protected BaseGraphicsResource(Disposer.Record disposerRecord) {
        this.disposerReferent = new Object();
        this.disposerRecord = disposerRecord;
        Disposer.addRecord(disposerReferent, disposerRecord);
    }

    @Override
    public abstract void dispose();
}
