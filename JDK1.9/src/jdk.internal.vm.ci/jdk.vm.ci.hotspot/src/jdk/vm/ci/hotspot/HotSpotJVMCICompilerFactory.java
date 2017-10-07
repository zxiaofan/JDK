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

import jdk.vm.ci.runtime.JVMCICompilerFactory;

/**
 * HotSpot extensions to {@link JVMCICompilerFactory}.
 */
public abstract class HotSpotJVMCICompilerFactory implements JVMCICompilerFactory {

    /**
     * Gets 0 or more prefixes identifying classes that should by compiled by C1 in simple mode
     * (i.e., {@code CompLevel_simple}) when HotSpot is running with tiered compilation. The
     * prefixes should be class or package names using "/" as the separator, e.g. "jdk/vm/ci".
     *
     * @return 0 or more Strings identifying packages that should by compiled by the first tier only
     *         or null if no redirection to C1 should be performed.
     */
    public String[] getTrivialPrefixes() {
        return null;
    }

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
     * @param declaringClass the class in which the method is declared
     * @param name the name of the method or {@code null} depending on the value that was returned
     *            by {@link #getCompilationLevelAdjustment()}
     * @param signature the signature of the method or {@code null} depending on the value that was
     *            returned by {@link #getCompilationLevelAdjustment()}
     * @param isOsr specifies if the compilation being scheduled in an OSR compilation
     * @param level the compilation level currently selected by the VM compilation policy
     * @return the compilation level to use for the compilation being scheduled (must be a valid
     *         {@code CompLevel} enum value)
     */
    public CompilationLevel adjustCompilationLevel(Class<?> declaringClass, String name, String signature, boolean isOsr, CompilationLevel level) {
        throw new InternalError("Should not reach here");
    }
}
