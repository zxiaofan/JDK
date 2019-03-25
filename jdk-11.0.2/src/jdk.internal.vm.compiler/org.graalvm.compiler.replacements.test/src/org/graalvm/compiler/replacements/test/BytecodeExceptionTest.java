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


package org.graalvm.compiler.replacements.test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.UnwindNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.BytecodeExceptionNode;
import org.graalvm.compiler.nodes.extended.BytecodeExceptionNode.BytecodeExceptionKind;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;

public abstract class BytecodeExceptionTest extends GraalCompilerTest {

    protected boolean throwBytecodeException(GraphBuilderContext b, BytecodeExceptionKind exception, ValueNode... arguments) {
        BytecodeExceptionNode exceptionNode = b.add(new BytecodeExceptionNode(b.getMetaAccess(), exception, arguments));
        b.add(new UnwindNode(exceptionNode));
        return true;
    }
}
