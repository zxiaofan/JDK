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

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: createName(org.graalvm.compiler.options.OptionValues,org.graalvm.compiler.replacements.AllocationSnippets.AllocationProfilingData)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotAllocationSnippets_createName extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.options.OptionValues arg0 = b.getOptions();
        org.graalvm.compiler.replacements.AllocationSnippets.AllocationProfilingData arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.replacements.AllocationSnippets.AllocationProfilingData.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        java.lang.String result = org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.createName(arg0, arg1);
        JavaConstant constant = b.getConstantReflection().forString(result);
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

    Plugin_HotSpotAllocationSnippets_createName(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: doProfile(org.graalvm.compiler.options.OptionValues)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotAllocationSnippets_doProfile extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.options.OptionValues arg0 = b.getOptions();
        boolean result = org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.doProfile(arg0);
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
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: dynamicNewInstance(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,java.lang.Class<?>)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotAllocationSnippets_dynamicNewInstance extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg1;
        if (args[0].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg2 = args[1];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotAllocationSnippets_dynamicNewInstance(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, true);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: dynamicNewInstanceOrNull(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,java.lang.Class<?>)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotAllocationSnippets_dynamicNewInstanceOrNull extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg1;
        if (args[0].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg2 = args[1];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotAllocationSnippets_dynamicNewInstanceOrNull(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: getMinimalBulkZeroingSize(org.graalvm.compiler.options.OptionValues)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotAllocationSnippets_getMinimalBulkZeroingSize extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.options.OptionValues arg0 = b.getOptions();
        int result = org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.getMinimalBulkZeroingSize(arg0);
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

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: newArray(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotAllocationSnippets_newArray extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg1;
        if (args[0].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg2 = args[1];
        ValueNode arg3 = args[2];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotAllocationSnippets_newArray(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, true);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: newArrayOrNull(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotAllocationSnippets_newArrayOrNull extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg1;
        if (args[0].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg2 = args[1];
        ValueNode arg3 = args[2];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotAllocationSnippets_newArrayOrNull(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: newInstance(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotAllocationSnippets_newInstance extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg1;
        if (args[0].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg2 = args[1];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotAllocationSnippets_newInstance(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, true);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: newInstanceOrNull(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotAllocationSnippets_newInstanceOrNull extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg1;
        if (args[0].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg2 = args[1];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotAllocationSnippets_newInstanceOrNull(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: newMultiArray(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int,org.graalvm.compiler.word.Word)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotAllocationSnippets_newMultiArray extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg1;
        if (args[0].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg2 = args[1];
        ValueNode arg3 = args[2];
        ValueNode arg4 = args[3];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotAllocationSnippets_newMultiArray(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, true);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: newMultiArrayOrNull(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int,org.graalvm.compiler.word.Word)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_HotSpotAllocationSnippets_newMultiArrayOrNull extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg1;
        if (args[0].isConstant()) {
            arg1 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg2 = args[1];
        ValueNode arg3 = args[2];
        ValueNode arg4 = args[3];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_HotSpotAllocationSnippets_newMultiArrayOrNull(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: useNullAllocationStubs(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotAllocationSnippets_useNullAllocationStubs extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        boolean result = org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.useNullAllocationStubs(arg0);
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

    Plugin_HotSpotAllocationSnippets_useNullAllocationStubs(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets
//       method: withContext(org.graalvm.compiler.options.OptionValues)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_HotSpotAllocationSnippets_withContext extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.options.OptionValues arg0 = b.getOptions();
        boolean result = org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.withContext(arg0);
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
}

public class PluginFactory_HotSpotAllocationSnippets implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_HotSpotAllocationSnippets_createName(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "createName", org.graalvm.compiler.options.OptionValues.class, org.graalvm.compiler.replacements.AllocationSnippets.AllocationProfilingData.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_doProfile(), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "doProfile", org.graalvm.compiler.options.OptionValues.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_dynamicNewInstance(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "dynamicNewInstance", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, java.lang.Class.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_dynamicNewInstanceOrNull(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "dynamicNewInstanceOrNull", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, java.lang.Class.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_getMinimalBulkZeroingSize(), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "getMinimalBulkZeroingSize", org.graalvm.compiler.options.OptionValues.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_newArray(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "newArray", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_newArrayOrNull(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "newArrayOrNull", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_newInstance(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "newInstance", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_newInstanceOrNull(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "newInstanceOrNull", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_newMultiArray(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "newMultiArray", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class, org.graalvm.compiler.word.Word.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_newMultiArrayOrNull(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "newMultiArrayOrNull", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class, org.graalvm.compiler.word.Word.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_useNullAllocationStubs(injection), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "useNullAllocationStubs", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_HotSpotAllocationSnippets_withContext(), org.graalvm.compiler.hotspot.replacements.HotSpotAllocationSnippets.class, "withContext", org.graalvm.compiler.options.OptionValues.class);
    }
}
