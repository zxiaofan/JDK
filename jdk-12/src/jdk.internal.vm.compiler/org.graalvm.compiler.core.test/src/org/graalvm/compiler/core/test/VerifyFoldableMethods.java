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


package org.graalvm.compiler.core.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.graalvm.compiler.api.replacements.Fold;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.java.MethodCallTargetNode;
import org.graalvm.compiler.phases.VerifyPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * Verifies that all {@link Fold} annotated methods have at least one caller.
 */
public class VerifyFoldableMethods extends VerifyPhase<PhaseContext> {

    @Override
    public boolean checkContract() {
        return false;
    }

    private final Map<ResolvedJavaMethod, Boolean> foldables = new ConcurrentHashMap<>();
    ResolvedJavaType generatedInvocationPluginType;

    @Override
    protected boolean verify(StructuredGraph graph, PhaseContext context) {
        ResolvedJavaMethod method = graph.method();
        if (method.getAnnotation(Fold.class) != null) {
            foldables.putIfAbsent(method, false);
        } else {
            if (generatedInvocationPluginType == null) {
                generatedInvocationPluginType = context.getMetaAccess().lookupJavaType(GeneratedInvocationPlugin.class);
            }
            if (!generatedInvocationPluginType.isAssignableFrom(method.getDeclaringClass())) {
                for (MethodCallTargetNode t : graph.getNodes(MethodCallTargetNode.TYPE)) {
                    ResolvedJavaMethod callee = t.targetMethod();
                    if (callee.getAnnotation(Fold.class) != null) {
                        foldables.put(callee, true);
                    }
                }
            }
        }
        return true;
    }

    public void finish() {
        String uncalled = foldables.entrySet().stream().filter(e -> e.getValue() == false).map(e -> e.getKey().format("%H.%n(%p)")).collect(Collectors.joining(System.lineSeparator() + "  "));
        if (uncalled.length() != 0) {
            throw new VerificationError(String.format("Methods annotated with @" + Fold.class.getSimpleName() + " appear to have no usages:%n  %s", uncalled));
        }
    }
}
