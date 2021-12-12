/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.foreign.abi.x64.sysv;


import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.internal.foreign.AbstractCLinker;
import jdk.internal.foreign.ResourceScopeImpl;
import jdk.internal.foreign.abi.SharedUtils;
import jdk.internal.foreign.abi.UpcallStubs;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * ABI implementation based on System V ABI AMD64 supplement v.0.99.6
 */
public final class SysVx64Linker extends AbstractCLinker {
    public static final int MAX_INTEGER_ARGUMENT_REGISTERS = 6;
    public static final int MAX_INTEGER_RETURN_REGISTERS = 2;
    public static final int MAX_VECTOR_ARGUMENT_REGISTERS = 8;
    public static final int MAX_VECTOR_RETURN_REGISTERS = 2;
    public static final int MAX_X87_RETURN_REGISTERS = 2;

    private static SysVx64Linker instance;

    static final long ADDRESS_SIZE = 64; // bits

    private static final MethodHandle MH_unboxVaList;
    private static final MethodHandle MH_boxVaList;

    static {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MH_unboxVaList = lookup.findVirtual(VaList.class, "address",
                MethodType.methodType(MemoryAddress.class));
            MH_boxVaList = MethodHandles.insertArguments(lookup.findStatic(SysVx64Linker.class, "newVaListOfAddress",
                MethodType.methodType(VaList.class, MemoryAddress.class, ResourceScope.class)), 1, ResourceScope.globalScope());
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SysVx64Linker getInstance() {
        if (instance == null) {
            instance = new SysVx64Linker();
        }
        return instance;
    }

    public static VaList newVaList(Consumer<VaList.Builder> actions, ResourceScope scope) {
        SysVVaList.Builder builder = SysVVaList.builder(scope);
        actions.accept(builder);
        return builder.build();
    }

    @Override
    public final MethodHandle downcallHandle(MethodType type, FunctionDescriptor function) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(function);
        MethodType llMt = SharedUtils.convertVaListCarriers(type, SysVVaList.CARRIER);
        MethodHandle handle = CallArranger.arrangeDowncall(llMt, function);
        if (!type.returnType().equals(MemorySegment.class)) {
            // not returning segment, just insert a throwing allocator
            handle = MethodHandles.insertArguments(handle, 1, SharedUtils.THROWING_ALLOCATOR);
        }
        handle = SharedUtils.unboxVaLists(type, handle, MH_unboxVaList);
        return handle;
    }

    @Override
    public final MemoryAddress upcallStub(MethodHandle target, FunctionDescriptor function, ResourceScope scope) {
        Objects.requireNonNull(scope);
        Objects.requireNonNull(target);
        Objects.requireNonNull(function);
        target = SharedUtils.boxVaLists(target, MH_boxVaList);
        return UpcallStubs.upcallAddress(CallArranger.arrangeUpcall(target, target.type(), function), (ResourceScopeImpl) scope);
    }

    public static VaList newVaListOfAddress(MemoryAddress ma, ResourceScope scope) {
        return SysVVaList.ofAddress(ma, scope);
    }

    public static VaList emptyVaList() {
        return SysVVaList.empty();
    }
}
