/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.common.inlining.policy;

import org.graalvm.compiler.core.common.GraalOptions;
import org.graalvm.compiler.nodes.CallTargetNode;
import org.graalvm.compiler.nodes.java.MethodCallTargetNode;
import org.graalvm.compiler.nodes.spi.Replacements;
import org.graalvm.compiler.phases.common.inlining.walker.MethodInvocation;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Inline every method which would be replaced by a substitution. Useful for testing purposes.
 */
public final class InlineMethodSubstitutionsPolicy extends InlineEverythingPolicy {

    @Override
    public Decision isWorthInlining(Replacements replacements, MethodInvocation invocation, int inliningDepth, boolean fullyProcessed) {
        final boolean isTracing = GraalOptions.TraceInlining.getValue(replacements.getOptions());
        CallTargetNode callTarget = invocation.callee().invoke().callTarget();
        if (callTarget instanceof MethodCallTargetNode) {
            ResolvedJavaMethod calleeMethod = ((MethodCallTargetNode) callTarget).targetMethod();
            if (replacements.hasSubstitution(calleeMethod, invocation.callee().invoke().bci())) {
                return Decision.YES.withReason(isTracing, "has a method subtitution");
            }
        }
        return Decision.NO.withReason(isTracing, "does not have a method substitution");
    }
}
