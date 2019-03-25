/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
import jdk.vm.ci.common.JVMCIError;
import jdk.vm.ci.hotspot.HotSpotJVMCIRuntime.Option;
import jdk.vm.ci.runtime.JVMCICompiler;
import jdk.vm.ci.runtime.JVMCICompilerFactory;
import jdk.vm.ci.runtime.JVMCIRuntime;
import jdk.vm.ci.services.JVMCIPermission;
import jdk.vm.ci.services.JVMCIServiceLocator;
import jdk.vm.ci.services.internal.ReflectionAccessJDK;

final class HotSpotJVMCICompilerConfig {

    /**
     * This factory allows JVMCI initialization to succeed but raises an error if the VM asks JVMCI
     * to perform a compilation. This allows the reflective parts of the JVMCI API to be used
     * without requiring a compiler implementation to be available.
     */
    private static class DummyCompilerFactory implements JVMCICompilerFactory, JVMCICompiler {

        @Override
        public HotSpotCompilationRequestResult compileMethod(CompilationRequest request) {
            throw new JVMCIError("no JVMCI compiler selected");
        }

        @Override
        public String getCompilerName() {
            return "null";
        }

        @Override
        public JVMCICompiler createCompiler(JVMCIRuntime runtime) {
            return this;
        }
    }

    /**
     * Factory of the selected system compiler.
     */
    private static JVMCICompilerFactory compilerFactory;

    /**
     * Gets the selected system compiler factory.
     *
     * @return the selected system compiler factory
     * @throws SecurityException if a security manager is present and it denies
     *             {@link JVMCIPermission} for any {@link JVMCIServiceLocator} loaded by this method
     */
    static JVMCICompilerFactory getCompilerFactory() {
        if (compilerFactory == null) {
            JVMCICompilerFactory factory = null;
            String compilerName = Option.Compiler.getString();
            if (compilerName != null) {
                if (compilerName.isEmpty() || compilerName.equals("null")) {
                    factory = new DummyCompilerFactory();
                } else {
                    for (JVMCICompilerFactory f : JVMCIServiceLocator.getProviders(JVMCICompilerFactory.class)) {
                        if (f.getCompilerName().equals(compilerName)) {
                            factory = f;
                        }
                    }
                    if (factory == null) {
                        throw new JVMCIError("JVMCI compiler '%s' not found", compilerName);
                    }
                }
            } else {
                // Auto select a single available compiler
                for (JVMCICompilerFactory f : JVMCIServiceLocator.getProviders(JVMCICompilerFactory.class)) {
                    if (factory == null) {
                        ReflectionAccessJDK.openJVMCITo(f.getClass());
                        factory = f;
                    } else {
                        // Multiple factories seen - cancel auto selection
                        factory = null;
                        break;
                    }
                }
                if (factory == null) {
                    factory = new DummyCompilerFactory();
                }
            }
            factory.onSelection();
            compilerFactory = factory;
        }
        return compilerFactory;
    }
}
