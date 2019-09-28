// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.nodes;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

import jdk.vm.ci.meta.JavaKind;

//        class: org.graalvm.compiler.nodes.PiNode
//       method: asNonNullClassIntrinsic(java.lang.Object,java.lang.Class<?>,boolean,boolean)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_PiNode_asNonNullClassIntrinsic extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        jdk.vm.ci.meta.ResolvedJavaType arg1;
        if (args[1].isConstant()) {
            jdk.vm.ci.meta.JavaConstant cst = args[1].asJavaConstant();
            arg1 = b.getConstantReflection().asJavaType(cst);
            if (arg1 == null) {
                arg1 = snippetReflection.asObject(jdk.vm.ci.meta.ResolvedJavaType.class, cst);
            }
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
        boolean arg3;
        if (args[3].isConstant()) {
            arg3 = args[3].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        return org.graalvm.compiler.nodes.PiNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_PiNode_asNonNullClassIntrinsic(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.nodes.PiNode
//       method: piCast(java.lang.Object,jdk.vm.ci.meta.ResolvedJavaType,boolean,boolean)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_PiNode_piCast extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        jdk.vm.ci.meta.ResolvedJavaType arg1;
        if (args[1].isConstant()) {
            jdk.vm.ci.meta.JavaConstant cst = args[1].asJavaConstant();
            arg1 = b.getConstantReflection().asJavaType(cst);
            if (arg1 == null) {
                arg1 = snippetReflection.asObject(jdk.vm.ci.meta.ResolvedJavaType.class, cst);
            }
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
        boolean arg3;
        if (args[3].isConstant()) {
            arg3 = args[3].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        return org.graalvm.compiler.nodes.PiNode.intrinsify(b, targetMethod, arg0, arg1, arg2, arg3);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_PiNode_piCast(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.nodes.PiNode
//       method: piCastNonNull(java.lang.Object,org.graalvm.compiler.nodes.extended.GuardingNode)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_PiNode_piCastNonNull extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        return org.graalvm.compiler.nodes.PiNode.intrinsify(b, targetMethod, arg0, arg1);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.nodes.PiNode
//       method: piCastNonNullClass(java.lang.Class<?>,org.graalvm.compiler.nodes.extended.GuardingNode)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_PiNode_piCastNonNullClass extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        ValueNode arg1 = args[1];
        return org.graalvm.compiler.nodes.PiNode.intrinsify(b, targetMethod, arg0, arg1);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

//        class: org.graalvm.compiler.nodes.PiNode
//       method: piCastToSnippetReplaceeStamp(java.lang.Object)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_PiNode_piCastToSnippetReplaceeStamp extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ValueNode arg0 = args[0];
        org.graalvm.compiler.nodes.PiNode.Placeholder node = new org.graalvm.compiler.nodes.PiNode.Placeholder(arg0);
        b.addPush(JavaKind.Object, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }
}

public class PluginFactory_PiNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_PiNode_asNonNullClassIntrinsic(injection), org.graalvm.compiler.nodes.PiNode.class, "asNonNullClassIntrinsic", java.lang.Object.class, java.lang.Class.class, boolean.class, boolean.class);
        plugins.register(new Plugin_PiNode_piCast(injection), org.graalvm.compiler.nodes.PiNode.class, "piCast", java.lang.Object.class, jdk.vm.ci.meta.ResolvedJavaType.class, boolean.class, boolean.class);
        plugins.register(new Plugin_PiNode_piCastNonNull(), org.graalvm.compiler.nodes.PiNode.class, "piCastNonNull", java.lang.Object.class, org.graalvm.compiler.nodes.extended.GuardingNode.class);
        plugins.register(new Plugin_PiNode_piCastNonNullClass(), org.graalvm.compiler.nodes.PiNode.class, "piCastNonNullClass", java.lang.Class.class, org.graalvm.compiler.nodes.extended.GuardingNode.class);
        plugins.register(new Plugin_PiNode_piCastToSnippetReplaceeStamp(), org.graalvm.compiler.nodes.PiNode.class, "piCastToSnippetReplaceeStamp", java.lang.Object.class);
    }
}
