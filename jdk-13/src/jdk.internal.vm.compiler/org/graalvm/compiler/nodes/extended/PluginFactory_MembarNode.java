// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.nodes.extended;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

//        class: org.graalvm.compiler.nodes.extended.MembarNode
//       method: memoryBarrier(int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_MembarNode_memoryBarrier__0 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        int arg0;
        if (args[0].isConstant()) {
            arg0 = args[0].asJavaConstant().asInt();
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.nodes.extended.MembarNode node = new org.graalvm.compiler.nodes.extended.MembarNode(arg0);
        b.add(node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.nodes.extended.MembarNode
//       method: memoryBarrier(int,jdk.internal.vm.compiler.word.LocationIdentity)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_MembarNode_memoryBarrier__1 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        int arg0;
        if (args[0].isConstant()) {
            arg0 = args[0].asJavaConstant().asInt();
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.internal.vm.compiler.word.LocationIdentity arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.internal.vm.compiler.word.LocationIdentity.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.nodes.extended.MembarNode node = new org.graalvm.compiler.nodes.extended.MembarNode(arg0, arg1);
        b.add(node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_MembarNode_memoryBarrier__1(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_MembarNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_MembarNode_memoryBarrier__0(), org.graalvm.compiler.nodes.extended.MembarNode.class, "memoryBarrier", int.class);
        plugins.register(new Plugin_MembarNode_memoryBarrier__1(injection), org.graalvm.compiler.nodes.extended.MembarNode.class, "memoryBarrier", int.class, jdk.internal.vm.compiler.word.LocationIdentity.class);
    }
}
