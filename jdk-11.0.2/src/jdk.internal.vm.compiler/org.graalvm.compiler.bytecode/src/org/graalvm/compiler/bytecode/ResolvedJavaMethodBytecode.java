/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.bytecode;

import jdk.vm.ci.meta.ConstantPool;
import jdk.vm.ci.meta.ExceptionHandler;
import jdk.vm.ci.meta.LineNumberTable;
import jdk.vm.ci.meta.LocalVariableTable;
import jdk.vm.ci.meta.ProfilingInfo;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Direct access to the bytecode of a {@link ResolvedJavaMethod} that will reflect any
 * instrumentation and rewriting performed on the {@link ResolvedJavaMethod}.
 */
public class ResolvedJavaMethodBytecode implements Bytecode {

    private final ResolvedJavaMethod method;
    private final BytecodeProvider origin;

    public ResolvedJavaMethodBytecode(ResolvedJavaMethod method) {
        this(method, ResolvedJavaMethodBytecodeProvider.INSTANCE);
    }

    public ResolvedJavaMethodBytecode(ResolvedJavaMethod method, BytecodeProvider origin) {
        this.method = method;
        this.origin = origin;
    }

    @Override
    public BytecodeProvider getOrigin() {
        return origin;
    }

    @Override
    public ResolvedJavaMethod getMethod() {
        return method;
    }

    @Override
    public byte[] getCode() {
        return method.getCode();
    }

    @Override
    public int getCodeSize() {
        return method.getCodeSize();
    }

    @Override
    public int getMaxStackSize() {
        return method.getMaxStackSize();
    }

    @Override
    public int getMaxLocals() {
        return method.getMaxLocals();
    }

    @Override
    public ConstantPool getConstantPool() {
        return method.getConstantPool();
    }

    @Override
    public LineNumberTable getLineNumberTable() {
        return method.getLineNumberTable();
    }

    @Override
    public LocalVariableTable getLocalVariableTable() {
        return method.getLocalVariableTable();
    }

    @Override
    public ExceptionHandler[] getExceptionHandlers() {
        return method.getExceptionHandlers();
    }

    @Override
    public StackTraceElement asStackTraceElement(int bci) {
        return method.asStackTraceElement(bci);
    }

    @Override
    public ProfilingInfo getProfilingInfo() {
        return method.getProfilingInfo();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + method.format("<%h.%n(%p)>");
    }
}
