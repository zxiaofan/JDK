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

import jdk.vm.ci.code.CompilationRequest;
import jdk.vm.ci.code.CompilationRequestResult;

public interface JVMCICompiler {
    int INVOCATION_ENTRY_BCI = -1;

    /**
     * Services a compilation request. This object should compile the method to machine code and
     * install it in the code cache if the compilation is successful.
     */
    CompilationRequestResult compileMethod(CompilationRequest request);

    /**
     * Determines if this compiler supports the {@code gcIdentifier} garbage collector. The default
     * implementation of this method returns true as that is the effective answer given by a
     * {@link JVMCICompiler} before this method was added.
     *
     * @param gcIdentifier a VM dependent GC identifier
     */
    default boolean isGCSupported(int gcIdentifier) {
        return true;
    }
}
