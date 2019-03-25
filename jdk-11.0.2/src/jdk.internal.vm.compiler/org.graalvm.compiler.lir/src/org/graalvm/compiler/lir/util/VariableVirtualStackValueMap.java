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

import static org.graalvm.compiler.lir.LIRValueUtil.asVariable;
import static org.graalvm.compiler.lir.LIRValueUtil.asVirtualStackSlot;
import static org.graalvm.compiler.lir.LIRValueUtil.isVariable;
import static org.graalvm.compiler.lir.LIRValueUtil.isVirtualStackSlot;

import org.graalvm.compiler.debug.GraalError;

import jdk.vm.ci.meta.Value;

public class VariableVirtualStackValueMap<K extends Value, T> extends ValueMap<K, T> {

    private final Object[] variables;
    private final Object[] slots;

    public VariableVirtualStackValueMap(int initialVariableCapacity, int initialStackSlotCapacity) {
        variables = new Object[initialVariableCapacity];
        slots = new Object[initialStackSlotCapacity];
    }

    @Override
    public T get(K value) {
        if (isVariable(value)) {
            return get(variables, asVariable(value).index);
        }
        if (isVirtualStackSlot(value)) {
            return get(slots, asVirtualStackSlot(value).getId());
        }
        throw GraalError.shouldNotReachHere("Unsupported Value: " + value);
    }

    @Override
    public void remove(K value) {
        if (isVariable(value)) {
            remove(variables, asVariable(value).index);
        } else if (isVirtualStackSlot(value)) {
            remove(slots, asVirtualStackSlot(value).getId());
        } else {
            throw GraalError.shouldNotReachHere("Unsupported Value: " + value);
        }
    }

    @Override
    public void put(K value, T object) {
        if (isVariable(value)) {
            put(variables, asVariable(value).index, object);
        } else if (isVirtualStackSlot(value)) {
            put(slots, asVirtualStackSlot(value).getId(), object);
        } else {
            throw GraalError.shouldNotReachHere("Unsupported Value: " + value);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T get(Object[] array, int index) {
        if (index >= array.length) {
            return null;
        }
        return (T) array[index];
    }

    private static void remove(Object[] array, int index) {
        if (index >= array.length) {
            return;
        }
        array[index] = null;
    }

    private static <T> Object[] put(Object[] array, int index, T object) {
        if (index >= array.length) {
            Object[] newArray = new Object[index + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[index] = object;
            return newArray;
        }
        array[index] = object;
        return null;
    }
}
