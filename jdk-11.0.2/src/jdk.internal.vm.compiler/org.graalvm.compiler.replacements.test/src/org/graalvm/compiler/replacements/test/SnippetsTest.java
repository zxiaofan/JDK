/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.test;

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.Builder;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.tiers.HighTierContext;
import org.graalvm.compiler.replacements.ReplacementsImpl;
import org.graalvm.compiler.replacements.classfile.ClassfileBytecodeProvider;

public abstract class SnippetsTest extends ReplacementsTest {

    protected final ReplacementsImpl installer;
    protected final ClassfileBytecodeProvider bytecodeProvider;

    protected SnippetsTest() {
        ReplacementsImpl d = (ReplacementsImpl) getReplacements();
        bytecodeProvider = getSystemClassLoaderBytecodeProvider();
        installer = new ReplacementsImpl(getInitialOptions(), null, d.providers, d.snippetReflection, bytecodeProvider, d.target);
        installer.setGraphBuilderPlugins(d.getGraphBuilderPlugins());
    }

    @Override
    protected StructuredGraph parse(Builder builder, PhaseSuite<HighTierContext> graphBuilderSuite) {
        return installer.makeGraph(getDebugContext(), bytecodeProvider, builder.getMethod(), null, null, false, null);
    }
}
