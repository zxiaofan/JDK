/*
 *  Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 *  ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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

import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryLayout;
import sun.security.action.GetPropertyAction;

import java.lang.invoke.MethodType;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static jdk.internal.foreign.abi.Binding.Tag.*;

public class CallingSequenceBuilder {
    private static final boolean VERIFY_BINDINGS = Boolean.parseBoolean(
            GetPropertyAction.privilegedGetProperty("jdk.incubator.foreign.VERIFY_BINDINGS", "true"));

    private boolean isTrivial;
    private final boolean forUpcall;
    private final List<List<Binding>> inputBindings = new ArrayList<>();
    private List<Binding> outputBindings = List.of();

    private MethodType mt = MethodType.methodType(void.class);
    private FunctionDescriptor desc = FunctionDescriptor.ofVoid();

    public CallingSequenceBuilder(boolean forUpcall) {
        this.forUpcall = forUpcall;
    }

    public final CallingSequenceBuilder addArgumentBindings(Class<?> carrier, MemoryLayout layout,
                                                            List<Binding> bindings) {
        verifyBindings(true, carrier, bindings);
        inputBindings.add(bindings);
        mt = mt.appendParameterTypes(carrier);
        desc = desc.withAppendedArgumentLayouts(layout);
        return this;
    }

    public CallingSequenceBuilder setReturnBindings(Class<?> carrier, MemoryLayout layout,
                                                    List<Binding> bindings) {
        verifyBindings(false, carrier, bindings);
        this.outputBindings = bindings;
        mt = mt.changeReturnType(carrier);
        desc = desc.withReturnLayout(layout);
        return this;
    }

    public CallingSequenceBuilder setTrivial(boolean isTrivial) {
        this.isTrivial = isTrivial;
        return this;
    }

    public CallingSequence build() {
        return new CallingSequence(mt, desc, isTrivial, inputBindings, outputBindings);
    }

    private void verifyBindings(boolean forArguments, Class<?> carrier, List<Binding> bindings) {
        if (VERIFY_BINDINGS) {
            if (forUpcall == forArguments) {
                verifyBoxBindings(carrier, bindings);
            } else {
                verifyUnboxBindings(carrier, bindings);
            }
        }
    }

    private static final Set<Binding.Tag> UNBOX_TAGS = EnumSet.of(
        VM_STORE,
        //VM_LOAD,
        //BUFFER_STORE,
        BUFFER_LOAD,
        COPY_BUFFER,
        //ALLOC_BUFFER,
        //BOX_ADDRESS,
        UNBOX_ADDRESS,
        BASE_ADDRESS,
        //TO_SEGMENT,
        DUP
    );

    private static void verifyUnboxBindings(Class<?> inType, List<Binding> bindings) {
        Deque<Class<?>> stack = new ArrayDeque<>();
        stack.push(inType);

        for (Binding b : bindings) {
            if (!UNBOX_TAGS.contains(b.tag()))
                throw new IllegalArgumentException("Unexpected operator: " + b);
            b.verify(stack);
        }

        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("Stack must be empty after recipe");
        }
    }

    private static final Set<Binding.Tag> BOX_TAGS = EnumSet.of(
        //VM_STORE,
        VM_LOAD,
        BUFFER_STORE,
        //BUFFER_LOAD,
        COPY_BUFFER,
        ALLOC_BUFFER,
        BOX_ADDRESS,
        //UNBOX_ADDRESS,
        //BASE_ADDRESS,
        TO_SEGMENT,
        DUP
    );

    private static void verifyBoxBindings(Class<?> expectedOutType, List<Binding> bindings) {
        Deque<Class<?>> stack = new ArrayDeque<>();

        for (Binding b : bindings) {
            if (!BOX_TAGS.contains(b.tag()))
                throw new IllegalArgumentException("Unexpected operator: " + b);
            b.verify(stack);
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Stack must contain exactly 1 value");
        }

        Class<?> actualOutType = stack.pop();
        SharedUtils.checkType(actualOutType, expectedOutType);
    }
}
