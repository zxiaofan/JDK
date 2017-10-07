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
package jdk.vm.ci.hotspot;

import jdk.vm.ci.code.CompilationRequest;

/**
 * A compilation request with extra HotSpot specific context such as a compilation identifier and
 * the address of a {@code JVMCIEnv} object that provides native context for a compilation.
 */
public class HotSpotCompilationRequest extends CompilationRequest {
    private final long jvmciEnv;
    private final int id;

    /**
     * Creates a request to compile a method starting at a given BCI and allocates an identifier to
     * the request.
     *
     * @param method the method to be compiled
     * @param entryBCI the bytecode index (BCI) at which to start compiling where -1 denotes the
     *            method's entry point
     * @param jvmciEnv address of a native {@code JVMCIEnv} object or 0L
     */
    public HotSpotCompilationRequest(HotSpotResolvedJavaMethod method, int entryBCI, long jvmciEnv) {
        this(method, entryBCI, jvmciEnv, method.allocateCompileId(entryBCI));
    }

    /**
     * Creates a request to compile a method starting at a given BCI.
     *
     * @param method the method to be compiled
     * @param entryBCI the bytecode index (BCI) at which to start compiling where -1 denotes the
     *            method's entry point
     * @param jvmciEnv address of a native {@code JVMCIEnv} object or 0L
     * @param id an identifier for the request
     */
    public HotSpotCompilationRequest(HotSpotResolvedJavaMethod method, int entryBCI, long jvmciEnv, int id) {
        super(method, entryBCI);
        this.jvmciEnv = jvmciEnv;
        this.id = id;
    }

    @Override
    public HotSpotResolvedJavaMethod getMethod() {
        return (HotSpotResolvedJavaMethod) super.getMethod();
    }

    /**
     * Gets the address of the native {@code JVMCIEnv} object or 0L if no such object exists.
     */
    public long getJvmciEnv() {
        return jvmciEnv;
    }

    /**
     * Gets the VM allocated identifier for this compilation.
     */
    public int getId() {
        return id;
    }

}
