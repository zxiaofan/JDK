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

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import org.graalvm.compiler.nodes.ConstantNode;

//        class: org.graalvm.compiler.replacements.amd64.AMD64StringSubstitutions
//       method: charArrayBaseOffset(jdk.vm.ci.meta.MetaAccessProvider)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_AMD64StringSubstitutions_charArrayBaseOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        jdk.vm.ci.meta.MetaAccessProvider arg0 = b.getMetaAccess();
        int result = org.graalvm.compiler.replacements.amd64.AMD64StringSubstitutions.charArrayBaseOffset(arg0);
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

//        class: org.graalvm.compiler.replacements.amd64.AMD64StringSubstitutions
//       method: charArrayIndexScale(jdk.vm.ci.meta.MetaAccessProvider)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_AMD64StringSubstitutions_charArrayIndexScale extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        jdk.vm.ci.meta.MetaAccessProvider arg0 = b.getMetaAccess();
        int result = org.graalvm.compiler.replacements.amd64.AMD64StringSubstitutions.charArrayIndexScale(arg0);
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

public class PluginFactory_AMD64StringSubstitutions implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_AMD64StringSubstitutions_charArrayBaseOffset(), org.graalvm.compiler.replacements.amd64.AMD64StringSubstitutions.class, "charArrayBaseOffset", jdk.vm.ci.meta.MetaAccessProvider.class);
        plugins.register(new Plugin_AMD64StringSubstitutions_charArrayIndexScale(), org.graalvm.compiler.replacements.amd64.AMD64StringSubstitutions.class, "charArrayIndexScale", jdk.vm.ci.meta.MetaAccessProvider.class);
    }
}
