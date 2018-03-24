/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.lir.util;

import org.graalvm.util.Equivalence;
import org.graalvm.util.EconomicMap;

import jdk.vm.ci.meta.Value;

public final class GenericValueMap<T> extends ValueMap<Value, T> {

    private final EconomicMap<Value, T> data;

    public GenericValueMap() {
        data = EconomicMap.create(Equivalence.DEFAULT);
    }

    @Override
    public T get(Value value) {
        return data.get(value);
    }

    @Override
    public void remove(Value value) {
        data.removeKey(value);
    }

    @Override
    public void put(Value value, T object) {
        data.put(value, object);
    }

}
