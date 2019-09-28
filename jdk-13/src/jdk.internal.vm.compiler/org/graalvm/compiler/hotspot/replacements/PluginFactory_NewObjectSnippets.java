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

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: createName(org.graalvm.compiler.options.OptionValues,java.lang.String,java.lang.String)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_NewObjectSnippets_createName extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.options.OptionValues arg0 = b.getOptions();
        java.lang.String arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(java.lang.String.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        java.lang.String arg2;
        if (args[2].isConstant()) {
            arg2 = snippetReflection.asObject(java.lang.String.class, args[2].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        java.lang.String result = org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.createName(arg0, arg1, arg2);
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

    Plugin_NewObjectSnippets_createName(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: doProfile(org.graalvm.compiler.options.OptionValues)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_NewObjectSnippets_doProfile extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.options.OptionValues arg0 = b.getOptions();
        boolean result = org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.doProfile(arg0);
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

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: dynamicNewInstance(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,java.lang.Class<?>)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_NewObjectSnippets_dynamicNewInstance extends GeneratedInvocationPlugin {

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

    Plugin_NewObjectSnippets_dynamicNewInstance(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, true);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: dynamicNewInstanceOrNull(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,java.lang.Class<?>)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_NewObjectSnippets_dynamicNewInstanceOrNull extends GeneratedInvocationPlugin {

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

    Plugin_NewObjectSnippets_dynamicNewInstanceOrNull(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: getMinimalBulkZeroingSize(org.graalvm.compiler.options.OptionValues)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_NewObjectSnippets_getMinimalBulkZeroingSize extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.options.OptionValues arg0 = b.getOptions();
        int result = org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.getMinimalBulkZeroingSize(arg0);
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

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: newArray(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_NewObjectSnippets_newArray extends GeneratedInvocationPlugin {

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
        ValueNode arg4 = args[2];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_NewObjectSnippets_newArray(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, true);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: newArrayOrNull(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_NewObjectSnippets_newArrayOrNull extends GeneratedInvocationPlugin {

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
        ValueNode arg4 = args[2];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_NewObjectSnippets_newArrayOrNull(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: newInstance(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_NewObjectSnippets_newInstance extends GeneratedInvocationPlugin {

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

    Plugin_NewObjectSnippets_newInstance(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, true);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: newInstanceOrNull(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_NewObjectSnippets_newInstanceOrNull extends GeneratedInvocationPlugin {

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

    Plugin_NewObjectSnippets_newInstanceOrNull(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: newMultiArray(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int,org.graalvm.compiler.word.Word)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_NewObjectSnippets_newMultiArray extends GeneratedInvocationPlugin {

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
        ValueNode arg4 = args[2];
        ValueNode arg5 = args[3];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4, arg5);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_NewObjectSnippets_newMultiArray(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, true);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: newMultiArrayOrNull(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.hotspot.word.KlassPointer,int,org.graalvm.compiler.word.Word)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_NewObjectSnippets_newMultiArrayOrNull extends GeneratedInvocationPlugin {

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
        ValueNode arg4 = args[2];
        ValueNode arg5 = args[3];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4, arg5);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_NewObjectSnippets_newMultiArrayOrNull(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(java.lang.Object.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: useNullAllocationStubs(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_NewObjectSnippets_useNullAllocationStubs extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        boolean result = org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.useNullAllocationStubs(arg0);
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

    Plugin_NewObjectSnippets_useNullAllocationStubs(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.NewObjectSnippets
//       method: withContext(org.graalvm.compiler.options.OptionValues)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_NewObjectSnippets_withContext extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.options.OptionValues arg0 = b.getOptions();
        boolean result = org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.withContext(arg0);
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

public class PluginFactory_NewObjectSnippets implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_NewObjectSnippets_createName(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "createName", org.graalvm.compiler.options.OptionValues.class, java.lang.String.class, java.lang.String.class);
        plugins.register(new Plugin_NewObjectSnippets_doProfile(), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "doProfile", org.graalvm.compiler.options.OptionValues.class);
        plugins.register(new Plugin_NewObjectSnippets_dynamicNewInstance(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "dynamicNewInstance", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, java.lang.Class.class);
        plugins.register(new Plugin_NewObjectSnippets_dynamicNewInstanceOrNull(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "dynamicNewInstanceOrNull", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, java.lang.Class.class);
        plugins.register(new Plugin_NewObjectSnippets_getMinimalBulkZeroingSize(), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "getMinimalBulkZeroingSize", org.graalvm.compiler.options.OptionValues.class);
        plugins.register(new Plugin_NewObjectSnippets_newArray(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "newArray", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class);
        plugins.register(new Plugin_NewObjectSnippets_newArrayOrNull(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "newArrayOrNull", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class);
        plugins.register(new Plugin_NewObjectSnippets_newInstance(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "newInstance", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class);
        plugins.register(new Plugin_NewObjectSnippets_newInstanceOrNull(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "newInstanceOrNull", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class);
        plugins.register(new Plugin_NewObjectSnippets_newMultiArray(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "newMultiArray", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class, org.graalvm.compiler.word.Word.class);
        plugins.register(new Plugin_NewObjectSnippets_newMultiArrayOrNull(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "newMultiArrayOrNull", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.hotspot.word.KlassPointer.class, int.class, org.graalvm.compiler.word.Word.class);
        plugins.register(new Plugin_NewObjectSnippets_useNullAllocationStubs(injection), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "useNullAllocationStubs", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_NewObjectSnippets_withContext(), org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.class, "withContext", org.graalvm.compiler.options.OptionValues.class);
    }
}
