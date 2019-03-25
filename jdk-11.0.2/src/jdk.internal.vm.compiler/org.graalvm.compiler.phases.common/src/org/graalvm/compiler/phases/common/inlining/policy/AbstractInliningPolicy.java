/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.phases.common.inlining.InliningPhase.Options.AlwaysInlineIntrinsics;

import java.util.Map;

import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.spi.Replacements;
import org.graalvm.compiler.phases.common.inlining.InliningUtil;
import org.graalvm.compiler.phases.common.inlining.info.InlineInfo;
import org.graalvm.compiler.phases.common.inlining.info.elem.Inlineable;

import jdk.vm.ci.meta.ProfilingInfo;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public abstract class AbstractInliningPolicy implements InliningPolicy {
    public static final float RelevanceCapForInlining = 1.0f;
    public static final float CapInheritedRelevance = 1.0f;
    protected final Map<Invoke, Double> hints;

    public AbstractInliningPolicy(Map<Invoke, Double> hints) {
        this.hints = hints;
    }

    protected double computeMaximumSize(double relevance, int configuredMaximum) {
        double inlineRatio = Math.min(RelevanceCapForInlining, relevance);
        return configuredMaximum * inlineRatio;
    }

    protected double getInliningBonus(InlineInfo info) {
        if (hints != null && hints.containsKey(info.invoke())) {
            return hints.get(info.invoke());
        }
        return 1;
    }

    protected boolean isIntrinsic(Replacements replacements, InlineInfo info) {
        if (AlwaysInlineIntrinsics.getValue(info.graph().getOptions())) {
            return onlyIntrinsics(replacements, info);
        } else {
            return onlyForcedIntrinsics(replacements, info);
        }
    }

    private static boolean onlyIntrinsics(Replacements replacements, InlineInfo info) {
        for (int i = 0; i < info.numberOfMethods(); i++) {
            if (!InliningUtil.canIntrinsify(replacements, info.methodAt(i), info.invoke().bci())) {
                return false;
            }
        }
        return true;
    }

    private static boolean onlyForcedIntrinsics(Replacements replacements, InlineInfo info) {
        if (!onlyIntrinsics(replacements, info)) {
            return false;
        }
        if (!info.shouldInline()) {
            return false;
        }
        return true;
    }

    protected static int previousLowLevelGraphSize(InlineInfo info) {
        int size = 0;
        for (int i = 0; i < info.numberOfMethods(); i++) {
            ResolvedJavaMethod m = info.methodAt(i);
            ProfilingInfo profile = info.graph().getProfilingInfo(m);
            int compiledGraphSize = profile.getCompilerIRSize(StructuredGraph.class);
            if (compiledGraphSize > 0) {
                size += compiledGraphSize;
            }
        }
        return size;
    }

    protected static double determineInvokeProbability(InlineInfo info) {
        double invokeProbability = 0;
        for (int i = 0; i < info.numberOfMethods(); i++) {
            Inlineable callee = info.inlineableElementAt(i);
            Iterable<Invoke> invokes = callee.getInvokes();
            if (invokes.iterator().hasNext()) {
                for (Invoke invoke : invokes) {
                    invokeProbability += callee.getProbability(invoke);
                }
            }
        }
        return invokeProbability;
    }
}
