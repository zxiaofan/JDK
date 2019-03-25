/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.junit.Assert;
import org.junit.Test;

import jdk.vm.ci.hotspot.HotSpotResolvedJavaMethod;
import jdk.vm.ci.hotspot.HotSpotResolvedObjectType;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.MemoryAccessProvider;
import jdk.vm.ci.meta.PrimitiveConstant;

/**
 * Tests {@link HotSpotResolvedJavaMethod} functionality.
 */
public class HotSpotResolvedObjectTypeTest extends HotSpotGraalCompilerTest {

    @Test
    public void testGetSourceFileName() throws Throwable {
        Assert.assertEquals("Object.java", getMetaAccess().lookupJavaType(Object.class).getSourceFileName());
        Assert.assertEquals("HotSpotResolvedObjectTypeTest.java", getMetaAccess().lookupJavaType(this.getClass()).getSourceFileName());
    }

    @Test
    public void testKlassLayoutHelper() {
        Constant klass = ((HotSpotResolvedObjectType) getMetaAccess().lookupJavaType(this.getClass())).klass();
        MemoryAccessProvider memoryAccess = getProviders().getConstantReflection().getMemoryAccessProvider();
        GraalHotSpotVMConfig config = runtime().getVMConfig();
        Constant c = StampFactory.forKind(JavaKind.Int).readConstant(memoryAccess, klass, config.klassLayoutHelperOffset);
        assertTrue(c.toString(), c.getClass() == PrimitiveConstant.class);
        PrimitiveConstant pc = (PrimitiveConstant) c;
        assertTrue(pc.toString(), pc.getJavaKind() == JavaKind.Int);
    }
}
