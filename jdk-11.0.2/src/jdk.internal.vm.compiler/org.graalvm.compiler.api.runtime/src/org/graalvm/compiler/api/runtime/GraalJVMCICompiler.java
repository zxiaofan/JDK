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


package org.graalvm.compiler.api.runtime;

import jdk.vm.ci.runtime.JVMCICompiler;

/**
 * Graal specific extension of the {@link JVMCICompiler} interface.
 */
public interface GraalJVMCICompiler extends JVMCICompiler {

    GraalRuntime getGraalRuntime();
}
