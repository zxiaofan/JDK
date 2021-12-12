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

import jdk.incubator.foreign.FunctionDescriptor;

import java.lang.invoke.MethodType;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CallingSequence {
    private final MethodType mt;
    private final FunctionDescriptor desc;
    private final boolean isTrivial;

    private final List<Binding> returnBindings;
    private final List<List<Binding>> argumentBindings;

    public CallingSequence(MethodType mt, FunctionDescriptor desc,
                           boolean isTrivial, List<List<Binding>> argumentBindings, List<Binding> returnBindings) {
        this.mt = mt;
        this.desc = desc;
        this.isTrivial = isTrivial;
        this.returnBindings = returnBindings;
        this.argumentBindings = argumentBindings;
    }

    public int argumentCount() {
        return argumentBindings.size();
    }

    public List<Binding> argumentBindings(int i) {
        return argumentBindings.get(i);
    }

    public Stream<Binding> argumentBindings() {
        return argumentBindings.stream().flatMap(List::stream);
    }

    public List<Binding> returnBindings() {
        return returnBindings;
    }

    public String asString() {
        StringBuilder sb = new StringBuilder();

        sb.append("CallingSequence: {\n");
        sb.append("  MethodType: ").append(mt);
        sb.append("  FunctionDescriptor: ").append(desc);
        sb.append("  Argument Bindings:\n");
        for (int i = 0; i < mt.parameterCount(); i++) {
            sb.append("    ").append(i).append(": ").append(argumentBindings.get(i)).append("\n");
        }
        if (mt.returnType() != void.class) {
            sb.append("    ").append("Return: ").append(returnBindings).append("\n");
        }
        sb.append("}\n");

        return sb.toString();
    }

    public MethodType methodType() {
        return mt;
    }

    public FunctionDescriptor functionDesc() {
        return desc;
    }

    public boolean isTrivial() {
        return isTrivial;
    }
}
