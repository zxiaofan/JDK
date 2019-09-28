// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.replacements.nodes;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

//        class: org.graalvm.compiler.replacements.nodes.ZeroMemoryNode
//       method: zero(org.graalvm.compiler.word.Word,long,jdk.internal.vm.compiler.word.LocationIdentity)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_ZeroMemoryNode_zero extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        jdk.internal.vm.compiler.word.LocationIdentity arg2;
        if (args[2].isConstant()) {
            arg2 = snippetReflection.asObject(jdk.internal.vm.compiler.word.LocationIdentity.class, args[2].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.replacements.nodes.ZeroMemoryNode node = new org.graalvm.compiler.replacements.nodes.ZeroMemoryNode(arg0, arg1, arg2);
        b.add(node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_ZeroMemoryNode_zero(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_ZeroMemoryNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_ZeroMemoryNode_zero(injection), org.graalvm.compiler.replacements.nodes.ZeroMemoryNode.class, "zero", org.graalvm.compiler.word.Word.class, long.class, jdk.internal.vm.compiler.word.LocationIdentity.class);
    }
}
