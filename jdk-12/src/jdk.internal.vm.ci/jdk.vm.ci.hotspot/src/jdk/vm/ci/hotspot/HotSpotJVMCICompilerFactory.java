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
package jdk.vm.ci.hotspot;

import jdk.vm.ci.meta.JavaType;
import jdk.vm.ci.runtime.JVMCICompilerFactory;

/**
 * HotSpot extensions to {@link JVMCICompilerFactory}.
 */
public abstract class HotSpotJVMCICompilerFactory implements JVMCICompilerFactory {

    public enum CompilationLevelAdjustment {
        /**
         * No adjustment.
         */
        None,

        /**
         * Adjust based on declaring class of method.
         */
        ByHolder,

        /**
         * Adjust based on declaring class, name and signature of method.
         */
        ByFullSignature
    }

    /**
     * Determines if this object may want to adjust the compilation level for a method that is being
     * scheduled by the VM for compilation.
     */
    public CompilationLevelAdjustment getCompilationLevelAdjustment() {
        return CompilationLevelAdjustment.None;
    }

    public enum CompilationLevel {
        None,
        Simple,
        LimitedProfile,
        FullProfile,
        FullOptimization
    }

    /**
     * Potentially modifies the compilation level currently selected by the VM compilation policy
     * for a method.
     *
     * @param declaringClass the class in which the method is declared. This value is either a
     *            {@code Class} instance or a {@code String} representing the
     *            {@link JavaType#toJavaName() name} of the class.
     * @param name the name of the method or {@code null} depending on the value that was returned
     *            by {@link #getCompilationLevelAdjustment()}
     * @param signature the signature of the method or {@code null} depending on the value that was
     *            returned by {@link #getCompilationLevelAdjustment()}
     * @param isOsr specifies if the compilation being scheduled in an OSR compilation
     * @param level the compilation level currently selected by the VM compilation policy
     * @return the compilation level to use for the compilation being scheduled (must be a valid
     *         {@code CompLevel} enum value)
     */
    public CompilationLevel adjustCompilationLevel(Object declaringClass, String name, String signature, boolean isOsr, CompilationLevel level) {
        throw new InternalError(getClass().getName() + " must override adjustCompilationLevel(...) since it returned a value other than " + CompilationLevel.class.getName() + "." +
                        CompilationLevel.None + " from getCompilationLevelAdjustment()");
    }
}
