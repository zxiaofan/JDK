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

import jdk.vm.ci.meta.JavaKind;

//        class: org.graalvm.compiler.replacements.arraycopy.CheckcastArrayCopyCallNode
//       method: checkcastArraycopy(java.lang.Object,int,java.lang.Object,int,int,org.graalvm.compiler.word.Word,java.lang.Object,boolean)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$ConstructorPlugin
final class Plugin_CheckcastArrayCopyCallNode_checkcastArraycopy extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        org.graalvm.compiler.replacements.arraycopy.ArrayCopyForeignCalls arg0 = injectedArrayCopyForeignCalls;
        org.graalvm.compiler.word.WordTypes arg1 = injectedWordTypes;
        ValueNode arg2 = args[0];
        ValueNode arg3 = args[1];
        ValueNode arg4 = args[2];
        ValueNode arg5 = args[3];
        ValueNode arg6 = args[4];
        ValueNode arg7 = args[5];
        ValueNode arg8 = args[6];
        boolean arg9;
        if (args[7].isConstant()) {
            arg9 = args[7].asJavaConstant().asInt() != 0;
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        org.graalvm.compiler.replacements.arraycopy.CheckcastArrayCopyCallNode node = new org.graalvm.compiler.replacements.arraycopy.CheckcastArrayCopyCallNode(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        b.addPush(JavaKind.Int, node);
        return true;
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.replacements.arraycopy.ArrayCopyForeignCalls injectedArrayCopyForeignCalls;
    private final org.graalvm.compiler.word.WordTypes injectedWordTypes;

    Plugin_CheckcastArrayCopyCallNode_checkcastArraycopy(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedArrayCopyForeignCalls = injection.getInjectedArgument(org.graalvm.compiler.replacements.arraycopy.ArrayCopyForeignCalls.class);
        this.injectedWordTypes = injection.getInjectedArgument(org.graalvm.compiler.word.WordTypes.class);
    }
}

public class PluginFactory_CheckcastArrayCopyCallNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_CheckcastArrayCopyCallNode_checkcastArraycopy(injection), org.graalvm.compiler.replacements.arraycopy.CheckcastArrayCopyCallNode.class, "checkcastArraycopy", java.lang.Object.class, int.class, java.lang.Object.class, int.class, int.class, org.graalvm.compiler.word.Word.class, java.lang.Object.class, boolean.class);
    }
}
