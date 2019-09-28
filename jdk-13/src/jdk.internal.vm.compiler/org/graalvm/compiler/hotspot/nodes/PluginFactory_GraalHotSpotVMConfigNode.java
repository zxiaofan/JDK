// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.hotspot.nodes;

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

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: areConfigValuesConstant()
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_GraalHotSpotVMConfigNode_areConfigValuesConstant extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode node = new org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode(arg0);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;

    Plugin_GraalHotSpotVMConfigNode_areConfigValuesConstant(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: cardTableAddressMark(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_GraalHotSpotVMConfigNode_cardTableAddressMark extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.cardTableAddressMark(arg0);
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

    Plugin_GraalHotSpotVMConfigNode_cardTableAddressMark(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: crcTableAddressMark(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_GraalHotSpotVMConfigNode_crcTableAddressMark extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.crcTableAddressMark(arg0);
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

    Plugin_GraalHotSpotVMConfigNode_crcTableAddressMark(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: heapEndAddressMark(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_GraalHotSpotVMConfigNode_heapEndAddressMark extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.heapEndAddressMark(arg0);
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

    Plugin_GraalHotSpotVMConfigNode_heapEndAddressMark(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: heapTopAddressMark(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_GraalHotSpotVMConfigNode_heapTopAddressMark extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.heapTopAddressMark(arg0);
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

    Plugin_GraalHotSpotVMConfigNode_heapTopAddressMark(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: inlineContiguousAllocationSupportedMark(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_GraalHotSpotVMConfigNode_inlineContiguousAllocationSupportedMark extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.inlineContiguousAllocationSupportedMark(arg0);
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

    Plugin_GraalHotSpotVMConfigNode_inlineContiguousAllocationSupportedMark(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: loadByteConfigValue(int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_GraalHotSpotVMConfigNode_loadByteConfigValue extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg1 = injectedGraalHotSpotVMConfig;
        int arg2;
        if (args[0].isConstant()) {
            arg2 = args[0].asJavaConstant().asInt();
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode node = new org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode(arg0, arg1, arg2);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_GraalHotSpotVMConfigNode_loadByteConfigValue(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        this.stamp = injection.getInjectedStamp(byte.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: loadIntConfigValue(int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_GraalHotSpotVMConfigNode_loadIntConfigValue extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg1 = injectedGraalHotSpotVMConfig;
        int arg2;
        if (args[0].isConstant()) {
            arg2 = args[0].asJavaConstant().asInt();
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode node = new org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode(arg0, arg1, arg2);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_GraalHotSpotVMConfigNode_loadIntConfigValue(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: loadLongConfigValue(int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_GraalHotSpotVMConfigNode_loadLongConfigValue extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg1 = injectedGraalHotSpotVMConfig;
        int arg2;
        if (args[0].isConstant()) {
            arg2 = args[0].asJavaConstant().asInt();
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode node = new org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode(arg0, arg1, arg2);
        b.addPush(JavaKind.Long, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_GraalHotSpotVMConfigNode_loadLongConfigValue(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        this.stamp = injection.getInjectedStamp(long.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: logOfHeapRegionGrainBytesMark(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_GraalHotSpotVMConfigNode_logOfHeapRegionGrainBytesMark extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        int result = org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.logOfHeapRegionGrainBytesMark(arg0);
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

    Plugin_GraalHotSpotVMConfigNode_logOfHeapRegionGrainBytesMark(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

public class PluginFactory_GraalHotSpotVMConfigNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_areConfigValuesConstant(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "areConfigValuesConstant");
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_cardTableAddressMark(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "cardTableAddressMark", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_crcTableAddressMark(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "crcTableAddressMark", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_heapEndAddressMark(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "heapEndAddressMark", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_heapTopAddressMark(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "heapTopAddressMark", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_inlineContiguousAllocationSupportedMark(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "inlineContiguousAllocationSupportedMark", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_loadByteConfigValue(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "loadByteConfigValue", int.class);
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_loadIntConfigValue(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "loadIntConfigValue", int.class);
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_loadLongConfigValue(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "loadLongConfigValue", int.class);
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_logOfHeapRegionGrainBytesMark(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "logOfHeapRegionGrainBytesMark", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}
