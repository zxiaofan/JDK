// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.replacements.amd64;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf
//       method: callByte1(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,jdk.internal.vm.compiler.word.Pointer,int,byte)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AMD64ArrayIndexOf_callByte1 extends GeneratedInvocationPlugin {

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

    Plugin_AMD64ArrayIndexOf_callByte1(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf
//       method: callByte2(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,jdk.internal.vm.compiler.word.Pointer,int,byte,byte)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AMD64ArrayIndexOf_callByte2 extends GeneratedInvocationPlugin {

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

    Plugin_AMD64ArrayIndexOf_callByte2(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf
//       method: callByte3(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,jdk.internal.vm.compiler.word.Pointer,int,byte,byte,byte)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AMD64ArrayIndexOf_callByte3 extends GeneratedInvocationPlugin {

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

    Plugin_AMD64ArrayIndexOf_callByte3(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf
//       method: callByte4(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,jdk.internal.vm.compiler.word.Pointer,int,byte,byte,byte,byte)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AMD64ArrayIndexOf_callByte4 extends GeneratedInvocationPlugin {

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

    Plugin_AMD64ArrayIndexOf_callByte4(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf
//       method: callChar1(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,jdk.internal.vm.compiler.word.Pointer,int,char)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AMD64ArrayIndexOf_callChar1 extends GeneratedInvocationPlugin {

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

    Plugin_AMD64ArrayIndexOf_callChar1(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf
//       method: callChar2(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,jdk.internal.vm.compiler.word.Pointer,int,char,char)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AMD64ArrayIndexOf_callChar2 extends GeneratedInvocationPlugin {

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

    Plugin_AMD64ArrayIndexOf_callChar2(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf
//       method: callChar3(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,jdk.internal.vm.compiler.word.Pointer,int,char,char,char)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AMD64ArrayIndexOf_callChar3 extends GeneratedInvocationPlugin {

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

    Plugin_AMD64ArrayIndexOf_callChar3(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf
//       method: callChar4(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,jdk.internal.vm.compiler.word.Pointer,int,char,char,char,char)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AMD64ArrayIndexOf_callChar4 extends GeneratedInvocationPlugin {

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

    Plugin_AMD64ArrayIndexOf_callChar4(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf
//       method: callInt(org.graalvm.compiler.core.common.spi.ForeignCallDescriptor,jdk.internal.vm.compiler.word.Pointer,int,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_AMD64ArrayIndexOf_callInt extends GeneratedInvocationPlugin {

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

    Plugin_AMD64ArrayIndexOf_callInt(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedForeignCallsProvider = injection.getInjectedArgument(org.graalvm.compiler.core.common.spi.ForeignCallsProvider.class);
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

public class PluginFactory_AMD64ArrayIndexOf implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_AMD64ArrayIndexOf_callByte1(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf.class, "callByte1", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, byte.class);
        plugins.register(new Plugin_AMD64ArrayIndexOf_callByte2(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf.class, "callByte2", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, byte.class, byte.class);
        plugins.register(new Plugin_AMD64ArrayIndexOf_callByte3(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf.class, "callByte3", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, byte.class, byte.class, byte.class);
        plugins.register(new Plugin_AMD64ArrayIndexOf_callByte4(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf.class, "callByte4", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, byte.class, byte.class, byte.class, byte.class);
        plugins.register(new Plugin_AMD64ArrayIndexOf_callChar1(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf.class, "callChar1", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, char.class);
        plugins.register(new Plugin_AMD64ArrayIndexOf_callChar2(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf.class, "callChar2", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, char.class, char.class);
        plugins.register(new Plugin_AMD64ArrayIndexOf_callChar3(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf.class, "callChar3", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, char.class, char.class, char.class);
        plugins.register(new Plugin_AMD64ArrayIndexOf_callChar4(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf.class, "callChar4", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, char.class, char.class, char.class, char.class);
        plugins.register(new Plugin_AMD64ArrayIndexOf_callInt(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOf.class, "callInt", org.graalvm.compiler.core.common.spi.ForeignCallDescriptor.class, jdk.internal.vm.compiler.word.Pointer.class, int.class, int.class);
    }
}
