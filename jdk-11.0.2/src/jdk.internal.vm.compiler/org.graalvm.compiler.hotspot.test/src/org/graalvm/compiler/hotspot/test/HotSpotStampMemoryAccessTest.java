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


package org.graalvm.compiler.hotspot.test;

import org.graalvm.compiler.core.common.CompressEncoding;
import org.graalvm.compiler.core.common.type.ObjectStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.hotspot.nodes.type.HotSpotNarrowOopStamp;
import org.junit.Assume;
import org.junit.Test;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.MemoryAccessProvider;

public class HotSpotStampMemoryAccessTest extends HotSpotGraalCompilerTest {

    @Test
    public void testReadNarrowObject() {
        CompressEncoding oopEncoding = runtime().getVMConfig().getOopEncoding();
        Assume.assumeTrue("Compressed oops must be enabled", runtime().getVMConfig().useCompressedOops);
        MemoryAccessProvider memory = getConstantReflection().getMemoryAccessProvider();
        JavaConstant base = getSnippetReflection().forObject("");
        ObjectStamp stamp = (ObjectStamp) StampFactory.forKind(JavaKind.Object);
        Stamp narrowStamp = HotSpotNarrowOopStamp.compressed(stamp, oopEncoding);
        assertTrue(narrowStamp.readConstant(memory, base, 128) == null);
    }
}
