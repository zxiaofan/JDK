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
 * Provides a {@link Bytecode} object for interposing on the bytecode of a
 * {@link ResolvedJavaMethod} (i.e., potentially getting bytecode different than
 * {@link ResolvedJavaMethod#getCode()}).
 */
public interface BytecodeProvider {

    /**
     * Gets a {@link Bytecode} object that supplies bytecode properties for {@code method}.
     */
    Bytecode getBytecode(ResolvedJavaMethod method);

    /**
     * Determines if this provider supports the INVOKEDYNAMIC bytecode.
     */
    boolean supportsInvokedynamic();

    /**
     * Determines if methods parsed using this provider should be recorded so that method
     * redefinition can invalidate the resulting code.
     */
    boolean shouldRecordMethodDependencies();
}
