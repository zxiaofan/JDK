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

//        class: org.graalvm.compiler.nodes.java.DynamicNewArrayNode
//       method: newArray(java.lang.Class<?>,int,boolean)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_DynamicNewArrayNode_newArray__0 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.nodes.java.DynamicNewArrayNode node = new org.graalvm.compiler.nodes.java.DynamicNewArrayNode(arg0, arg1, arg2);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.nodes.java.DynamicNewArrayNode
//       method: newArray(java.lang.Class<?>,int,boolean,jdk.vm.ci.meta.JavaKind)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_DynamicNewArrayNode_newArray__1 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        jdk.vm.ci.meta.MetaAccessProvider arg0 = b.getMetaAccess();
        ValueNode arg1 = args[0];
        ValueNode arg2 = args[1];
        boolean arg3;
        if (args[2].isConstant()) {
            arg3 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg4;
        if (args[3].isConstant()) {
            arg4 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[3].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.nodes.java.DynamicNewArrayNode node = new org.graalvm.compiler.nodes.java.DynamicNewArrayNode(arg0, arg1, arg2, arg3, arg4);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_DynamicNewArrayNode_newArray__1(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_DynamicNewArrayNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_DynamicNewArrayNode_newArray__0(), org.graalvm.compiler.nodes.java.DynamicNewArrayNode.class, "newArray", java.lang.Class.class, int.class, boolean.class);
        plugins.register(new Plugin_DynamicNewArrayNode_newArray__1(injection), org.graalvm.compiler.nodes.java.DynamicNewArrayNode.class, "newArray", java.lang.Class.class, int.class, boolean.class, jdk.vm.ci.meta.JavaKind.class);
    }
}
