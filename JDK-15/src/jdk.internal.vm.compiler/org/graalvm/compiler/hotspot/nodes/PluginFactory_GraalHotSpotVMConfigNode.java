// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// GENERATORS: org.graalvm.compiler.replacements.processor.ReplacementsAnnotationProcessor, org.graalvm.compiler.replacements.processor.PluginGenerator
package org.graalvm.compiler.hotspot.nodes;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.annotation.Annotation;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins;
import org.graalvm.compiler.nodes.graphbuilderconf.NodeIntrinsicPluginFactory;

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: loadIntConfigValue(org.graalvm.compiler.hotspot.HotSpotMarkId)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_GraalHotSpotVMConfigNode_loadIntConfigValue extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg1 = injectedGraalHotSpotVMConfig;
        org.graalvm.compiler.hotspot.HotSpotMarkId arg2;
        if (args[0].isConstant()) {
            arg2 = snippetReflection.asObject(org.graalvm.compiler.hotspot.HotSpotMarkId.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        return org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.intrinsify(b, targetMethod, arg0, arg1, arg2);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_GraalHotSpotVMConfigNode_loadIntConfigValue(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        this.stamp = injection.getInjectedStamp(int.class, false);
    }
}

//        class: org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode
//       method: loadLongConfigValue(org.graalvm.compiler.hotspot.HotSpotMarkId)
// generated-by: org.graalvm.compiler.replacements.processor.GeneratedNodeIntrinsicPlugin$CustomFactoryPlugin
final class Plugin_GraalHotSpotVMConfigNode_loadLongConfigValue extends GeneratedInvocationPlugin {

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        if (!b.isPluginEnabled(this)) {
            return false;
        }
        org.graalvm.compiler.core.common.type.Stamp arg0 = stamp;
        org.graalvm.compiler.hotspot.GraalHotSpotVMConfig arg1 = injectedGraalHotSpotVMConfig;
        org.graalvm.compiler.hotspot.HotSpotMarkId arg2;
        if (args[0].isConstant()) {
            arg2 = snippetReflection.asObject(org.graalvm.compiler.hotspot.HotSpotMarkId.class, args[0].asJavaConstant());
        } else {
            assert b.canDeferPlugin(this) : b.getClass().toString();
            return false;
        }
        return org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.intrinsify(b, targetMethod, arg0, arg1, arg2);
    }
    @Override
    public Class<? extends Annotation> getSource() {
        return org.graalvm.compiler.graph.Node.NodeIntrinsic.class;
    }

    private final org.graalvm.compiler.api.replacements.SnippetReflectionProvider snippetReflection;
    private final org.graalvm.compiler.hotspot.GraalHotSpotVMConfig injectedGraalHotSpotVMConfig;
    private final org.graalvm.compiler.core.common.type.Stamp stamp;

    Plugin_GraalHotSpotVMConfigNode_loadLongConfigValue(NodeIntrinsicPluginFactory.InjectionProvider injection) {
        this.snippetReflection = injection.getInjectedArgument(org.graalvm.compiler.api.replacements.SnippetReflectionProvider.class);
        this.injectedGraalHotSpotVMConfig = injection.getInjectedArgument(org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.class);
        this.stamp = injection.getInjectedStamp(long.class, false);
    }
}

public class PluginFactory_GraalHotSpotVMConfigNode implements NodeIntrinsicPluginFactory {
    @Override
    public void registerPlugins(InvocationPlugins plugins, NodeIntrinsicPluginFactory.InjectionProvider injection) {
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_loadIntConfigValue(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "loadIntConfigValue", org.graalvm.compiler.hotspot.HotSpotMarkId.class);
        plugins.register(new Plugin_GraalHotSpotVMConfigNode_loadLongConfigValue(injection), org.graalvm.compiler.hotspot.nodes.GraalHotSpotVMConfigNode.class, "loadLongConfigValue", org.graalvm.compiler.hotspot.HotSpotMarkId.class);
    }
}
