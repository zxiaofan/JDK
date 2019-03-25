/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core;

import static org.graalvm.compiler.core.GraalCompilerOptions.PrintCompilation;
import static org.graalvm.compiler.serviceprovider.GraalServices.getCurrentThreadAllocatedBytes;
import static org.graalvm.compiler.serviceprovider.GraalServices.isThreadAllocatedMemorySupported;

import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.core.common.CompilationIdentifier;
import org.graalvm.compiler.debug.TTY;
import org.graalvm.compiler.options.OptionValues;

import jdk.vm.ci.meta.JavaMethod;
import jdk.vm.ci.runtime.JVMCICompiler;

/**
 * Utility for printing an informational line to {@link TTY} upon completion of compiling a method.
 */
public final class CompilationPrinter {

    private final CompilationIdentifier id;
    private final JavaMethod method;
    private final int entryBCI;
    private final long start;
    private final long allocatedBytesBefore;

    /**
     * Gets an object that will report statistics for a compilation if
     * {@link GraalCompilerOptions#PrintCompilation} is enabled and {@link TTY} is not suppressed.
     * This method should be called just before a compilation starts as it captures pre-compilation
     * data for the purpose of {@linkplain #finish(CompilationResult) printing} the post-compilation
     * statistics.
     *
     * @param options used to get the value of {@link GraalCompilerOptions#PrintCompilation}
     * @param id the identifier for the compilation
     * @param method the method for which code is being compiled
     * @param entryBCI the BCI at which compilation starts
     */
    public static CompilationPrinter begin(OptionValues options, CompilationIdentifier id, JavaMethod method, int entryBCI) {
        if (PrintCompilation.getValue(options) && !TTY.isSuppressed()) {
            return new CompilationPrinter(id, method, entryBCI);
        }
        return DISABLED;
    }

    private static final CompilationPrinter DISABLED = new CompilationPrinter();

    private CompilationPrinter() {
        this.method = null;
        this.id = null;
        this.entryBCI = -1;
        this.start = -1;
        this.allocatedBytesBefore = -1;
    }

    private CompilationPrinter(CompilationIdentifier id, JavaMethod method, int entryBCI) {
        this.method = method;
        this.id = id;
        this.entryBCI = entryBCI;

        start = System.nanoTime();
        allocatedBytesBefore = isThreadAllocatedMemorySupported() ? getCurrentThreadAllocatedBytes() : -1;
    }

    private String getMethodDescription() {
        return String.format("%-30s %-70s %-45s %-50s %s", id.toString(CompilationIdentifier.Verbosity.ID),
                        method.getDeclaringClass().getName(), method.getName(),
                        method.getSignature().toMethodDescriptor(),
                        entryBCI == JVMCICompiler.INVOCATION_ENTRY_BCI ? "" : "(OSR@" + entryBCI + ") ");
    }

    /**
     * Notifies this object that the compilation finished and the informational line should be
     * printed to {@link TTY}.
     */
    public void finish(CompilationResult result) {
        if (id != null) {
            final long stop = System.nanoTime();
            final long duration = (stop - start) / 1000000;
            final int targetCodeSize = result != null ? result.getTargetCodeSize() : -1;
            final int bytecodeSize = result != null ? result.getBytecodeSize() : 0;
            if (allocatedBytesBefore == -1) {
                TTY.println(getMethodDescription() + String.format(" | %4dms %5dB %5dB", duration, bytecodeSize, targetCodeSize));
            } else {
                final long allocatedBytesAfter = getCurrentThreadAllocatedBytes();
                final long allocatedKBytes = (allocatedBytesAfter - allocatedBytesBefore) / 1024;
                TTY.println(getMethodDescription() + String.format(" | %4dms %5dB %5dB %5dkB", duration, bytecodeSize, targetCodeSize, allocatedKBytes));
            }
        }
    }
}
