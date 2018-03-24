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

public abstract class DisposerManagedResource<T> extends ManagedResource<T> {
    Object referent;

    public DisposerManagedResource(T resource, ResourcePool pool,
                                   Disposer.Record record)
    {
        super(resource, pool);
        this.referent = new Object();
        Disposer.addRecord(referent, record);
    }
}
