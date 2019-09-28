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

//        class: org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions
//       method: decryptBlockStub(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,jdk.internal.vm.compiler.word.Pointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AESCryptSubstitutions_decryptBlockStub extends GeneratedInvocationPlugin {

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

    Plugin_AESCryptSubstitutions_decryptBlockStub(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(void.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions
//       method: decryptBlockWithOriginalKeyStub(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,jdk.internal.vm.compiler.word.Pointer,jdk.internal.vm.compiler.word.Pointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AESCryptSubstitutions_decryptBlockWithOriginalKeyStub extends GeneratedInvocationPlugin {

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
        ValueNode arg6 = args[4];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_AESCryptSubstitutions_decryptBlockWithOriginalKeyStub(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(void.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions
//       method: encryptBlockStub(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,jdk.internal.vm.compiler.word.Pointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AESCryptSubstitutions_encryptBlockStub extends GeneratedInvocationPlugin {

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

    Plugin_AESCryptSubstitutions_encryptBlockStub(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(void.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions
//       method: kOffset(org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_AESCryptSubstitutions_kOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext arg0 = b.getIntrinsic();
        long result = org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions.kOffset(arg0);
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

//        class: org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions
//       method: lastKeyOffset(org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_AESCryptSubstitutions_lastKeyOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext arg0 = b.getIntrinsic();
        long result = org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions.lastKeyOffset(arg0);
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

public class PluginFactory_AESCryptSubstitutions implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_AESCryptSubstitutions_decryptBlockStub(injection), org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions.class, "decryptBlockStub", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, jdk.internal.vm.compiler.word.Pointer.class);
        plugins.register(new Plugin_AESCryptSubstitutions_decryptBlockWithOriginalKeyStub(injection), org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions.class, "decryptBlockWithOriginalKeyStub", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, jdk.internal.vm.compiler.word.Pointer.class, jdk.internal.vm.compiler.word.Pointer.class);
        plugins.register(new Plugin_AESCryptSubstitutions_encryptBlockStub(injection), org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions.class, "encryptBlockStub", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, jdk.internal.vm.compiler.word.Pointer.class);
        plugins.register(new Plugin_AESCryptSubstitutions_kOffset(), org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions.class, "kOffset", org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.class);
        plugins.register(new Plugin_AESCryptSubstitutions_lastKeyOffset(), org.graalvm.compiler.hotspot.replacements.AESCryptSubstitutions.class, "lastKeyOffset", org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.class);
    }
}
