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

package jdk.internal.invoke;

import java.lang.invoke.MethodType;
import java.util.Objects;

/**
 * This class describes a native call, including arguments/return shuffle moves, PC entry point and
 * various other info which are relevant when the call will be intrinsified by C2.
 */
public class NativeEntryPoint {
    static {
        registerNatives();
    }

    private final int shadowSpace;

    // encoded as VMRegImpl*
    private final long[] argMoves;
    private final long[] returnMoves;

    private final boolean needTransition;
    private final MethodType methodType; // C2 sees erased version (byte -> int), so need this explicitly
    private final String name;

    private NativeEntryPoint(int shadowSpace, long[] argMoves, long[] returnMoves,
                     boolean needTransition, MethodType methodType, String name) {
        this.shadowSpace = shadowSpace;
        this.argMoves = Objects.requireNonNull(argMoves);
        this.returnMoves = Objects.requireNonNull(returnMoves);
        this.needTransition = needTransition;
        this.methodType = methodType;
        this.name = name;
    }

    public static NativeEntryPoint make(String name, ABIDescriptorProxy abi,
                                        VMStorageProxy[] argMoves, VMStorageProxy[] returnMoves,
                                        boolean needTransition, MethodType methodType) {
        if (returnMoves.length > 1) {
            throw new IllegalArgumentException("Multiple register return not supported");
        }

        return new NativeEntryPoint(abi.shadowSpaceBytes(), encodeVMStorages(argMoves), encodeVMStorages(returnMoves),
                needTransition, methodType, name);
    }

    private static long[] encodeVMStorages(VMStorageProxy[] moves) {
        long[] out = new long[moves.length];
        for (int i = 0; i < moves.length; i++) {
            out[i] = vmStorageToVMReg(moves[i].type(), moves[i].index());
        }
        return out;
    }

    private static native long vmStorageToVMReg(int type, int index);

    public MethodType type() {
        return methodType;
    }

    private static native void registerNatives();
}
