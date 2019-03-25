/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements;

import org.graalvm.compiler.api.replacements.SnippetReflectionProvider;
import org.graalvm.compiler.core.common.type.StampPair;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderTool;
import org.graalvm.compiler.nodes.graphbuilderconf.ParameterPlugin;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.MetaAccessProvider;

/**
 * A {@link ParameterPlugin} that binds constant values to some parameters.
 */
public class ConstantBindingParameterPlugin implements ParameterPlugin {
    private final Object[] constantArgs;
    private final MetaAccessProvider metaAccess;
    private final SnippetReflectionProvider snippetReflection;

    /**
     * Creates a plugin that will create {@link ConstantNode}s for each parameter with an index
     * equal to that of a non-null object in {@code constantArgs} (from which the
     * {@link ConstantNode} is created if it isn't already a {@link ConstantNode}).
     */
    public ConstantBindingParameterPlugin(Object[] constantArgs, MetaAccessProvider metaAccess, SnippetReflectionProvider snippetReflection) {
        this.constantArgs = constantArgs;
        this.metaAccess = metaAccess;
        this.snippetReflection = snippetReflection;
    }

    @Override
    public FloatingNode interceptParameter(GraphBuilderTool b, int index, StampPair stamp) {
        Object arg = constantArgs[index];
        if (arg != null) {
            ConstantNode constantNode;
            if (arg instanceof ConstantNode) {
                ConstantNode otherCon = (ConstantNode) arg;
                if (otherCon.graph() != b.getGraph()) {
                    /*
                     * This is a node from another graph, so copy over extra state into a new
                     * ConstantNode.
                     */
                    constantNode = ConstantNode.forConstant(stamp.getTrustedStamp(), otherCon.getValue(), otherCon.getStableDimension(), otherCon.isDefaultStable(), metaAccess);
                } else {
                    constantNode = otherCon;
                }
            } else if (arg instanceof Constant) {
                constantNode = ConstantNode.forConstant(stamp.getTrustedStamp(), (Constant) arg, metaAccess);
            } else {
                constantNode = ConstantNode.forConstant(snippetReflection.forBoxed(stamp.getTrustedStamp().getStackKind(), arg), metaAccess);
            }
            return constantNode;
        }
        return null;
    }
}
