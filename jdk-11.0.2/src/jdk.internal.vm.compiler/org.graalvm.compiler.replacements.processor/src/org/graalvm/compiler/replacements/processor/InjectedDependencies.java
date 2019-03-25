/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


package org.graalvm.compiler.replacements.processor;

import static org.graalvm.compiler.processor.AbstractProcessor.getAnnotationValue;
import static org.graalvm.compiler.replacements.processor.NodeIntrinsicHandler.NODE_INTRINSIC_CLASS_NAME;

import java.util.HashMap;
import java.util.Iterator;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

import org.graalvm.compiler.processor.AbstractProcessor;
import org.graalvm.compiler.replacements.processor.InjectedDependencies.Dependency;

public class InjectedDependencies implements Iterable<Dependency> {

    public abstract static class Dependency {

        public final String name;
        public final String type;

        private Dependency(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public abstract String inject(AbstractProcessor processor, ExecutableElement inject);
    }

    private static final class InjectedDependency extends Dependency {

        private InjectedDependency(String name, String type) {
            super(name, type);
        }

        @Override
        public String inject(AbstractProcessor processor, ExecutableElement inject) {
            return String.format("injection.getInjectedArgument(%s.class)", type);
        }
    }

    private static final class InjectedStampDependency extends Dependency {

        private InjectedStampDependency() {
            super("stamp", "org.graalvm.compiler.core.common.type.Stamp");
        }

        @Override
        public String inject(AbstractProcessor processor, ExecutableElement inject) {
            AnnotationMirror nodeIntrinsic = processor.getAnnotation(inject, processor.getType(NODE_INTRINSIC_CLASS_NAME));
            boolean nonNull = nodeIntrinsic != null && getAnnotationValue(nodeIntrinsic, "injectedStampIsNonNull", Boolean.class);
            return String.format("injection.getInjectedStamp(%s.class, %s)", GeneratedPlugin.getErasedType(inject.getReturnType()), nonNull);
        }
    }

    public enum WellKnownDependency {
        CONSTANT_REFLECTION("b.getConstantReflection()", "jdk.vm.ci.meta.ConstantReflectionProvider"),
        META_ACCESS("b.getMetaAccess()", "jdk.vm.ci.meta.MetaAccessProvider"),
        INJECTED_STAMP(new InjectedStampDependency()),
        SNIPPET_REFLECTION(new InjectedDependency("snippetReflection", "org.graalvm.compiler.api.replacements.SnippetReflectionProvider")),
        STAMP_PROVIDER("b.getStampProvider()", "org.graalvm.compiler.nodes.spi.StampProvider"),
        STRUCTURED_GRAPH("b.getGraph()", "org.graalvm.compiler.nodes.StructuredGraph");

        private final String expr;
        private final String type;
        private final Dependency generateMember;

        WellKnownDependency(String expr, String type) {
            this.expr = expr;
            this.type = type;
            this.generateMember = null;
        }

        WellKnownDependency(Dependency generateMember) {
            this.expr = generateMember.name;
            this.type = generateMember.type;
            this.generateMember = generateMember;
        }

        private TypeMirror getType(AbstractProcessor processor) {
            return processor.getType(type);
        }
    }

    private final HashMap<String, Dependency> deps;

    public InjectedDependencies() {
        deps = new HashMap<>();
    }

    public String use(WellKnownDependency wellKnown) {
        if (wellKnown.generateMember != null) {
            deps.put(wellKnown.type, wellKnown.generateMember);
        }
        return wellKnown.expr;
    }

    public String use(AbstractProcessor processor, DeclaredType type) {
        for (WellKnownDependency wellKnown : WellKnownDependency.values()) {
            if (processor.env().getTypeUtils().isAssignable(wellKnown.getType(processor), type)) {
                return use(wellKnown);
            }
        }

        String typeName = type.toString();
        Dependency ret = deps.get(typeName);
        if (ret == null) {
            ret = new InjectedDependency("injected" + type.asElement().getSimpleName(), typeName);
            deps.put(typeName, ret);
        }
        return ret.name;
    }

    @Override
    public Iterator<Dependency> iterator() {
        return deps.values().iterator();
    }

    public boolean isEmpty() {
        return deps.isEmpty();
    }
}
