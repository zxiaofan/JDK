// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.nodes.extended;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_MembarNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.extended.MembarNode
    //       method: memoryBarrier(int)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class MembarNode_memoryBarrier_int extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            int arg0;
            if (args[0].isConstant()) {
                arg0 = args[0].asJavaConstant().asInt();
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.extended.MembarNode node = new org.graalvm.compiler.nodes.extended.MembarNode(arg0);
            b.add(node);
            return true;
        }
    }

    //        class: org.graalvm.compiler.nodes.extended.MembarNode
    //       method: memoryBarrier(int,org.graalvm.word.LocationIdentity)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class MembarNode_memoryBarrier_int_LocationIdentity extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            int arg0;
            if (args[0].isConstant()) {
                arg0 = args[0].asJavaConstant().asInt();
            } else {
                return false;
            }
            org.graalvm.word.LocationIdentity arg1;
            if (args[1].isConstant()) {
                arg1 = snippetReflection.asObject(org.graalvm.word.LocationIdentity.class, args[1].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.extended.MembarNode node = new org.graalvm.compiler.nodes.extended.MembarNode(arg0, arg1);
            b.add(node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private MembarNode_memoryBarrier_int_LocationIdentity(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new MembarNode_memoryBarrier_int(), org.graalvm.compiler.nodes.extended.MembarNode.class, "memoryBarrier", int.class);
        plugins.register(new MembarNode_memoryBarrier_int_LocationIdentity(injection), org.graalvm.compiler.nodes.extended.MembarNode.class, "memoryBarrier", int.class, org.graalvm.word.LocationIdentity.class);
    }
}
