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

import jdk.vm.ci.meta.JavaKind;

@ServiceProvider(NodeIntrinsicPluginFactory.class)
public class PluginFactory_RawStoreNode implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.nodes.extended.RawStoreNode
    //       method: storeChar(java.lang.Object,long,char,jdk.vm.ci.meta.JavaKind,org.graalvm.word.LocationIdentity)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class RawStoreNode_storeChar extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            jdk.vm.ci.meta.JavaKind arg3;
            if (args[3].isConstant()) {
                arg3 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[3].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.word.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.word.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.extended.RawStoreNode node = new org.graalvm.compiler.nodes.extended.RawStoreNode(arg0, arg1, arg2, arg3, arg4);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private RawStoreNode_storeChar(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    //        class: org.graalvm.compiler.nodes.extended.RawStoreNode
    //       method: storeObject(java.lang.Object,long,java.lang.Object,jdk.vm.ci.meta.JavaKind,org.graalvm.word.LocationIdentity,boolean)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class RawStoreNode_storeObject extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            ValueNode arg2 = args[2];
            jdk.vm.ci.meta.JavaKind arg3;
            if (args[3].isConstant()) {
                arg3 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[3].asJavaConstant());
            } else {
                return false;
            }
            org.graalvm.word.LocationIdentity arg4;
            if (args[4].isConstant()) {
                arg4 = snippetReflection.asObject(org.graalvm.word.LocationIdentity.class, args[4].asJavaConstant());
            } else {
                return false;
            }
            boolean arg5;
            if (args[5].isConstant()) {
                arg5 = args[5].asJavaConstant().asInt() != 0;
            } else {
                return false;
            }
            org.graalvm.compiler.nodes.extended.RawStoreNode node = new org.graalvm.compiler.nodes.extended.RawStoreNode(arg0, arg1, arg2, arg3, arg4, arg5);
            b.addPush(JavaKind.Object, node);
            return true;
        }

        private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

        private RawStoreNode_storeObject(InjectionProvider injection) {
            this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new RawStoreNode_storeChar(injection), org.graalvm.compiler.nodes.extended.RawStoreNode.class, "storeChar", java.lang.Object.class, long.class, char.class, jdk.vm.ci.meta.JavaKind.class, org.graalvm.word.LocationIdentity.class);
        plugins.register(new RawStoreNode_storeObject(injection), org.graalvm.compiler.nodes.extended.RawStoreNode.class, "storeObject", java.lang.Object.class, long.class, java.lang.Object.class, jdk.vm.ci.meta.JavaKind.class, org.graalvm.word.LocationIdentity.class, boolean.class);
    }
}
