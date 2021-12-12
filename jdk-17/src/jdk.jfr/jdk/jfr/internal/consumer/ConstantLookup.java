/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.consumer;

import jdk.jfr.internal.Type;

final class ConstantLookup {
    private final Type type;
    private ConstantMap current;
    private ConstantMap previous = ConstantMap.EMPTY;

    ConstantLookup(ConstantMap current, Type type) {
        this.current = current;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public ConstantMap getLatestPool() {
        return current;
    }

    public void newPool() {
        previous = current;
        current = new ConstantMap(current.factory, current.name);
    }

    public Object getPreviousResolved(long key) {
        return previous.getResolved(key);
    }

    public Object getCurrentResolved(long key) {
        return current.getResolved(key);
    }

    public Object getCurrent(long key) {
        return current.get(key);
    }
}
