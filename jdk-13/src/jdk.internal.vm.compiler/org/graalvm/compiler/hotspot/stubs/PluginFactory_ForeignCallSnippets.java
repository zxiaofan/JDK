// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.hotspot.stubs;

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

//        class: org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets
//       method: objectResultOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_ForeignCallSnippets_objectResultOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets.objectResultOffset(arg0);
        JavaConstant constant = JavaConstant.forInt(result);
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

    Plugin_ForeignCallSnippets_objectResultOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets
//       method: verifyOopBits(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_ForeignCallSnippets_verifyOopBits extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        long result = org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets.verifyOopBits(arg0);
        JavaConstant constant = JavaConstant.forLong(result);
        ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
        b.push(JavaKind.Long, node);
        b.notifyReplacedCall(targetMethod, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.api.replacements.Fold.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

    Plugin_ForeignCallSnippets_verifyOopBits(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets
//       method: verifyOopCounterAddress(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_ForeignCallSnippets_verifyOopCounterAddress extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        long result = org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets.verifyOopCounterAddress(arg0);
        JavaConstant constant = JavaConstant.forLong(result);
        ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
        b.push(JavaKind.Long, node);
        b.notifyReplacedCall(targetMethod, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.api.replacements.Fold.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

    Plugin_ForeignCallSnippets_verifyOopCounterAddress(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets
//       method: verifyOopMask(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_ForeignCallSnippets_verifyOopMask extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        long result = org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets.verifyOopMask(arg0);
        JavaConstant constant = JavaConstant.forLong(result);
        ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
        b.push(JavaKind.Long, node);
        b.notifyReplacedCall(targetMethod, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.api.replacements.Fold.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

    Plugin_ForeignCallSnippets_verifyOopMask(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

public class PluginFactory_ForeignCallSnippets implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_ForeignCallSnippets_objectResultOffset(injection), org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets.class, "objectResultOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_ForeignCallSnippets_verifyOopBits(injection), org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets.class, "verifyOopBits", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_ForeignCallSnippets_verifyOopCounterAddress(injection), org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets.class, "verifyOopCounterAddress", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_ForeignCallSnippets_verifyOopMask(injection), org.graalvm.compiler.hotspot.stubs.ForeignCallSnippets.class, "verifyOopMask", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}
