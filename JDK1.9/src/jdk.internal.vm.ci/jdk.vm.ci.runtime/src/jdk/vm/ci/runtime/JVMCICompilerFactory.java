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
package jdk.vm.ci.runtime;

import java.io.PrintStream;

/**
 * Factory for creating JVMCI compilers.
 */
public interface JVMCICompilerFactory {

    /**
     * Get the name of this compiler. The name is used by JVMCI to determine which factory to use.
     */
    String getCompilerName();

    /**
     * Notifies this object that it has been selected to {@linkplain #createCompiler(JVMCIRuntime)
     * create} a compiler and it should now perform any heavy weight initialization that it deferred
     * during construction.
     */
    default void onSelection() {
    }

    /**
     * Create a new instance of a {@link JVMCICompiler}.
     */
    JVMCICompiler createCompiler(JVMCIRuntime runtime);

    /**
     * Prints a description of the properties used to configure this compiler.
     *
     * @param out where to print the message
     */
    default void printProperties(PrintStream out) {
    }
}
