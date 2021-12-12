/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.foreign.abi;

import jdk.internal.invoke.VMStorageProxy;

import java.util.Objects;

public class VMStorage implements VMStorageProxy {
    private final int type;
    private final int index;

    private final String debugName;

    public VMStorage(int type, int index, String debugName) {
        this.type = type;
        this.index = index;
        this.debugName = debugName;
    }

    public int type() {
        return type;
    }

    public int index() {
        return index;
    }

    public String name() {
        return debugName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VMStorage vmStorage = (VMStorage) o;
        return type == vmStorage.type &&
                index == vmStorage.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, index);
    }

    @Override
    public String toString() {
        return "VMStorage{" +
                "type=" + type +
                ", index=" + index +
                ", debugName='" + debugName + '\'' +
                '}';
    }
}
