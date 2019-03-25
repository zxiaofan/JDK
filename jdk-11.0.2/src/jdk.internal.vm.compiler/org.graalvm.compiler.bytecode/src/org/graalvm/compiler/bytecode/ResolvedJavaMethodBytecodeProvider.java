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

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * {@link BytecodeProvider} that returns {@link ResolvedJavaMethodBytecode} objects.
 */
public class ResolvedJavaMethodBytecodeProvider implements BytecodeProvider {

    /**
     * A state-less, shared {@link ResolvedJavaMethodBytecodeProvider} instance.
     */
    public static final ResolvedJavaMethodBytecodeProvider INSTANCE = new ResolvedJavaMethodBytecodeProvider();

    @Override
    public Bytecode getBytecode(ResolvedJavaMethod method) {
        return new ResolvedJavaMethodBytecode(method, this);
    }

    @Override
    public boolean supportsInvokedynamic() {
        return true;
    }

    @Override
    public boolean shouldRecordMethodDependencies() {
        return true;
    }
}
