/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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
package java.lang.invoke;

import jdk.internal.vm.annotation.DontInline;
import jdk.internal.vm.annotation.ForceInline;
import jdk.internal.vm.annotation.Stable;

import java.lang.invoke.VarHandle.AccessMode;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static java.lang.invoke.MethodHandleNatives.Constants.REF_invokeStatic;

/**
 * A var handle form containing a set of member name, one for each operation.
 * Each member characterizes a static method.
 */
final class VarForm {

    final Class<?> implClass;

    final @Stable MethodType[] methodType_table;

    final @Stable MemberName[] memberName_table;

    VarForm(Class<?> implClass, Class<?> receiver, Class<?> value, Class<?>... intermediate) {
        this.methodType_table = new MethodType[VarHandle.AccessType.COUNT];
        this.memberName_table = new MemberName[VarHandle.AccessMode.COUNT];
        this.implClass = implClass;
        if (receiver == null) {
            initMethodTypes(value, intermediate);
        } else {
            Class<?>[] coordinates = new Class<?>[intermediate.length + 1];
            coordinates[0] = receiver;
            System.arraycopy(intermediate, 0, coordinates, 1, intermediate.length);
            initMethodTypes(value, coordinates);
        }
    }

    // Used by IndirectVarHandle
    VarForm(Class<?> value, Class<?>[] coordinates) {
        this.methodType_table = new MethodType[VarHandle.AccessType.COUNT];
        this.memberName_table = null;
        this.implClass = null;
        initMethodTypes(value, coordinates);
    }

    void initMethodTypes(Class<?> value, Class<?>... coordinates) {
        Class<?> erasedValue = MethodTypeForm.canonicalize(value, MethodTypeForm.ERASE);
        Class<?>[] erasedCoordinates = MethodTypeForm.canonicalizeAll(coordinates, MethodTypeForm.ERASE);

        if (erasedValue != null) {
            value = erasedValue;
        }
        if (erasedCoordinates != null) {
            coordinates = erasedCoordinates;
        }

        MethodType type = MethodType.methodType(value, coordinates);

        // (Receiver, <Intermediates>)Value
        methodType_table[VarHandle.AccessType.GET.ordinal()] = type;

        // (Receiver, <Intermediates>, Value)Value
        type = methodType_table[VarHandle.AccessType.GET_AND_UPDATE.ordinal()] =
                type.appendParameterTypes(value);

        // (Receiver, <Intermediates>, Value)void
        methodType_table[VarHandle.AccessType.SET.ordinal()] = type.changeReturnType(void.class);

        // (Receiver, <Intermediates>, Value, Value)Value
        type = methodType_table[VarHandle.AccessType.COMPARE_AND_EXCHANGE.ordinal()] =
                type.appendParameterTypes(value);

        // (Receiver, <Intermediates>, Value, Value)boolean
        methodType_table[VarHandle.AccessType.COMPARE_AND_SET.ordinal()] =
                type.changeReturnType(boolean.class);
    }

    @ForceInline
    final MethodType getMethodType(int type) {
        return methodType_table[type];
    }

    @ForceInline
    final MemberName getMemberName(int mode) {
        MemberName mn = getMemberNameOrNull(mode);
        if (mn == null) {
            throw new UnsupportedOperationException();
        }
        return mn;
    }

    @ForceInline
    final MemberName getMemberNameOrNull(int mode) {
        MemberName mn = memberName_table[mode];
        if (mn == null) {
            mn = resolveMemberName(mode);
        }
        return mn;
    }

    @DontInline
    MemberName resolveMemberName(int mode) {
        AccessMode value = AccessMode.values()[mode];
        String methodName = value.methodName();
        MethodType type = methodType_table[value.at.ordinal()].insertParameterTypes(0, VarHandle.class);
        return memberName_table[mode] = MethodHandles.Lookup.IMPL_LOOKUP
            .resolveOrNull(REF_invokeStatic, implClass, methodName, type);
    }

    @Stable
    MethodType[] methodType_V_table;

    @ForceInline
    final MethodType[] getMethodType_V_init() {
        MethodType[] table = new MethodType[VarHandle.AccessType.values().length];
        for (int i = 0; i < methodType_table.length; i++) {
            MethodType mt = methodType_table[i];
            // TODO only adjust for sig-poly methods returning Object
            table[i] = mt.changeReturnType(void.class);
        }
        methodType_V_table = table;
        return table;
    }

    @ForceInline
    final MethodType getMethodType_V(int type) {
        MethodType[] table = methodType_V_table;
        if (table == null) {
            table = getMethodType_V_init();
        }
        return table[type];
    }
}
