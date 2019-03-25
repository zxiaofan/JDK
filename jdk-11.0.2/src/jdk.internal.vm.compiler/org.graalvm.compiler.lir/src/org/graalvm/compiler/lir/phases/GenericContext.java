/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.lir.phases;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Allows storing of arbitrary data.
 */
public class GenericContext {

    private ArrayList<Object> context;

    public GenericContext() {
        context = null;
    }

    public <T> void contextAdd(T obj) {
        if (context == null) {
            context = new ArrayList<>();
        }
        context.add(obj);
    }

    @SuppressWarnings("unchecked")
    public <T> T contextLookup(Class<T> clazz) {
        if (context != null) {
            for (Object e : context) {
                if (clazz.isInstance(e)) {
                    return (T) e;
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T> T contextRemove(Class<T> clazz) {
        if (context != null) {
            ListIterator<Object> it = context.listIterator();
            while (it.hasNext()) {
                Object e = it.next();
                if (clazz.isInstance(e)) {
                    // remove entry
                    it.remove();
                    if (context.isEmpty()) {
                        context = null;
                    }
                    return (T) e;
                }
            }
        }
        return null;
    }
}
