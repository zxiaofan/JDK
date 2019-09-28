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

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: ageMaskInPlace(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_ageMaskInPlace extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.ageMaskInPlace(arg0);
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

    Plugin_HotSpotReplacementsUtil_ageMaskInPlace(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: allocateInstancePrefetchLines(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_allocateInstancePrefetchLines extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.allocateInstancePrefetchLines(arg0);
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

    Plugin_HotSpotReplacementsUtil_allocateInstancePrefetchLines(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: allocatePrefetchDistance(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_allocatePrefetchDistance extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.allocatePrefetchDistance(arg0);
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

    Plugin_HotSpotReplacementsUtil_allocatePrefetchDistance(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: allocatePrefetchLines(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_allocatePrefetchLines extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.allocatePrefetchLines(arg0);
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

    Plugin_HotSpotReplacementsUtil_allocatePrefetchLines(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: allocatePrefetchStepSize(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_allocatePrefetchStepSize extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.allocatePrefetchStepSize(arg0);
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

    Plugin_HotSpotReplacementsUtil_allocatePrefetchStepSize(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: allocatePrefetchStyle(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_allocatePrefetchStyle extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.allocatePrefetchStyle(arg0);
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

    Plugin_HotSpotReplacementsUtil_allocatePrefetchStyle(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: arrayClassElementOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_arrayClassElementOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.arrayClassElementOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_arrayClassElementOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: arrayKlassComponentMirrorOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_arrayKlassComponentMirrorOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.arrayKlassComponentMirrorOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_arrayKlassComponentMirrorOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: arrayKlassOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_arrayKlassOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.arrayKlassOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_arrayKlassOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: arrayLengthOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_arrayLengthOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.arrayLengthOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_arrayLengthOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: backedgeCounterOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_backedgeCounterOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.backedgeCounterOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_backedgeCounterOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: biasedLockMaskInPlace(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_biasedLockMaskInPlace extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.biasedLockMaskInPlace(arg0);
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

    Plugin_HotSpotReplacementsUtil_biasedLockMaskInPlace(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: biasedLockPattern(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_biasedLockPattern extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.biasedLockPattern(arg0);
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

    Plugin_HotSpotReplacementsUtil_biasedLockPattern(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: cardTableShift(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_cardTableShift extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.cardTableShift(arg0);
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

    Plugin_HotSpotReplacementsUtil_cardTableShift(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: dirtyCardValue(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_dirtyCardValue extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        byte result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.dirtyCardValue(arg0);
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

    Plugin_HotSpotReplacementsUtil_dirtyCardValue(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: epochMaskInPlace(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_epochMaskInPlace extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.epochMaskInPlace(arg0);
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

    Plugin_HotSpotReplacementsUtil_epochMaskInPlace(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: g1CardQueueBufferOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_g1CardQueueBufferOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.g1CardQueueBufferOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_g1CardQueueBufferOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: g1CardQueueIndexOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_g1CardQueueIndexOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.g1CardQueueIndexOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_g1CardQueueIndexOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: g1SATBQueueBufferOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_g1SATBQueueBufferOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.g1SATBQueueBufferOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_g1SATBQueueBufferOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: g1SATBQueueIndexOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_g1SATBQueueIndexOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.g1SATBQueueIndexOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_g1SATBQueueIndexOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: g1SATBQueueMarkingOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_g1SATBQueueMarkingOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.g1SATBQueueMarkingOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_g1SATBQueueMarkingOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: g1YoungCardValue(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_g1YoungCardValue extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        byte result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.g1YoungCardValue(arg0);
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

    Plugin_HotSpotReplacementsUtil_g1YoungCardValue(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: gcTotalCollectionsAddress(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_gcTotalCollectionsAddress extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        long result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.gcTotalCollectionsAddress(arg0);
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

    Plugin_HotSpotReplacementsUtil_gcTotalCollectionsAddress(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: getFieldOffset(jdk.vm.ci.meta.ResolvedJavaType,java.lang.String)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_getFieldOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        jdk.vm.ci.meta.ResolvedJavaType arg0;
        if (args[0].isConstant()) {
            jdk.vm.ci.meta.JavaConstant cst = args[0].asJavaConstant();
            arg0 = b.getConstantReflection().asJavaType(cst);
            if (arg0 == null) {
                arg0 = snippetReflection.asObject(jdk.vm.ci.meta.ResolvedJavaType.class, cst);
            }
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        java.lang.String arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(java.lang.String.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.getFieldOffset(arg0, arg1);
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

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_HotSpotReplacementsUtil_getFieldOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: getHeapWordSize(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_getHeapWordSize extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.getHeapWordSize(arg0);
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

    Plugin_HotSpotReplacementsUtil_getHeapWordSize(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: getType(org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext,java.lang.String)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_getType extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext arg0 = b.getIntrinsic();
        java.lang.String arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(java.lang.String.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.ResolvedJavaType result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.getType(arg0, arg1);
        JavaConstant constant = snippetReflection.forObject(result);
        ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
        b.push(JavaKind.Object, node);
        b.notifyReplacedCall(targetMethod, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.api.replacements.Fold.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_HotSpotReplacementsUtil_getType(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: getWordKind()
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_getWordKind extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        jdk.vm.ci.meta.JavaKind result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.getWordKind();
        JavaConstant constant = snippetReflection.forObject(result);
        ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
        b.push(JavaKind.Object, node);
        b.notifyReplacedCall(targetMethod, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.api.replacements.Fold.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_HotSpotReplacementsUtil_getWordKind(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: hubOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_hubOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.hubOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_hubOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: identityHashCode(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,java.lang.Object)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotReplacementsUtil_identityHashCode extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg1 = injectedForeignCallsProvider;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg2;
        if (args[0].isConstant()) {
            arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[1];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotReplacementsUtil_identityHashCode(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: identityHashCodeShift(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_identityHashCodeShift extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.identityHashCodeShift(arg0);
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

    Plugin_HotSpotReplacementsUtil_identityHashCodeShift(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: instanceHeaderSize(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_instanceHeaderSize extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.instanceHeaderSize(arg0);
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

    Plugin_HotSpotReplacementsUtil_instanceHeaderSize(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: instanceKlassInitStateOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_instanceKlassInitStateOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.instanceKlassInitStateOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_instanceKlassInitStateOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: instanceKlassStateFullyInitialized(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_instanceKlassStateFullyInitialized extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.instanceKlassStateFullyInitialized(arg0);
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

    Plugin_HotSpotReplacementsUtil_instanceKlassStateFullyInitialized(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: invocationCounterIncrement(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_invocationCounterIncrement extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.invocationCounterIncrement(arg0);
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

    Plugin_HotSpotReplacementsUtil_invocationCounterIncrement(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: invocationCounterOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_invocationCounterOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.invocationCounterOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_invocationCounterOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: invocationCounterShift(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_invocationCounterShift extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.invocationCounterShift(arg0);
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

    Plugin_HotSpotReplacementsUtil_invocationCounterShift(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: jvmAccWrittenFlags(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_jvmAccWrittenFlags extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.jvmAccWrittenFlags(arg0);
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

    Plugin_HotSpotReplacementsUtil_jvmAccWrittenFlags(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: klassAccessFlagsOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_klassAccessFlagsOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.klassAccessFlagsOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_klassAccessFlagsOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: klassLayoutHelperNeutralValue(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_klassLayoutHelperNeutralValue extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.klassLayoutHelperNeutralValue(arg0);
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

    Plugin_HotSpotReplacementsUtil_klassLayoutHelperNeutralValue(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: klassModifierFlagsOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_klassModifierFlagsOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.klassModifierFlagsOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_klassModifierFlagsOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: klassSuperKlassOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_klassSuperKlassOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.klassSuperKlassOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_klassSuperKlassOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: layoutHelperHeaderSizeMask(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_layoutHelperHeaderSizeMask extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.layoutHelperHeaderSizeMask(arg0);
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

    Plugin_HotSpotReplacementsUtil_layoutHelperHeaderSizeMask(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: layoutHelperHeaderSizeShift(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_layoutHelperHeaderSizeShift extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.layoutHelperHeaderSizeShift(arg0);
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

    Plugin_HotSpotReplacementsUtil_layoutHelperHeaderSizeShift(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: layoutHelperLog2ElementSizeMask(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_layoutHelperLog2ElementSizeMask extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.layoutHelperLog2ElementSizeMask(arg0);
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

    Plugin_HotSpotReplacementsUtil_layoutHelperLog2ElementSizeMask(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: layoutHelperLog2ElementSizeShift(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_layoutHelperLog2ElementSizeShift extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.layoutHelperLog2ElementSizeShift(arg0);
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

    Plugin_HotSpotReplacementsUtil_layoutHelperLog2ElementSizeShift(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: loadHubIntrinsic(java.lang.Object)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_HotSpotReplacementsUtil_loadHubIntrinsic extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.nodes.spi.StampProvider arg0 = b.getStampProvider();
        ValueNode arg1 = args[0];
        org.graalvm.compiler.nodes.extended.LoadHubNode node = new org.graalvm.compiler.nodes.extended.LoadHubNode(arg0, arg1);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: loadKlassFromObjectIntrinsic(java.lang.Object,long,jdk.internal.vm.compiler.word.LocationIdentity,jdk.vm.ci.meta.JavaKind)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_HotSpotReplacementsUtil_loadKlassFromObjectIntrinsic extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        ValueNode arg1 = args[0];
        ValueNode arg2 = args[1];
        jdk.internal.vm.compiler.word.LocationIdentity arg3;
        if (args[2].isConstant()) {
            arg3 = snippetReflection.asObject(jdk.internal.vm.compiler.word.LocationIdentity.class, args[2].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg4;
        if (args[3].isConstant()) {
            arg4 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[3].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.nodes.extended.RawLoadNode node = new org.graalvm.compiler.nodes.extended.RawLoadNode(arg0, arg1, arg2, arg3, arg4);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotReplacementsUtil_loadKlassFromObjectIntrinsic(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(org.graalvm.compiler.hotspot.word.KlassPointer.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: loadWordFromObjectIntrinsic(java.lang.Object,long,jdk.internal.vm.compiler.word.LocationIdentity,jdk.vm.ci.meta.JavaKind)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_HotSpotReplacementsUtil_loadWordFromObjectIntrinsic extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        ValueNode arg1 = args[0];
        ValueNode arg2 = args[1];
        jdk.internal.vm.compiler.word.LocationIdentity arg3;
        if (args[2].isConstant()) {
            arg3 = snippetReflection.asObject(jdk.internal.vm.compiler.word.LocationIdentity.class, args[2].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg4;
        if (args[3].isConstant()) {
            arg4 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[3].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.nodes.extended.RawLoadNode node = new org.graalvm.compiler.nodes.extended.RawLoadNode(arg0, arg1, arg2, arg3, arg4);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotReplacementsUtil_loadWordFromObjectIntrinsic(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(org.graalvm.compiler.word.Word.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: lockDisplacedMarkOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_lockDisplacedMarkOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.lockDisplacedMarkOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_lockDisplacedMarkOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: markOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_markOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.markOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_markOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: metaspaceArrayBaseOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_metaspaceArrayBaseOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.metaspaceArrayBaseOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_metaspaceArrayBaseOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: metaspaceArrayLengthOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_metaspaceArrayLengthOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.metaspaceArrayLengthOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_metaspaceArrayLengthOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: methodHolderClass(org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_methodHolderClass extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext arg0 = b.getIntrinsic();
        jdk.vm.ci.meta.ResolvedJavaType result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.methodHolderClass(arg0);
        JavaConstant constant = snippetReflection.forObject(result);
        ConstantNode node = ConstantNode.forConstant(constant, b.getMetaAccess(), b.getGraph());
        b.push(JavaKind.Object, node);
        b.notifyReplacedCall(targetMethod, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.api.replacements.Fold.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_HotSpotReplacementsUtil_methodHolderClass(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: monitorMask(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_monitorMask extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.monitorMask(arg0);
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

    Plugin_HotSpotReplacementsUtil_monitorMask(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: objectAlignment(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_objectAlignment extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.objectAlignment(arg0);
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

    Plugin_HotSpotReplacementsUtil_objectAlignment(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: objectMonitorCxqOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_objectMonitorCxqOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.objectMonitorCxqOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_objectMonitorCxqOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: objectMonitorEntryListOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_objectMonitorEntryListOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.objectMonitorEntryListOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_objectMonitorEntryListOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: objectMonitorOwnerOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_objectMonitorOwnerOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.objectMonitorOwnerOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_objectMonitorOwnerOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: objectMonitorRecursionsOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_objectMonitorRecursionsOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.objectMonitorRecursionsOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_objectMonitorRecursionsOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: objectMonitorSuccOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_objectMonitorSuccOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.objectMonitorSuccOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_objectMonitorSuccOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: osThreadInterruptedOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_osThreadInterruptedOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.osThreadInterruptedOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_osThreadInterruptedOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: osThreadOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_osThreadOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.osThreadOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_osThreadOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: pageSize(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_pageSize extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.pageSize(arg0);
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

    Plugin_HotSpotReplacementsUtil_pageSize(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: prototypeMarkWordOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_prototypeMarkWordOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.prototypeMarkWordOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_prototypeMarkWordOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: readLayoutHelper(org.graalvm.compiler.hotspot.word.KlassPointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotReplacementsUtil_readLayoutHelper extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        ValueNode arg1 = args[0];
        return org.graalvm.compiler.hotspot.replacements.KlassLayoutHelperNode.intrinsify(b, targetMethod, arg0, arg1);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

    Plugin_HotSpotReplacementsUtil_readLayoutHelper(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: referentOffset(jdk.vm.ci.meta.MetaAccessProvider)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_referentOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        jdk.vm.ci.meta.MetaAccessProvider arg0 = b.getMetaAccess();
        long result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.referentOffset(arg0);
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
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: registerAsWord(jdk.vm.ci.code.Register,boolean,boolean)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_HotSpotReplacementsUtil_registerAsWord extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        jdk.vm.ci.code.Register arg1;
        if (args[0].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.code.Register.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[1].isConstant()) {
            arg2 = args[1].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg3;
        if (args[2].isConstant()) {
            arg3 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.replacements.nodes.ReadRegisterNode node = new org.graalvm.compiler.replacements.nodes.ReadRegisterNode(arg0, arg1, arg2, arg3);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotReplacementsUtil_registerAsWord(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(org.graalvm.compiler.word.Word.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: secondarySuperCacheOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_secondarySuperCacheOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.secondarySuperCacheOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_secondarySuperCacheOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: secondarySupersOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_secondarySupersOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.secondarySupersOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_secondarySupersOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: stackBias(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_stackBias extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.stackBias(arg0);
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

    Plugin_HotSpotReplacementsUtil_stackBias(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: superCheckOffsetOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_superCheckOffsetOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.superCheckOffsetOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_superCheckOffsetOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: threadExceptionOopOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_threadExceptionOopOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.threadExceptionOopOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_threadExceptionOopOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: threadExceptionPcOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_threadExceptionPcOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.threadExceptionPcOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_threadExceptionPcOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: threadObjectOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_threadObjectOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.threadObjectOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_threadObjectOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: threadPendingExceptionOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_threadPendingExceptionOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.threadPendingExceptionOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_threadPendingExceptionOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: threadTlabEndOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_threadTlabEndOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.threadTlabEndOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_threadTlabEndOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: threadTlabTopOffset(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_threadTlabTopOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.threadTlabTopOffset(arg0);
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

    Plugin_HotSpotReplacementsUtil_threadTlabTopOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: uninitializedIdentityHashCodeValue(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_uninitializedIdentityHashCodeValue extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.uninitializedIdentityHashCodeValue(arg0);
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

    Plugin_HotSpotReplacementsUtil_uninitializedIdentityHashCodeValue(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: unlockedMask(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_unlockedMask extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.unlockedMask(arg0);
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

    Plugin_HotSpotReplacementsUtil_unlockedMask(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: useBiasedLocking(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_useBiasedLocking extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        boolean result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.useBiasedLocking(arg0);
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

    Plugin_HotSpotReplacementsUtil_useBiasedLocking(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: useTLAB(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_useTLAB extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        boolean result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.useTLAB(arg0);
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

    Plugin_HotSpotReplacementsUtil_useTLAB(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: verifyOopStub(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,java.lang.Object)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotReplacementsUtil_verifyOopStub extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg1 = injectedForeignCallsProvider;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg2;
        if (args[0].isConstant()) {
            arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[1];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotReplacementsUtil_verifyOopStub(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: verifyOops(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_verifyOops extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        boolean result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.verifyOops(arg0);
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

    Plugin_HotSpotReplacementsUtil_verifyOops(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: wordSize()
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotReplacementsUtil_wordSize extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.wordSize();
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
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil
//       method: writeRegisterAsWord(jdk.vm.ci.code.Register,org.graalvm.compiler.word.Word)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_HotSpotReplacementsUtil_writeRegisterAsWord extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        jdk.vm.ci.code.Register arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.code.Register.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg1 = args[1];
        org.graalvm.compiler.replacements.nodes.WriteRegisterNode node = new org.graalvm.compiler.replacements.nodes.WriteRegisterNode(arg0, arg1);
        b.add(node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_HotSpotReplacementsUtil_writeRegisterAsWord(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_HotSpotReplacementsUtil implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_HotSpotReplacementsUtil_ageMaskInPlace(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "ageMaskInPlace", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_allocateInstancePrefetchLines(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "allocateInstancePrefetchLines", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_allocatePrefetchDistance(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "allocatePrefetchDistance", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_allocatePrefetchLines(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "allocatePrefetchLines", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_allocatePrefetchStepSize(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "allocatePrefetchStepSize", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_allocatePrefetchStyle(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "allocatePrefetchStyle", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_arrayClassElementOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "arrayClassElementOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_arrayKlassComponentMirrorOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "arrayKlassComponentMirrorOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_arrayKlassOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "arrayKlassOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_arrayLengthOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "arrayLengthOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_backedgeCounterOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "backedgeCounterOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_biasedLockMaskInPlace(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "biasedLockMaskInPlace", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_biasedLockPattern(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "biasedLockPattern", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_cardTableShift(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "cardTableShift", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_dirtyCardValue(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "dirtyCardValue", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_epochMaskInPlace(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "epochMaskInPlace", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_g1CardQueueBufferOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "g1CardQueueBufferOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_g1CardQueueIndexOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "g1CardQueueIndexOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_g1SATBQueueBufferOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "g1SATBQueueBufferOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_g1SATBQueueIndexOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "g1SATBQueueIndexOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_g1SATBQueueMarkingOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "g1SATBQueueMarkingOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_g1YoungCardValue(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "g1YoungCardValue", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_gcTotalCollectionsAddress(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "gcTotalCollectionsAddress", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_getFieldOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "getFieldOffset", jdk.vm.ci.meta.ResolvedJavaType.class, java.lang.String.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_getHeapWordSize(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "getHeapWordSize", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_getType(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "getType", org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.class, java.lang.String.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_getWordKind(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "getWordKind");
        plugins.register(new Plugin_HotSpotReplacementsUtil_hubOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "hubOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_identityHashCode(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "identityHashCode", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, java.lang.Object.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_identityHashCodeShift(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "identityHashCodeShift", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_instanceHeaderSize(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "instanceHeaderSize", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_instanceKlassInitStateOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "instanceKlassInitStateOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_instanceKlassStateFullyInitialized(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "instanceKlassStateFullyInitialized", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_invocationCounterIncrement(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "invocationCounterIncrement", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_invocationCounterOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "invocationCounterOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_invocationCounterShift(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "invocationCounterShift", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_jvmAccWrittenFlags(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "jvmAccWrittenFlags", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_klassAccessFlagsOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "klassAccessFlagsOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_klassLayoutHelperNeutralValue(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "klassLayoutHelperNeutralValue", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_klassModifierFlagsOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "klassModifierFlagsOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_klassSuperKlassOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "klassSuperKlassOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_layoutHelperHeaderSizeMask(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "layoutHelperHeaderSizeMask", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_layoutHelperHeaderSizeShift(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "layoutHelperHeaderSizeShift", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_layoutHelperLog2ElementSizeMask(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "layoutHelperLog2ElementSizeMask", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_layoutHelperLog2ElementSizeShift(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "layoutHelperLog2ElementSizeShift", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_loadHubIntrinsic(), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "loadHubIntrinsic", java.lang.Object.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_loadKlassFromObjectIntrinsic(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "loadKlassFromObjectIntrinsic", java.lang.Object.class, long.class, jdk.internal.vm.compiler.word.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_loadWordFromObjectIntrinsic(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "loadWordFromObjectIntrinsic", java.lang.Object.class, long.class, jdk.internal.vm.compiler.word.LocationIdentity.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_lockDisplacedMarkOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "lockDisplacedMarkOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_markOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "markOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_metaspaceArrayBaseOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "metaspaceArrayBaseOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_metaspaceArrayLengthOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "metaspaceArrayLengthOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_methodHolderClass(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "methodHolderClass", org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_monitorMask(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "monitorMask", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_objectAlignment(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "objectAlignment", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_objectMonitorCxqOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "objectMonitorCxqOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_objectMonitorEntryListOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "objectMonitorEntryListOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_objectMonitorOwnerOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "objectMonitorOwnerOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_objectMonitorRecursionsOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "objectMonitorRecursionsOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_objectMonitorSuccOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "objectMonitorSuccOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_osThreadInterruptedOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "osThreadInterruptedOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_osThreadOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "osThreadOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_pageSize(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "pageSize", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_prototypeMarkWordOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "prototypeMarkWordOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_readLayoutHelper(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "readLayoutHelper", org.graalvm.compiler.hotspot.word.KlassPointer.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_referentOffset(), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "referentOffset", jdk.vm.ci.meta.MetaAccessProvider.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_registerAsWord(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "registerAsWord", jdk.vm.ci.code.Register.class, boolean.class, boolean.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_secondarySuperCacheOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "secondarySuperCacheOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_secondarySupersOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "secondarySupersOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_stackBias(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "stackBias", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_superCheckOffsetOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "superCheckOffsetOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_threadExceptionOopOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "threadExceptionOopOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_threadExceptionPcOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "threadExceptionPcOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_threadObjectOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "threadObjectOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_threadPendingExceptionOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "threadPendingExceptionOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_threadTlabEndOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "threadTlabEndOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_threadTlabTopOffset(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "threadTlabTopOffset", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_uninitializedIdentityHashCodeValue(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "uninitializedIdentityHashCodeValue", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_unlockedMask(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "unlockedMask", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_useBiasedLocking(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "useBiasedLocking", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_useTLAB(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "useTLAB", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_verifyOopStub(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "verifyOopStub", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, java.lang.Object.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_verifyOops(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "verifyOops", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotReplacementsUtil_wordSize(), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "wordSize");
        plugins.register(new Plugin_HotSpotReplacementsUtil_writeRegisterAsWord(injection), org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil.class, "writeRegisterAsWord", jdk.vm.ci.code.Register.class, org.graalvm.compiler.word.Word.class);
    }
}
