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

//        class: org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode
//       method: compute(double,org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.UnaryOperation)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_UnaryMathIntrinsicNode_compute extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.UnaryOperation arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.UnaryOperation.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode node = new org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode(arg0, arg1);
        b.addPush(JavaKind.Double, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_UnaryMathIntrinsicNode_compute(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_UnaryMathIntrinsicNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_UnaryMathIntrinsicNode_compute(injection), org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.class, "compute", double.class, org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.UnaryOperation.class);
    }
}
