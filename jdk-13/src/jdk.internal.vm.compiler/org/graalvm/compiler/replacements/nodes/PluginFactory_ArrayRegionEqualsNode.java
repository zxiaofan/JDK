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

import jdk.vm.ci.meta.JavaKind;

//        class: org.graalvm.compiler.replacements.nodes.ArrayRegionEqualsNode
//       method: regionEquals(jdk.internal.vm.compiler.word.Pointer,jdk.internal.vm.compiler.word.Pointer,int,jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_ArrayRegionEqualsNode_regionEquals extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        ValueNode arg2 = args[2];
        jdk.vm.ci.meta.JavaKind arg3;
        if (args[3].isConstant()) {
            arg3 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[3].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg4;
        if (args[4].isConstant()) {
            arg4 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[4].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.replacements.nodes.ArrayRegionEqualsNode node = new org.graalvm.compiler.replacements.nodes.ArrayRegionEqualsNode(arg0, arg1, arg2, arg3, arg4);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_ArrayRegionEqualsNode_regionEquals(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_ArrayRegionEqualsNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_ArrayRegionEqualsNode_regionEquals(injection), org.graalvm.compiler.replacements.nodes.ArrayRegionEqualsNode.class, "regionEquals", jdk.internal.vm.compiler.word.Pointer.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class);
    }
}
