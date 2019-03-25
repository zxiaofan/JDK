/*
 * Copyright (c) 2009, 2010, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.beans.finder;

import java.beans.PersistenceDelegate;
import java.util.HashMap;
import java.util.Map;

/**
 * This is utility class that provides functionality
 * to find a {@link PersistenceDelegate} for a JavaBean specified by its type.
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
public final class PersistenceDelegateFinder
        extends InstanceFinder<PersistenceDelegate> {

    private final Map<Class<?>, PersistenceDelegate> registry;

    public PersistenceDelegateFinder() {
        super(PersistenceDelegate.class, true, "PersistenceDelegate");
        this.registry = new HashMap<Class<?>, PersistenceDelegate>();
    }

    public void register(Class<?> type, PersistenceDelegate delegate) {
        synchronized (this.registry) {
            if (delegate != null) {
                this.registry.put(type, delegate);
            }
            else {
                this.registry.remove(type);
            }
        }
    }

    @Override
    public PersistenceDelegate find(Class<?> type) {
        PersistenceDelegate delegate;
        synchronized (this.registry) {
            delegate = this.registry.get(type);
        }
        return (delegate != null) ? delegate : super.find(type);
    }
}
