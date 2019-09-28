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

//        class: org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets
//       method: safeDiv(int,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64IntegerArithmeticSnippets_safeDiv__0 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeSignedDivNode node = new org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeSignedDivNode(arg0, arg1);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets
//       method: safeDiv(long,long)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64IntegerArithmeticSnippets_safeDiv__1 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeSignedDivNode node = new org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeSignedDivNode(arg0, arg1);
        b.addPush(JavaKind.Long, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets
//       method: safeRem(int,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64IntegerArithmeticSnippets_safeRem__2 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeSignedRemNode node = new org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeSignedRemNode(arg0, arg1);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets
//       method: safeRem(long,long)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64IntegerArithmeticSnippets_safeRem__3 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeSignedRemNode node = new org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeSignedRemNode(arg0, arg1);
        b.addPush(JavaKind.Long, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets
//       method: safeUDiv(int,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64IntegerArithmeticSnippets_safeUDiv__4 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeUnsignedDivNode node = new org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeUnsignedDivNode(arg0, arg1);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets
//       method: safeUDiv(long,long)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64IntegerArithmeticSnippets_safeUDiv__5 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeUnsignedDivNode node = new org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeUnsignedDivNode(arg0, arg1);
        b.addPush(JavaKind.Long, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets
//       method: safeURem(int,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64IntegerArithmeticSnippets_safeURem__6 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeUnsignedRemNode node = new org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeUnsignedRemNode(arg0, arg1);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets
//       method: safeURem(long,long)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AArch64IntegerArithmeticSnippets_safeURem__7 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeUnsignedRemNode node = new org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.SafeUnsignedRemNode(arg0, arg1);
        b.addPush(JavaKind.Long, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

public class PluginFactory_AArch64IntegerArithmeticSnippets implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_AArch64IntegerArithmeticSnippets_safeDiv__0(), org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.class, "safeDiv", int.class, int.class);
        plugins.register(new Plugin_AArch64IntegerArithmeticSnippets_safeDiv__1(), org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.class, "safeDiv", long.class, long.class);
        plugins.register(new Plugin_AArch64IntegerArithmeticSnippets_safeRem__2(), org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.class, "safeRem", int.class, int.class);
        plugins.register(new Plugin_AArch64IntegerArithmeticSnippets_safeRem__3(), org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.class, "safeRem", long.class, long.class);
        plugins.register(new Plugin_AArch64IntegerArithmeticSnippets_safeUDiv__4(), org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.class, "safeUDiv", int.class, int.class);
        plugins.register(new Plugin_AArch64IntegerArithmeticSnippets_safeUDiv__5(), org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.class, "safeUDiv", long.class, long.class);
        plugins.register(new Plugin_AArch64IntegerArithmeticSnippets_safeURem__6(), org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.class, "safeURem", int.class, int.class);
        plugins.register(new Plugin_AArch64IntegerArithmeticSnippets_safeURem__7(), org.graalvm.compiler.replacements.aarch64.AArch64IntegerArithmeticSnippets.class, "safeURem", long.class, long.class);
    }
}
