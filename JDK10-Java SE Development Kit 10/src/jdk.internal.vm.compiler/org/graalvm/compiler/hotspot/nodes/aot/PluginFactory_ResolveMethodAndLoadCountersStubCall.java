// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.hotspot.nodes.aot;

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
public class PluginFactory_ResolveMethodAndLoadCountersStubCall implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.hotspot.nodes.aot.ResolveMethodAndLoadCountersStubCall
    //       method: resolveMethodAndLoadCounters(org.graalvm.compiler.hotspot.word.MethodPointer,org.graalvm.compiler.hotspot.word.KlassPointer,java.lang.Object)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class ResolveMethodAndLoadCountersStubCall_resolveMethodAndLoadCounters extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            org.graalvm.compiler.hotspot.nodes.aot.ResolveMethodAndLoadCountersStubCall node = new org.graalvm.compiler.hotspot.nodes.aot.ResolveMethodAndLoadCountersStubCall(arg0, arg1, arg2);
            b.addPush(JavaKind.Object, node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new ResolveMethodAndLoadCountersStubCall_resolveMethodAndLoadCounters(), org.graalvm.compiler.hotspot.nodes.aot.ResolveMethodAndLoadCountersStubCall.class, "resolveMethodAndLoadCounters", org.graalvm.compiler.hotspot.word.MethodPointer.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, java.lang.Object.class);
    }
}
