/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Represents a request to compile a method.
 */
public class CompilationRequest {

    private final ResolvedJavaMethod method;

    private final int entryBCI;

    /**
     * Creates a request to compile a method starting at its entry point.
     *
     * @param method the method to be compiled
     */
    public CompilationRequest(ResolvedJavaMethod method) {
        this(method, -1);
    }

    /**
     * Creates a request to compile a method starting at a given BCI.
     *
     * @param method the method to be compiled
     * @param entryBCI the bytecode index (BCI) at which to start compiling where -1 denotes the
     *            method's entry point
     */
    public CompilationRequest(ResolvedJavaMethod method, int entryBCI) {
        assert method != null;
        this.method = method;
        this.entryBCI = entryBCI;
    }

    /**
     * Gets the method to be compiled.
     */
    public ResolvedJavaMethod getMethod() {
        return method;
    }

    /**
     * Gets the bytecode index (BCI) at which to start compiling where -1 denotes a non-OSR
     * compilation request and all other values denote an on stack replacement (OSR) compilation
     * request.
     */
    public int getEntryBCI() {
        return entryBCI;
    }

    @Override
    public String toString() {
        return method.format("%H.%n(%p)@" + entryBCI);
    }
}
