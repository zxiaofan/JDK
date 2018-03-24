// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.hotspot.replacements;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_ClassGetHubNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.replacements.ClassGetHubNode
    //       method: piCastNonNull(java.lang.Object,org.graalvm.compiler.nodes.extended.GuardingNode)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
    private static final class ClassGetHubNode_piCastNonNull extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            return org.graalvm.compiler.nodes.PiNode.intrinsify(b, targetMethod, arg0, arg1);
        }
    }

    //        class: org.graalvm.compiler.hotspot.replacements.ClassGetHubNode
    //       method: readClass(java.lang.Class<?>)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
    private static final class ClassGetHubNode_readClass extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            return org.graalvm.compiler.hotspot.replacements.ClassGetHubNode.intrinsify(b, targetMethod, arg0);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new ClassGetHubNode_piCastNonNull(), org.graalvm.compiler.hotspot.replacements.ClassGetHubNode.class, "piCastNonNull", java.lang.Object.class, org.graalvm.compiler.nodes.extended.GuardingNode.class);
        plugins.register(new ClassGetHubNode_readClass(), org.graalvm.compiler.hotspot.replacements.ClassGetHubNode.class, "readClass", java.lang.Class.class);
    }
}
