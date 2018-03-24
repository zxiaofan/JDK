/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.replacements.verifier;

import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

import org.graalvm.compiler.graph.Node.NodeIntrinsic;
import org.graalvm.compiler.replacements.verifier.InjectedDependencies.Dependency;

public class InjectedDependencies implements Iterable<Dependency> {

    public abstract static class Dependency {

        public final String name;
        public final String type;

        private Dependency(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public abstract String inject(ExecutableElement inject);
    }

    private static final class InjectedDependency extends Dependency {

        private InjectedDependency(String name, String type) {
            super(name, type);
        }

        @Override
        public String inject(ExecutableElement inject) {
            return String.format("injection.getInjectedArgument(%s.class)", type);
        }
    }

    private static final class InjectedStampDependency extends Dependency {

        private InjectedStampDependency() {
            super("stamp", "org.graalvm.compiler.core.common.type.Stamp");
        }

        @Override
        public String inject(ExecutableElement inject) {
            NodeIntrinsic nodeIntrinsic = inject.getAnnotation(NodeIntrinsic.class);
            boolean nonNull = nodeIntrinsic != null && nodeIntrinsic.injectedStampIsNonNull();
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

        private TypeMirror getType(ProcessingEnvironment env) {
            return env.getElementUtils().getTypeElement(type).asType();
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

    public String use(ProcessingEnvironment env, DeclaredType type) {
        for (WellKnownDependency wellKnown : WellKnownDependency.values()) {
            if (env.getTypeUtils().isAssignable(wellKnown.getType(env), type)) {
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
