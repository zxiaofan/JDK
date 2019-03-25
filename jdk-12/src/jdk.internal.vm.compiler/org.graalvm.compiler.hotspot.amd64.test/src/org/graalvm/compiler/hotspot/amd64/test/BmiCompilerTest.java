/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.amd64.test;

import static org.junit.Assume.assumeTrue;

import org.graalvm.compiler.api.test.Graal;
import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.runtime.RuntimeProvider;
import org.junit.Assert;
import org.junit.Before;

import jdk.vm.ci.amd64.AMD64;
import jdk.vm.ci.code.Architecture;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public abstract class BmiCompilerTest extends GraalCompilerTest {

    @Before
    public void checkAMD64() {
        Architecture arch = Graal.getRequiredCapability(RuntimeProvider.class).getHostBackend().getTarget().arch;
        assumeTrue("skipping AMD64 specific test", arch instanceof AMD64);
        assumeTrue("skipping BMI1 specific test", ((AMD64) arch).getFeatures().contains(AMD64.CPUFeature.BMI1));
    }

    public boolean verifyPositive(String methodName, byte[] instrMask, byte[] instrPattern) {
        ResolvedJavaMethod method = getResolvedJavaMethod(methodName);
        StructuredGraph graph = parseForCompile(method);

        CompilationResult c = compile(method, graph);
        byte[] targetCode = c.getTargetCode();

        return countCpuInstructions(targetCode, instrMask, instrPattern) >= 1;
    }

    public static int countCpuInstructions(byte[] nativeCode, byte[] instrMask, byte[] instrPattern) {
        int count = 0;
        int patternSize = Math.min(instrMask.length, instrPattern.length);
        boolean found;
        Assert.assertTrue(patternSize > 0);
        for (int i = 0, n = nativeCode.length - patternSize; i < n;) {
            found = true;
            for (int j = 0; j < patternSize; j++) {
                if ((nativeCode[i + j] & instrMask[j]) != instrPattern[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                ++count;
                i += patternSize - 1;
            }
            i++;
        }
        return count;
    }
}
