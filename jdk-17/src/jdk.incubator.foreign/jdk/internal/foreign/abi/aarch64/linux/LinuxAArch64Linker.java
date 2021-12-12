/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2019, 2021, Arm Limited. All rights reserved.
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
package jdk.internal.foreign.abi.aarch64.linux;

import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.internal.foreign.AbstractCLinker;
import jdk.internal.foreign.ResourceScopeImpl;
import jdk.internal.foreign.abi.SharedUtils;
import jdk.internal.foreign.abi.UpcallStubs;
import jdk.internal.foreign.abi.aarch64.CallArranger;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * ABI implementation based on ARM document "Procedure Call Standard for
 * the ARM 64-bit Architecture".
 */
public final class LinuxAArch64Linker extends AbstractCLinker {
    private static LinuxAArch64Linker instance;

    static final long ADDRESS_SIZE = 64; // bits

    private static final MethodHandle MH_unboxVaList;
    private static final MethodHandle MH_boxVaList;

    static {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MH_unboxVaList = lookup.findVirtual(VaList.class, "address",
                MethodType.methodType(MemoryAddress.class));
            MH_boxVaList = MethodHandles.insertArguments(lookup.findStatic(LinuxAArch64Linker.class, "newVaListOfAddress",
                MethodType.methodType(VaList.class, MemoryAddress.class, ResourceScope.class)), 1, ResourceScope.globalScope());
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static LinuxAArch64Linker getInstance() {
        if (instance == null) {
            instance = new LinuxAArch64Linker();
        }
        return instance;
    }

    @Override
    public final MethodHandle downcallHandle(MethodType type, FunctionDescriptor function) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(function);
        MethodType llMt = SharedUtils.convertVaListCarriers(type, LinuxAArch64VaList.CARRIER);
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

    public static VaList newVaList(Consumer<VaList.Builder> actions, ResourceScope scope) {
        LinuxAArch64VaList.Builder builder = LinuxAArch64VaList.builder(scope);
        actions.accept(builder);
        return builder.build();
    }

    public static VaList newVaListOfAddress(MemoryAddress ma, ResourceScope scope) {
        return LinuxAArch64VaList.ofAddress(ma, scope);
    }

    public static VaList emptyVaList() {
        return LinuxAArch64VaList.empty();
    }

}
