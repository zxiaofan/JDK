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

//        class: org.graalvm.compiler.replacements.arraycopy.ArrayCopyWithDelayedLoweringNode
//       method: arraycopy(java.lang.Object,int,java.lang.Object,int,int,org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo,jdk.vm.ci.meta.JavaKind)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_ArrayCopyWithDelayedLoweringNode_arraycopy extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        ValueNode arg2 = args[2];
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo arg5;
        if (args[5].isConstant()) {
            arg5 = snippetReflection.asObject(org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo.class, args[5].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg6;
        if (args[6].isConstant()) {
            arg6 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[6].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.replacements.arraycopy.ArrayCopyWithDelayedLoweringNode node = new org.graalvm.compiler.replacements.arraycopy.ArrayCopyWithDelayedLoweringNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        b.add(node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_ArrayCopyWithDelayedLoweringNode_arraycopy(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_ArrayCopyWithDelayedLoweringNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_ArrayCopyWithDelayedLoweringNode_arraycopy(injection), org.graalvm.compiler.replacements.arraycopy.ArrayCopyWithDelayedLoweringNode.class, "arraycopy", java.lang.Object.class, int.class, java.lang.Object.class, int.class, int.class, org.graalvm.compiler.replacements.SnippetTemplate.SnippetInfo.class, jdk.vm.ci.meta.JavaKind.class);
    }
}
