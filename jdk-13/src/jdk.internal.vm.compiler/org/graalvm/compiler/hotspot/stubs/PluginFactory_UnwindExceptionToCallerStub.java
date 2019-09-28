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

//        class: org.graalvm.compiler.hotspot.stubs.UnwindExceptionToCallerStub
//       method: assertionsEnabled(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_UnwindExceptionToCallerStub_assertionsEnabled extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg0 = injectedGraalHotSpotVMConfig;
        boolean result = org.graalvm.compiler.hotspot.stubs.UnwindExceptionToCallerStub.assertionsEnabled(arg0);
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

    Plugin_UnwindExceptionToCallerStub_assertionsEnabled(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
    }
}

//        class: org.graalvm.compiler.hotspot.stubs.UnwindExceptionToCallerStub
//       method: exceptionHandlerForReturnAddress(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_UnwindExceptionToCallerStub_exceptionHandlerForReturnAddress extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.core.common.spi.ForeignCallsProvider arg0 = injectedForeignCallsProvider;
        org.graalvm.compiler.core.common.type.Stamp arg1 = stamp;
        org.graalvm.compiler.core.common.spi.ForeignCallDescriptor arg2;
        if (args[0].isConstant()) {
            arg2 = snippetReflection.asObject(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[1];
        ValueNode arg4 = args[2];
        org.graalvm.compiler.hotspot.nodes.StubForeignCallNode node = new org.graalvm.compiler.hotspot.nodes.StubForeignCallNode(arg0, arg1, arg2, arg3, arg4);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_UnwindExceptionToCallerStub_exceptionHandlerForReturnAddress(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(org.graalvm.compiler.word.Word.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.stubs.UnwindExceptionToCallerStub
//       method: logging(org.graalvm.compiler.options.OptionValues)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_UnwindExceptionToCallerStub_logging extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.options.OptionValues arg0 = b.getOptions();
        boolean result = org.graalvm.compiler.hotspot.stubs.UnwindExceptionToCallerStub.logging(arg0);
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

public class PluginFactory_UnwindExceptionToCallerStub implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_UnwindExceptionToCallerStub_assertionsEnabled(injection), org.graalvm.compiler.hotspot.stubs.UnwindExceptionToCallerStub.class, "assertionsEnabled", org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        plugins.register(new Plugin_UnwindExceptionToCallerStub_exceptionHandlerForReturnAddress(injection), org.graalvm.compiler.hotspot.stubs.UnwindExceptionToCallerStub.class, "exceptionHandlerForReturnAddress", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class);
        plugins.register(new Plugin_UnwindExceptionToCallerStub_logging(), org.graalvm.compiler.hotspot.stubs.UnwindExceptionToCallerStub.class, "logging", org.graalvm.compiler.options.OptionValues.class);
    }
}
