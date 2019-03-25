/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot;

import jdk.vm.ci.hotspot.HotSpotJVMCICompilerFactory;

/**
 * Determines if a given class is a JVMCI or Graal class for the purpose of
 * {@link HotSpotGraalCompilerFactory.Options#CompileGraalWithC1Only}.
 */
public class IsGraalPredicate {
    /**
     * Module containing {@link HotSpotJVMCICompilerFactory}.
     */
    private final Module jvmciModule;

    /**
     * Module containing {@link HotSpotGraalCompilerFactory}.
     */
    private final Module graalModule;

    /**
     * Module containing the {@linkplain CompilerConfigurationFactory#selectFactory selected}
     * configuration.
     */
    private Module compilerConfigurationModule;

    public IsGraalPredicate() {
        jvmciModule = HotSpotJVMCICompilerFactory.class.getModule();
        graalModule = HotSpotGraalCompilerFactory.class.getModule();
    }

    void onCompilerConfigurationFactorySelection(CompilerConfigurationFactory factory) {
        compilerConfigurationModule = factory.getClass().getModule();
    }

    boolean apply(Class<?> declaringClass) {
        Module module = declaringClass.getModule();
        return jvmciModule == module || graalModule == module || compilerConfigurationModule == module;
    }
}
