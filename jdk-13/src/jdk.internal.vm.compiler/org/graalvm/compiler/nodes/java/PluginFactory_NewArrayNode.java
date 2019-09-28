// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.nodes.java;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaKind;

//        class: org.graalvm.compiler.nodes.java.NewArrayNode
//       method: newArray(java.lang.Class<?>,int,boolean)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_NewArrayNode_newArray extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        jdk.vm.ci.meta.ResolvedJavaType arg0;
        if (args[0].isConstant()) {
            jdk.vm.ci.meta.JavaConstant cst = args[0].asJavaConstant();
            arg0 = b.getConstantReflection().asJavaType(cst);
            if (arg0 == null) {
                arg0 = snippetReflection.asObject(jdk.vm.ci.meta.ResolvedJavaType.class, cst);
            }
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg1 = args[1];
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.nodes.java.NewArrayNode node = new org.graalvm.compiler.nodes.java.NewArrayNode(arg0, arg1, arg2);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_NewArrayNode_newArray(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_NewArrayNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_NewArrayNode_newArray(injection), org.graalvm.compiler.nodes.java.NewArrayNode.class, "newArray", java.lang.Class.class, int.class, boolean.class);
    }
}
