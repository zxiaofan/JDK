// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.nodes.java;

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
public class PluginFactory_DynamicNewArrayNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.java.DynamicNewArrayNode
    //       method: newArray(java.lang.Class<?>,int,boolean,jdk.vm.ci.meta.JavaKind)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class DynamicNewArrayNode_newArray extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            jdk.vm.ci.meta.MetaAccessProvider arg0 = b.getMetaAccess();
            ValueNode arg1 = args[0];
            ValueNode arg2 = args[1];
            boolean arg3;
            if (args[2].isConstant()) {
                arg3 = args[2].asJavaConstant().asInt() != 0;
            } else {
                return false;
            }
            jdk.vm.ci.meta.JavaKind arg4;
            if (args[3].isConstant()) {
                arg4 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[3].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.java.DynamicNewArrayNode node = new org.graalvm.compiler.nodes.java.DynamicNewArrayNode(arg0, arg1, arg2, arg3, arg4);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private DynamicNewArrayNode_newArray(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new DynamicNewArrayNode_newArray(injection), org.graalvm.compiler.nodes.java.DynamicNewArrayNode.class, "newArray", java.lang.Class.class, int.class, boolean.class, jdk.vm.ci.meta.JavaKind.class);
    }
}
