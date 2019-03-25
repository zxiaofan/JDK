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


package org.graalvm.compiler.debug;

import jdk.vm.ci.meta.JavaMethod;

/**
 * Interface for objects used in Debug {@linkplain DebugContext#context() context} that can provide
 * a {@link JavaMethod}.
 */
public interface JavaMethodContext {
    JavaMethod asJavaMethod();
}
