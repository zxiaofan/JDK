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


package org.graalvm.compiler.nodes.graphbuilderconf;

import org.graalvm.compiler.core.common.type.StampPair;

import jdk.vm.ci.meta.JavaType;

/**
 * Plugin for overriding types in the bytecode parser. This can be used to modify the standard
 * behavior of Java type resolution, e.g. to introduce trusted interface types with special
 * semantics.
 */
public interface TypePlugin extends GraphBuilderPlugin {

    /**
     * Intercept the type of arguments or return values.
     */
    StampPair interceptType(GraphBuilderTool b, JavaType declaredType, boolean nonNull);
}
