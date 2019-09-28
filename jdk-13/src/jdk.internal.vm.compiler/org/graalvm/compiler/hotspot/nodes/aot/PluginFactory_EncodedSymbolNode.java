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

//        class: org.graalvm.compiler.hotspot.nodes.aot.EncodedSymbolNode
//       method: encode(java.lang.Object)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_EncodedSymbolNode_encode extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        ValueNode arg1 = args[0];
        org.graalvm.compiler.hotspot.nodes.aot.EncodedSymbolNode node = new org.graalvm.compiler.hotspot.nodes.aot.EncodedSymbolNode(arg0, arg1);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_EncodedSymbolNode_encode(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.stamp = injection.getInjectedStamp(org.graalvm.compiler.word.Word.class, false);
    }
}

public class PluginFactory_EncodedSymbolNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_EncodedSymbolNode_encode(injection), org.graalvm.compiler.hotspot.nodes.aot.EncodedSymbolNode.class, "encode", java.lang.Object.class);
    }
}
