// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.replacements.amd64;

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
public class PluginFactory_AMD64StringIndexOfNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.replacements.amd64.AMD64StringIndexOfNode
    //       method: optimizedStringIndexPointer(org.graalvm.word.Pointer,int,org.graalvm.word.Pointer,int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class AMD64StringIndexOfNode_optimizedStringIndexPointer extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            ValueNode arg3 = args[3];
            org.graalvm.compiler.replacements.amd64.AMD64StringIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64StringIndexOfNode(arg0, arg1, arg2, arg3);
            b.addPush(JavaKind.Int, node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new AMD64StringIndexOfNode_optimizedStringIndexPointer(), org.graalvm.compiler.replacements.amd64.AMD64StringIndexOfNode.class, "optimizedStringIndexPointer", org.graalvm.word.Pointer.class, int.class, org.graalvm.word.Pointer.class, int.class);
    }
}
