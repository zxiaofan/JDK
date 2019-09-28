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

//        class: org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions
//       method: aesCryptType(org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_CipherBlockChainingSubstitutions_aesCryptType extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext arg0 = b.getIntrinsic();
        jdk.vm.ci.meta.ResolvedJavaType result = org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions.aesCryptType(arg0);
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

    Plugin_CipherBlockChainingSubstitutions_aesCryptType(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions
//       method: decryptAESCryptStub(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,jdk.internal.vm.compiler.word.Pointer,jdk.internal.vm.compiler.word.Pointer,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_CipherBlockChainingSubstitutions_decryptAESCryptStub extends GeneratedInvocationPlugin {

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
        ValueNode arg7 = args[5];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_CipherBlockChainingSubstitutions_decryptAESCryptStub(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(void.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions
//       method: decryptAESCryptWithOriginalKeyStub(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,jdk.internal.vm.compiler.word.Pointer,jdk.internal.vm.compiler.word.Pointer,int,jdk.internal.vm.compiler.word.Pointer)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_CipherBlockChainingSubstitutions_decryptAESCryptWithOriginalKeyStub extends GeneratedInvocationPlugin {

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
        ValueNode arg7 = args[5];
        ValueNode arg8 = args[6];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_CipherBlockChainingSubstitutions_decryptAESCryptWithOriginalKeyStub(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(void.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions
//       method: embeddedCipherOffset(org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_CipherBlockChainingSubstitutions_embeddedCipherOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext arg0 = b.getIntrinsic();
        long result = org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions.embeddedCipherOffset(arg0);
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

//        class: org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions
//       method: encryptAESCryptStub(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,org.graalvm.compiler.word.Word,org.graalvm.compiler.word.Word,jdk.internal.vm.compiler.word.Pointer,jdk.internal.vm.compiler.word.Pointer,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_CipherBlockChainingSubstitutions_encryptAESCryptStub extends GeneratedInvocationPlugin {

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
        ValueNode arg7 = args[5];
        return org.graalvm.compiler.nodes.extended.ForeignCallNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.core.common.spi.ForeignCallsProvider injectedForeignCallsProvider;
    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_CipherBlockChainingSubstitutions_encryptAESCryptStub(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(void.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions
//       method: rOffset(org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_CipherBlockChainingSubstitutions_rOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext arg0 = b.getIntrinsic();
        long result = org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions.rOffset(arg0);
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

public class PluginFactory_CipherBlockChainingSubstitutions implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_CipherBlockChainingSubstitutions_aesCryptType(injection), org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions.class, "aesCryptType", org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.class);
        plugins.register(new Plugin_CipherBlockChainingSubstitutions_decryptAESCryptStub(injection), org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions.class, "decryptAESCryptStub", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, jdk.internal.vm.compiler.word.Pointer.class, jdk.internal.vm.compiler.word.Pointer.class, int.class);
        plugins.register(new Plugin_CipherBlockChainingSubstitutions_decryptAESCryptWithOriginalKeyStub(injection), org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions.class, "decryptAESCryptWithOriginalKeyStub", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, jdk.internal.vm.compiler.word.Pointer.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, jdk.internal.vm.compiler.word.Pointer.class);
        plugins.register(new Plugin_CipherBlockChainingSubstitutions_embeddedCipherOffset(), org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions.class, "embeddedCipherOffset", org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.class);
        plugins.register(new Plugin_CipherBlockChainingSubstitutions_encryptAESCryptStub(injection), org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions.class, "encryptAESCryptStub", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, org.graalvm.compiler.word.Word.class, org.graalvm.compiler.word.Word.class, jdk.internal.vm.compiler.word.Pointer.class, jdk.internal.vm.compiler.word.Pointer.class, int.class);
        plugins.register(new Plugin_CipherBlockChainingSubstitutions_rOffset(), org.graalvm.compiler.hotspot.replacements.CipherBlockChainingSubstitutions.class, "rOffset", org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.class);
    }
}
