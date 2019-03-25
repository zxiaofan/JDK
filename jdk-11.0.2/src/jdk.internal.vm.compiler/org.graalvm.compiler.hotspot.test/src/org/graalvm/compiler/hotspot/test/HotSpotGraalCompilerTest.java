/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.api.test.Graal;
import org.graalvm.compiler.core.common.CompilationIdentifier;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.hotspot.HotSpotBackend;
import org.graalvm.compiler.hotspot.HotSpotGraalCompiler;
import org.graalvm.compiler.hotspot.HotSpotGraalRuntimeProvider;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.runtime.RuntimeProvider;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.runtime.JVMCI;

/**
 * A Graal compiler test that needs access to the {@link HotSpotGraalRuntimeProvider}.
 */
public abstract class HotSpotGraalCompilerTest extends GraalCompilerTest {

    /**
     * Gets the {@link HotSpotGraalRuntimeProvider}.
     */
    protected HotSpotGraalRuntimeProvider runtime() {
        return ((HotSpotBackend) getBackend()).getRuntime();
    }

    protected InstalledCode compileAndInstallSubstitution(Class<?> c, String methodName) {
        ResolvedJavaMethod method = getMetaAccess().lookupJavaMethod(getMethod(c, methodName));
        HotSpotGraalCompiler compiler = (HotSpotGraalCompiler) JVMCI.getRuntime().getCompiler();
        HotSpotGraalRuntimeProvider rt = (HotSpotGraalRuntimeProvider) Graal.getRequiredCapability(RuntimeProvider.class);
        HotSpotProviders providers = rt.getHostBackend().getProviders();
        CompilationIdentifier compilationId = runtime().getHostBackend().getCompilationIdentifier(method);
        OptionValues options = getInitialOptions();
        StructuredGraph graph = compiler.getIntrinsicGraph(method, providers, compilationId, options, getDebugContext(options));
        if (graph != null) {
            return getCode(method, graph, true, true, graph.getOptions());
        }
        return null;
    }
}
