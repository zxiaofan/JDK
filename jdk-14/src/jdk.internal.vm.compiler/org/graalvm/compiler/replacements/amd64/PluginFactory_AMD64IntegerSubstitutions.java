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

//        class: org.graalvm.compiler.replacements.amd64.AMD64IntegerSubstitutions
//       method: lzcnt(jdk.vm.ci.code.TargetDescription)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_AMD64IntegerSubstitutions_lzcnt extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        jdk.vm.ci.code.TargetDescription arg0 = injectedTargetDescription;
        boolean result = org.graalvm.compiler.replacements.amd64.AMD64IntegerSubstitutions.lzcnt(arg0);
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

    private final jdk.vm.ci.code.TargetDescription injectedTargetDescription;

    Plugin_AMD64IntegerSubstitutions_lzcnt(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedTargetDescription = injection.getInjectedArgument(jdk.vm.ci.code.TargetDescription.class);
    }
}

//        class: org.graalvm.compiler.replacements.amd64.AMD64IntegerSubstitutions
//       method: tzcnt(jdk.vm.ci.code.TargetDescription)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_AMD64IntegerSubstitutions_tzcnt extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        jdk.vm.ci.code.TargetDescription arg0 = injectedTargetDescription;
        boolean result = org.graalvm.compiler.replacements.amd64.AMD64IntegerSubstitutions.tzcnt(arg0);
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

    private final jdk.vm.ci.code.TargetDescription injectedTargetDescription;

    Plugin_AMD64IntegerSubstitutions_tzcnt(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.injectedTargetDescription = injection.getInjectedArgument(jdk.vm.ci.code.TargetDescription.class);
    }
}

public class PluginFactory_AMD64IntegerSubstitutions implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_AMD64IntegerSubstitutions_lzcnt(injection), org.graalvm.compiler.replacements.amd64.AMD64IntegerSubstitutions.class, "lzcnt", jdk.vm.ci.code.TargetDescription.class);
        plugins.register(new Plugin_AMD64IntegerSubstitutions_tzcnt(injection), org.graalvm.compiler.replacements.amd64.AMD64IntegerSubstitutions.class, "tzcnt", jdk.vm.ci.code.TargetDescription.class);
    }
}
