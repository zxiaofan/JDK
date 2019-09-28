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

//        class: org.graalvm.compiler.hotspot.replacements.SHASubstitutions
//       method: stateOffset(org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_SHASubstitutions_stateOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext arg0 = b.getIntrinsic();
        long result = org.graalvm.compiler.hotspot.replacements.SHASubstitutions.stateOffset(arg0);
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

public class PluginFactory_SHASubstitutions implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_SHASubstitutions_stateOffset(), org.graalvm.compiler.hotspot.replacements.SHASubstitutions.class, "stateOffset", org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext.class);
    }
}
