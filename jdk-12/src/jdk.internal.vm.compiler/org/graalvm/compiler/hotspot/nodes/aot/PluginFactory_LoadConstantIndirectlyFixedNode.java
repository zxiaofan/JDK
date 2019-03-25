// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.hotspot.nodes.aot;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaKind;

//        class: org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode
//       method: loadKlass(org.graalvm.compiler.hotspot.word.KlassPointer,org.graalvm.compiler.hotspot.meta.HotSpotConstantLoadAction)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_LoadConstantIndirectlyFixedNode_loadKlass__0 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        org.graalvm.compiler.hotspot.meta.HotSpotConstantLoadAction arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.hotspot.meta.HotSpotConstantLoadAction.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode node = new org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode(arg0, arg1);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_LoadConstantIndirectlyFixedNode_loadKlass__0(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode
//       method: loadKlass(org.graalvm.compiler.hotspot.word.KlassPointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_LoadConstantIndirectlyFixedNode_loadKlass__1 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode node = new org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode(arg0);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode
//       method: loadMethod(org.graalvm.compiler.hotspot.word.MethodPointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_LoadConstantIndirectlyFixedNode_loadMethod extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode node = new org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode(arg0);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode
//       method: loadObject(java.lang.Object)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_LoadConstantIndirectlyFixedNode_loadObject extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode node = new org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode(arg0);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

public class PluginFactory_LoadConstantIndirectlyFixedNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_LoadConstantIndirectlyFixedNode_loadKlass__0(injection), org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode.class, "loadKlass", org.graalvm.compiler.hotspot.word.KlassPointer.class, org.graalvm.compiler.hotspot.meta.HotSpotConstantLoadAction.class);
        plugins.register(new Plugin_LoadConstantIndirectlyFixedNode_loadKlass__1(), org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode.class, "loadKlass", org.graalvm.compiler.hotspot.word.KlassPointer.class);
        plugins.register(new Plugin_LoadConstantIndirectlyFixedNode_loadMethod(), org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode.class, "loadMethod", org.graalvm.compiler.hotspot.word.MethodPointer.class);
        plugins.register(new Plugin_LoadConstantIndirectlyFixedNode_loadObject(), org.graalvm.compiler.hotspot.nodes.aot.LoadConstantIndirectlyFixedNode.class, "loadObject", java.lang.Object.class);
    }
}
