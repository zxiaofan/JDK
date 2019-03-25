/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.core.GraalCompilerOptions.CompilationBailoutAction;
import static org.graalvm.compiler.core.GraalCompilerOptions.CompilationFailureAction;

import jdk.internal.vm.compiler.collections.EconomicMap;
import org.graalvm.compiler.core.CompilationWrapper.ExceptionAction;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.hotspot.HotSpotGraalCompiler;
import org.graalvm.compiler.options.OptionKey;
import org.graalvm.compiler.options.OptionValues;
import org.junit.Test;

import jdk.vm.ci.hotspot.HotSpotJVMCIRuntime;

/**
 * Tests {@link CompileTheWorld} functionality.
 */
public class CompileTheWorldTest extends GraalCompilerTest {

    @Test
    public void testJDK() throws Throwable {
        ExceptionAction originalBailoutAction = CompilationBailoutAction.getValue(getInitialOptions());
        ExceptionAction originalFailureAction = CompilationFailureAction.getValue(getInitialOptions());
        // Compile a couple classes in rt.jar
        HotSpotJVMCIRuntime runtime = HotSpotJVMCIRuntime.runtime();
        System.setProperty("CompileTheWorld.LimitModules", "java.base");
        OptionValues initialOptions = getInitialOptions();
        EconomicMap<OptionKey<?>, Object> compilationOptions = CompileTheWorld.parseOptions("Inline=false");
        new CompileTheWorld(runtime, (HotSpotGraalCompiler) runtime.getCompiler(), CompileTheWorld.SUN_BOOT_CLASS_PATH, 1, 5, null, null, false, initialOptions, compilationOptions).compile();
        assert CompilationBailoutAction.getValue(initialOptions) == originalBailoutAction;
        assert CompilationFailureAction.getValue(initialOptions) == originalFailureAction;
    }
}
