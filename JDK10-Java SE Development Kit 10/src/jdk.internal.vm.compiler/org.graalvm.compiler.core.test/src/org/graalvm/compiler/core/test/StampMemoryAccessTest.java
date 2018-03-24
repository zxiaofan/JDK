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
package org.graalvm.compiler.core.test;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.junit.Ignore;
import org.junit.Test;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.MemoryAccessProvider;

/**
 *
 */
public class StampMemoryAccessTest extends GraalCompilerTest {

    @Ignore("not all JVMCI versions are safe yet")
    @Test
    public void testReadPrimitive() {
        MemoryAccessProvider memory = getConstantReflection().getMemoryAccessProvider();
        JavaConstant base = getSnippetReflection().forObject("");
        Stamp stamp = StampFactory.forKind(JavaKind.Long);
        assertTrue(stamp.readConstant(memory, base, 128) == null);
    }

    @Ignore("not all JVMCI versions are safe yet")
    @Test
    public void testReadObject() {
        MemoryAccessProvider memory = getConstantReflection().getMemoryAccessProvider();
        JavaConstant base = getSnippetReflection().forObject("");
        Stamp stamp = StampFactory.forKind(JavaKind.Object);
        assertTrue(stamp.readConstant(memory, base, 128) == null);
    }
}
