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
import org.junit.Test;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.MemoryAccessProvider;

/**
 *
 */
public class StampMemoryAccessTest extends GraalCompilerTest {

    @Test
    public void testReadPrimitive() {
        MemoryAccessProvider memory = getConstantReflection().getMemoryAccessProvider();
        Stamp stamp = StampFactory.forKind(JavaKind.Long);
        JavaConstant objectBase = getSnippetReflection().forObject("");
        assertTrue(stamp.readConstant(memory, objectBase, 128) == null);
        JavaConstant arrayBase = getSnippetReflection().forObject(new int[]{});
        assertTrue(stamp.readConstant(memory, arrayBase, 128) == null);
    }

    @Test
    public void testReadObject() {
        MemoryAccessProvider memory = getConstantReflection().getMemoryAccessProvider();
        Stamp stamp = StampFactory.forKind(JavaKind.Object);
        JavaConstant objectBase = getSnippetReflection().forObject("");
        assertTrue(stamp.readConstant(memory, objectBase, 128) == null);
        JavaConstant arrayBase = getSnippetReflection().forObject(new int[]{});
        assertTrue(stamp.readConstant(memory, arrayBase, 128) == null);
    }
}
