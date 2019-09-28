// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.replacements.arraycopy;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

//        class: org.graalvm.compiler.replacements.arraycopy.ArrayCopyCallNode
//       method: arraycopy(java.lang.Object,int,java.lang.Object,int,int,jdk.vm.ci.meta.JavaKind,boolean,boolean,boolean,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_ArrayCopyCallNode_arraycopy__0 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.replacements.arraycopy.ArrayCopyForeignCalls arg0 = injectedArrayCopyForeignCalls;
        org.graalvm.compiler.word.WordTypes arg1 = injectedWordTypes;
        ValueNode arg2 = args[0];
        ValueNode arg3 = args[1];
        ValueNode arg4 = args[2];
        ValueNode arg5 = args[3];
        ValueNode arg6 = args[4];
        jdk.vm.ci.meta.JavaKind arg7;
        if (args[5].isConstant()) {
            arg7 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg8;
        if (args[6].isConstant()) {
            arg8 = args[6].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg9;
        if (args[7].isConstant()) {
            arg9 = args[7].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg10;
        if (args[8].isConstant()) {
            arg10 = args[8].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        int arg11;
        if (args[9].isConstant()) {
            arg11 = args[9].asJavaConstant().asInt();
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.replacements.arraycopy.ArrayCopyCallNode node = new org.graalvm.compiler.replacements.arraycopy.ArrayCopyCallNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
        b.add(node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.replacements.arraycopy.ArrayCopyForeignCalls injectedArrayCopyForeignCalls;
    private final org.graalvm.compiler.word.WordTypes injectedWordTypes;

    Plugin_ArrayCopyCallNode_arraycopy__0(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.injectedArrayCopyForeignCalls = injection.getInjectedArgument(org.graalvm.compiler.replacements.arraycopy.ArrayCopyForeignCalls.class);
        this.injectedWordTypes = injection.getInjectedArgument(org.graalvm.compiler.word.WordTypes.class);
    }
}

//        class: org.graalvm.compiler.replacements.arraycopy.ArrayCopyCallNode
//       method: arraycopy(java.lang.Object,int,java.lang.Object,int,int,jdk.vm.ci.meta.JavaKind,jdk.internal.vm.compiler.word.LocationIdentity,boolean,boolean,boolean,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_ArrayCopyCallNode_arraycopy__1 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.replacements.arraycopy.ArrayCopyForeignCalls arg0 = injectedArrayCopyForeignCalls;
        org.graalvm.compiler.word.WordTypes arg1 = injectedWordTypes;
        ValueNode arg2 = args[0];
        ValueNode arg3 = args[1];
        ValueNode arg4 = args[2];
        ValueNode arg5 = args[3];
        ValueNode arg6 = args[4];
        jdk.vm.ci.meta.JavaKind arg7;
        if (args[5].isConstant()) {
            arg7 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[5].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.internal.vm.compiler.word.LocationIdentity arg8;
        if (args[6].isConstant()) {
            arg8 = snippetReflection.asObject(jdk.internal.vm.compiler.word.LocationIdentity.class, args[6].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg9;
        if (args[7].isConstant()) {
            arg9 = args[7].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg10;
        if (args[8].isConstant()) {
            arg10 = args[8].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg11;
        if (args[9].isConstant()) {
            arg11 = args[9].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        int arg12;
        if (args[10].isConstant()) {
            arg12 = args[10].asJavaConstant().asInt();
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.replacements.arraycopy.ArrayCopyCallNode node = new org.graalvm.compiler.replacements.arraycopy.ArrayCopyCallNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
        b.add(node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.replacements.arraycopy.ArrayCopyForeignCalls injectedArrayCopyForeignCalls;
    private final org.graalvm.compiler.word.WordTypes injectedWordTypes;

    Plugin_ArrayCopyCallNode_arraycopy__1(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.injectedArrayCopyForeignCalls = injection.getInjectedArgument(org.graalvm.compiler.replacements.arraycopy.ArrayCopyForeignCalls.class);
        this.injectedWordTypes = injection.getInjectedArgument(org.graalvm.compiler.word.WordTypes.class);
    }
}

public class PluginFactory_ArrayCopyCallNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_ArrayCopyCallNode_arraycopy__0(injection), org.graalvm.compiler.replacements.arraycopy.ArrayCopyCallNode.class, "arraycopy", java.lang.Object.class, int.class, java.lang.Object.class, int.class, int.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, boolean.class, boolean.class, int.class);
        plugins.register(new Plugin_ArrayCopyCallNode_arraycopy__1(injection), org.graalvm.compiler.replacements.arraycopy.ArrayCopyCallNode.class, "arraycopy", java.lang.Object.class, int.class, java.lang.Object.class, int.class, int.class, jdk.vm.ci.meta.JavaKind.class, jdk.internal.vm.compiler.word.LocationIdentity.class, boolean.class, boolean.class, boolean.class, int.class);
    }
}
