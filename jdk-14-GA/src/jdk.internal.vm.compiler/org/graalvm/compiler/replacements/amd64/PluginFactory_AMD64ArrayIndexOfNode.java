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

import jdk.vm.ci.meta.JavaKind;

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode
//       method: optimizedArrayIndexOf(jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind,boolean,java.lang.Object,int,int,byte)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__0 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__0(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode
//       method: optimizedArrayIndexOf(jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind,boolean,java.lang.Object,int,int,byte,byte)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__1 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        ValueNode arg7 = args[7];
        org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__1(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode
//       method: optimizedArrayIndexOf(jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind,boolean,java.lang.Object,int,int,byte,byte,byte)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__2 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        ValueNode arg7 = args[7];
        ValueNode arg8 = args[8];
        org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__2(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode
//       method: optimizedArrayIndexOf(jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind,boolean,java.lang.Object,int,int,byte,byte,byte,byte)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__3 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        ValueNode arg7 = args[7];
        ValueNode arg8 = args[8];
        ValueNode arg9 = args[9];
        org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__3(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode
//       method: optimizedArrayIndexOf(jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind,boolean,java.lang.Object,int,int,char)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__4 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__4(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode
//       method: optimizedArrayIndexOf(jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind,boolean,java.lang.Object,int,int,char,char)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__5 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        ValueNode arg7 = args[7];
        org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__5(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode
//       method: optimizedArrayIndexOf(jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind,boolean,java.lang.Object,int,int,char,char,char)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__6 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        ValueNode arg7 = args[7];
        ValueNode arg8 = args[8];
        org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__6(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode
//       method: optimizedArrayIndexOf(jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind,boolean,java.lang.Object,int,int,char,char,char,char)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__7 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        ValueNode arg7 = args[7];
        ValueNode arg8 = args[8];
        ValueNode arg9 = args[9];
        org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__7(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode
//       method: optimizedArrayIndexOf(jdk.vm.ci.meta.JavaKind,jdk.vm.ci.meta.JavaKind,boolean,java.lang.Object,int,int,int)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__8 extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg0;
        if (args[0].isConstant()) {
            arg0 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        boolean arg2;
        if (args[2].isConstant()) {
            arg2 = args[2].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        ValueNode arg3 = args[3];
        ValueNode arg4 = args[4];
        ValueNode arg5 = args[5];
        ValueNode arg6 = args[6];
        org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode node = new org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__8(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_AMD64ArrayIndexOfNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__0(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode.class, "optimizedArrayIndexOf", jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, java.lang.Object.class, int.class, int.class, byte.class);
        plugins.register(new Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__1(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode.class, "optimizedArrayIndexOf", jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, java.lang.Object.class, int.class, int.class, byte.class, byte.class);
        plugins.register(new Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__2(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode.class, "optimizedArrayIndexOf", jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, java.lang.Object.class, int.class, int.class, byte.class, byte.class, byte.class);
        plugins.register(new Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__3(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode.class, "optimizedArrayIndexOf", jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, java.lang.Object.class, int.class, int.class, byte.class, byte.class, byte.class, byte.class);
        plugins.register(new Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__4(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode.class, "optimizedArrayIndexOf", jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, java.lang.Object.class, int.class, int.class, char.class);
        plugins.register(new Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__5(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode.class, "optimizedArrayIndexOf", jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, java.lang.Object.class, int.class, int.class, char.class, char.class);
        plugins.register(new Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__6(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode.class, "optimizedArrayIndexOf", jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, java.lang.Object.class, int.class, int.class, char.class, char.class, char.class);
        plugins.register(new Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__7(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode.class, "optimizedArrayIndexOf", jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, java.lang.Object.class, int.class, int.class, char.class, char.class, char.class, char.class);
        plugins.register(new Plugin_AMD64ArrayIndexOfNode_optimizedArrayIndexOf__8(injection), org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode.class, "optimizedArrayIndexOf", jdk.vm.ci.meta.JavaKind.class, jdk.vm.ci.meta.JavaKind.class, boolean.class, java.lang.Object.class, int.class, int.class, int.class);
    }
}
