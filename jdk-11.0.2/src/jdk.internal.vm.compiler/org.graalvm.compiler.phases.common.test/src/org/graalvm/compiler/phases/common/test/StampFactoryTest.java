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


package org.graalvm.compiler.phases.common.test;

import java.lang.reflect.Method;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.MetaAccessProvider;

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.api.test.Graal;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.core.common.type.TypeReference;
import org.graalvm.compiler.runtime.RuntimeProvider;

public class StampFactoryTest {

    @SuppressWarnings("unused")
    public void test(int a, Object b, double c) {
    }

    @Test
    public void testParameters() throws NoSuchMethodException, SecurityException {
        Method method = StampFactoryTest.class.getMethod("test", Integer.TYPE, Object.class, Double.TYPE);
        MetaAccessProvider metaAccess = Graal.getRequiredCapability(RuntimeProvider.class).getHostBackend().getProviders().getMetaAccess();
        Stamp[] parameterStamps = StampFactory.createParameterStamps(null, metaAccess.lookupJavaMethod(method));
        Stamp[] expected = {StampFactory.objectNonNull(TypeReference.createWithoutAssumptions(metaAccess.lookupJavaType(StampFactoryTest.class))), StampFactory.forKind(JavaKind.Int),
                        StampFactory.object(TypeReference.createWithoutAssumptions(metaAccess.lookupJavaType(Object.class))), StampFactory.forKind(JavaKind.Double)};
        Assert.assertArrayEquals(expected, parameterStamps);
    }
}
