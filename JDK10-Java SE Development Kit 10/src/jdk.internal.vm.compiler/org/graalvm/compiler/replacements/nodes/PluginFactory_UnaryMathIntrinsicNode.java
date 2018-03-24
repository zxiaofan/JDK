// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.replacements.nodes;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaKind;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_UnaryMathIntrinsicNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode
    //       method: compute(double,org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.UnaryOperation)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class UnaryMathIntrinsicNode_compute extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.UnaryOperation arg1;
            if (args[1].isConstant()) {
                arg1 = snippetReflection.asObject(org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.UnaryOperation.class, args[1].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode node = new org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode(arg0, arg1);
            b.addPush(JavaKind.Double, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private UnaryMathIntrinsicNode_compute(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new UnaryMathIntrinsicNode_compute(injection), org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.class, "compute", double.class, org.graalvm.compiler.replacements.nodes.UnaryMathIntrinsicNode.UnaryOperation.class);
    }
}
