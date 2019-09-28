// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.replacements.aarch64;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaKind;

//        class: org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets
//       method: safeRem(float,float)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64FloatArithmeticSnippets_safeRem__0 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.SafeFloatRemNode node = new org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.SafeFloatRemNode(arg0, arg1);
        b.addPush(JavaKind.Float, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets
//       method: safeRem(double,double)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64FloatArithmeticSnippets_safeRem__1 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.SafeFloatRemNode node = new org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.SafeFloatRemNode(arg0, arg1);
        b.addPush(JavaKind.Double, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

public class PluginFactory_AArch64FloatArithmeticSnippets implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_AArch64FloatArithmeticSnippets_safeRem__0(), org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.class, "safeRem", float.class, float.class);
        plugins.register(new Plugin_AArch64FloatArithmeticSnippets_safeRem__1(), org.graalvm.compiler.replacements.aarch64.AArch64FloatArithmeticSnippets.class, "safeRem", double.class, double.class);
    }
}
