/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.code;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaValue;
import jdk.vm.ci.meta.PlatformKind;
import jdk.vm.ci.meta.Value;

/**
 * Utility class for working with the {@link Value} class and its subclasses.
 */
public final class ValueUtil {

    public static boolean isIllegal(Value value) {
        assert value != null;
        return Value.ILLEGAL.equals(value);
    }

    public static boolean isIllegalJavaValue(JavaValue value) {
        assert value != null;
        return Value.ILLEGAL.equals(value);
    }

    public static boolean isLegal(Value value) {
        return !isIllegal(value);
    }

    public static boolean isVirtualObject(JavaValue value) {
        assert value != null;
        return value instanceof VirtualObject;
    }

    public static VirtualObject asVirtualObject(JavaValue value) {
        assert value != null;
        return (VirtualObject) value;
    }

    public static boolean isConstantJavaValue(JavaValue value) {
        assert value != null;
        return value instanceof JavaConstant;
    }

    public static JavaConstant asConstantJavaValue(JavaValue value) {
        assert value != null;
        return (JavaConstant) value;
    }

    public static boolean isAllocatableValue(Value value) {
        assert value != null;
        return value instanceof AllocatableValue;
    }

    public static AllocatableValue asAllocatableValue(Value value) {
        assert value != null;
        return (AllocatableValue) value;
    }

    public static boolean isStackSlot(Value value) {
        assert value != null;
        return value instanceof StackSlot;
    }

    public static StackSlot asStackSlot(Value value) {
        assert value != null;
        return (StackSlot) value;
    }

    public static boolean isRegister(Value value) {
        assert value != null;
        return value instanceof RegisterValue;
    }

    public static Register asRegister(Value value) {
        return asRegisterValue(value).getRegister();
    }

    public static RegisterValue asRegisterValue(Value value) {
        assert value != null;
        return (RegisterValue) value;
    }

    public static Register asRegister(Value value, PlatformKind kind) {
        if (value.getPlatformKind() != kind) {
            throw new InternalError("needed: " + kind + " got: " + value.getPlatformKind());
        } else {
            return asRegister(value);
        }
    }
}
