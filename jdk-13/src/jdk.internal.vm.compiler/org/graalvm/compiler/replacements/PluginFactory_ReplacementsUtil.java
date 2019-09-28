// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.replacements;

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

//        class: org.graalvm.compiler.replacements.ReplacementsUtil
//       method: arrayIndexScale(jdk.vm.ci.meta.MetaAccessProvider,jdk.vm.ci.meta.JavaKind)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_ReplacementsUtil_arrayIndexScale extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        jdk.vm.ci.meta.MetaAccessProvider arg0 = b.getMetaAccess();
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        int result = org.graalvm.compiler.replacements.ReplacementsUtil.arrayIndexScale(arg0, arg1);
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

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_ReplacementsUtil_arrayIndexScale(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

//        class: org.graalvm.compiler.replacements.ReplacementsUtil
//       method: getArrayBaseOffset(jdk.vm.ci.meta.MetaAccessProvider,jdk.vm.ci.meta.JavaKind)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedFoldPlugin
final class Plugin_ReplacementsUtil_getArrayBaseOffset extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!checkInjectedArgument(b, args[0], targetMethod)) {
            return false;
        }
        jdk.vm.ci.meta.MetaAccessProvider arg0 = b.getMetaAccess();
        jdk.vm.ci.meta.JavaKind arg1;
        if (args[1].isConstant()) {
            arg1 = snippetReflection.asObject(jdk.vm.ci.meta.JavaKind.class, args[1].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        int result = org.graalvm.compiler.replacements.ReplacementsUtil.getArrayBaseOffset(arg0, arg1);
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

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;

    Plugin_ReplacementsUtil_getArrayBaseOffset(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
    }
}

public class PluginFactory_ReplacementsUtil implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_ReplacementsUtil_arrayIndexScale(injection), org.graalvm.compiler.replacements.ReplacementsUtil.class, "arrayIndexScale", jdk.vm.ci.meta.MetaAccessProvider.class, jdk.vm.ci.meta.JavaKind.class);
        plugins.register(new Plugin_ReplacementsUtil_getArrayBaseOffset(injection), org.graalvm.compiler.replacements.ReplacementsUtil.class, "getArrayBaseOffset", jdk.vm.ci.meta.MetaAccessProvider.class, jdk.vm.ci.meta.JavaKind.class);
    }
}
