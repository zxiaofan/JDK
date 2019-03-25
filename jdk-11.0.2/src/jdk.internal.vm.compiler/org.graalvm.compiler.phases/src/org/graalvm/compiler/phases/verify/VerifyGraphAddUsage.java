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


package org.graalvm.compiler.phases.verify;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import jdk.internal.vm.compiler.collections.EconomicSet;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.graph.Graph;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.PiNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.ValuePhiNode;
import org.graalvm.compiler.nodes.ValueProxyNode;
import org.graalvm.compiler.nodes.java.MethodCallTargetNode;
import org.graalvm.compiler.nodes.java.NewInstanceNode;
import org.graalvm.compiler.nodes.spi.LoweringProvider;
import org.graalvm.compiler.phases.VerifyPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.ResolvedJavaType;

public class VerifyGraphAddUsage extends VerifyPhase<PhaseContext> {
    private static final Method ADD_OR_UNIQUE;
    private static final Method CONSTRUCTOR_NEW_INSTANCE;
    private static final EconomicSet<Class<?>> ALLOWED_CLASSES = EconomicSet.create();

    static {
        try {
            ADD_OR_UNIQUE = Graph.class.getDeclaredMethod("addOrUnique", Node.class);
            CONSTRUCTOR_NEW_INSTANCE = Constructor.class.getDeclaredMethod("newInstance", Object[].class);
        } catch (NoSuchMethodException e) {
            throw new GraalError(e);
        }

        ALLOWED_CLASSES.add(Graph.class);
        ALLOWED_CLASSES.add(LoweringProvider.class);
    }

    @Override
    protected boolean verify(StructuredGraph graph, PhaseContext context) {
        boolean allowed = false;
        for (Class<?> cls : ALLOWED_CLASSES) {
            ResolvedJavaType declaringClass = graph.method().getDeclaringClass();
            if (context.getMetaAccess().lookupJavaType(cls).isAssignableFrom(declaringClass)) {
                allowed = true;
            }
        }
        if (!allowed) {
            ResolvedJavaMethod addOrUniqueMethod = context.getMetaAccess().lookupJavaMethod(ADD_OR_UNIQUE);
            for (MethodCallTargetNode t : graph.getNodes(MethodCallTargetNode.TYPE)) {
                ResolvedJavaMethod callee = t.targetMethod();
                if (callee.equals(addOrUniqueMethod)) {
                    ValueNode nodeArgument = t.arguments().get(1);
                    EconomicSet<Node> seen = EconomicSet.create();
                    checkNonFactory(graph, seen, context, nodeArgument);
                }
            }
        }

        return true;
    }

    private void checkNonFactory(StructuredGraph graph, EconomicSet<Node> seen, PhaseContext context, ValueNode node) {
        if (seen.contains(node)) {
            return;
        }
        seen.add(node);

        // Check where the value came from recursively, or if it is allowed.
        if (node instanceof ValuePhiNode) {
            for (ValueNode input : ((ValuePhiNode) node).values()) {
                checkNonFactory(graph, seen, context, input);
            }
        } else if (node instanceof PiNode) {
            checkNonFactory(graph, seen, context, ((PiNode) node).object());
        } else if (node instanceof ParameterNode) {
            return;
        } else if (node instanceof ConstantNode) {
            return;
        } else if (node instanceof ValueProxyNode) {
            checkNonFactory(graph, seen, context, ((ValueProxyNode) node).value());
        } else if (node instanceof Invoke && ((Invoke) node).callTarget().targetMethod().equals(context.getMetaAccess().lookupJavaMethod(CONSTRUCTOR_NEW_INSTANCE))) {
            return;
        } else if (!(node instanceof NewInstanceNode)) {
            // In all other cases, the argument must be a new instance.
            throw new VerificationError("Must add node '%s' with inputs in method '%s' of class '%s'.",
                            node, graph.method().getName(), graph.method().getDeclaringClass().getName());
        }
    }

}
