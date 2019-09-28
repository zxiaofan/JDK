// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.hotspot.replacements;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import org.graalvm.compiler.nodes.ConstantNode;

//        class: org.graalvm.compiler.hotspot.replacements.DigestBaseSubstitutions
//       method: useSHA1Intrinsics(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_DigestBaseSubstitutions_useSHA1Intrinsics extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        boolean result = org.graalvm.compiler.hotspot.replacements.DigestBaseSubstitutions.useSHA1Intrinsics(arg0);
        JavaConstant constant = JavaConstant.forInt(result ? 1 : 0);
        ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
        b.push(JavaKind.Int, node);
        b.notifyReplacedCall(targetMethod, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.api.replacements.Fold.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

    Plugin_DigestBaseSubstitutions_useSHA1Intrinsics(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.DigestBaseSubstitutions
//       method: useSHA256Intrinsics(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_DigestBaseSubstitutions_useSHA256Intrinsics extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        boolean result = org.graalvm.compiler.hotspot.replacements.DigestBaseSubstitutions.useSHA256Intrinsics(arg0);
        JavaConstant constant = JavaConstant.forInt(result ? 1 : 0);
        ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
        b.push(JavaKind.Int, node);
        b.notifyReplacedCall(targetMethod, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.api.replacements.Fold.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

    Plugin_DigestBaseSubstitutions_useSHA256Intrinsics(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.DigestBaseSubstitutions
//       method: useSHA512Intrinsics(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_DigestBaseSubstitutions_useSHA512Intrinsics extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        boolean result = org.graalvm.compiler.hotspot.replacements.DigestBaseSubstitutions.useSHA512Intrinsics(arg0);
        JavaConstant constant = JavaConstant.forInt(result ? 1 : 0);
        ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
        b.push(JavaKind.Int, node);
        b.notifyReplacedCall(targetMethod, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.api.replacements.Fold.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

    Plugin_DigestBaseSubstitutions_useSHA512Intrinsics(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

public class PluginFactory_DigestBaseSubstitutions implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_DigestBaseSubstitutions_useSHA1Intrinsics(injection), org.graalvm.compiler.hotspot.replacements.DigestBaseSubstitutions.class, "useSHA1Intrinsics", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_DigestBaseSubstitutions_useSHA256Intrinsics(injection), org.graalvm.compiler.hotspot.replacements.DigestBaseSubstitutions.class, "useSHA256Intrinsics", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_DigestBaseSubstitutions_useSHA512Intrinsics(injection), org.graalvm.compiler.hotspot.replacements.DigestBaseSubstitutions.class, "useSHA512Intrinsics", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}
