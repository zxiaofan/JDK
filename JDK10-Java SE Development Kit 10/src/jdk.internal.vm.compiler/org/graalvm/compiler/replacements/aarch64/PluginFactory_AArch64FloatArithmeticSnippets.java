// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.verifier.VerifierAnnotationProcessor, org.graalvm.compiler.replacements.verifier.PluginGenerator
package org.graalvm.compiler.replacements.aarch64;

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
public class PluginFactory_AArch64FloatArithmeticSnippets implements NodeIntrinsicPluginFactory {

    //        class: org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets
    //       method: safeRem(double,double)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class AArch64FloatArithmeticSnippets_safeRem_double_double extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.SafeFloatRemNode node = new org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.SafeFloatRemNode(arg0, arg1);
            b.addPush(JavaKind.Double, node);
            return true;
        }
    }

    //        class: org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets
    //       method: safeRem(float,float)
    // generated-by: org.graalvm.compiler.replacements.verifier.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
    private static final class AArch64FloatArithmeticSnippets_safeRem_float_float extends GeneratedInvocationPlugin {

        @Override
        public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
            ValueNode arg0 = args[0];
            ValueNode arg1 = args[1];
            org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.SafeFloatRemNode node = new org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.SafeFloatRemNode(arg0, arg1);
            b.addPush(JavaKind.Float, node);
            return true;
        }
    }

    @Override
    public void registerPlugins(InvocationPlugins plugins, InjectionProvider injection) {
        plugins.register(new AArch64FloatArithmeticSnippets_safeRem_double_double(), org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.class, "safeRem", double.class, double.class);
        plugins.register(new AArch64FloatArithmeticSnippets_safeRem_float_float(), org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.class, "safeRem", float.class, float.class);
    }
}
