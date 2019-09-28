// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.nodes;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaKind;

//        class: org.graalvm.compiler.nodes.ConstantNode
//       method: forClass(jdk.vm.ci.meta.ResolvedJavaType)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_ConstantNode_forClass extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        jdk.vm.ci.meta.ConstantReflectionProvider arg1 = b.getConstantReflection();
        jdk.vm.ci.meta.ResolvedJavaType arg2;
        if (args[0].isConstant()) {
            jdk.vm.ci.meta.JavaConstant cst = args[0].asJavaConstant();
            arg2 = b.getConstantReflection().asJavaType(cst);
            if (arg2 == null) {
                arg2 = snippetReflection.asObject(jdk.vm.ci.meta.ResolvedJavaType.class, cst);
            }
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.nodes.ConstantNode node = new org.graalvm.compiler.nodes.ConstantNode(arg0, arg1, arg2);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_ConstantNode_forClass(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Class.class, false);
    }
}

public class PluginFactory_ConstantNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_ConstantNode_forClass(injection), org.graalvm.compiler.nodes.ConstantNode.class, "forClass", jdk.vm.ci.meta.ResolvedJavaType.class);
    }
}
