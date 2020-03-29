// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.hotspot.replacements;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

//        class: org.graalvm.compiler.hotspot.replacements.UnsafeCopyMemoryNode
//       method: copyMemory(boolean,java.lang.Object,java.lang.Object,long,java.lang.Object,long,long)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_UnsafeCopyMemoryNode_copyMemory extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        boolean arg0;
        if (args[0].isConstant()) {
            arg0 = args[0].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg1 = args[1];
        ValueNode arg2 = args[2];
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        org.graalvm.compiler.hotspot.replacements.UnsafeCopyMemoryNode node = new org.graalvm.compiler.hotspot.replacements.UnsafeCopyMemoryNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        b.add(node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

public class PluginFactory_UnsafeCopyMemoryNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_UnsafeCopyMemoryNode_copyMemory(), org.graalvm.compiler.hotspot.replacements.UnsafeCopyMemoryNode.class, "copyMemory", boolean.class, java.lang.Object.class, java.lang.Object.class, long.class, java.lang.Object.class, long.class, long.class);
    }
}
