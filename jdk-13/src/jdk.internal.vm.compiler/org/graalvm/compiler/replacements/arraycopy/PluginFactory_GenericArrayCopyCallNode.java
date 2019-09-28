// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.replacements.arraycopy;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaKind;

//        class: org.graalvm.compiler.replacements.arraycopy.GenericArrayCopyCallNode
//       method: genericArraycopy(java.lang.Object,int,java.lang.Object,int,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_GenericArrayCopyCallNode_genericArraycopy extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg0 = injectedForeignCallsProvider;
        ValueNode arg1 = args[0];
        ValueNode arg2 = args[1];
        ValueNode arg3 = args[2];
        ValueNode arg4 = args[3];
        ValueNode arg5 = args[4];
        org.graalvm.compiler.replacements.arraycopy.GenericArrayCopyCallNode node = new org.graalvm.compiler.replacements.arraycopy.GenericArrayCopyCallNode(arg0, arg1, arg2, arg3, arg4, arg5);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;

    Plugin_GenericArrayCopyCallNode_genericArraycopy(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
    }
}

public class PluginFactory_GenericArrayCopyCallNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_GenericArrayCopyCallNode_genericArraycopy(injection), org.graalvm.compiler.replacements.arraycopy.GenericArrayCopyCallNode.class, "genericArraycopy", java.lang.Object.class, int.class, java.lang.Object.class, int.class, int.class);
    }
}
