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


package org.graalvm.compiler.core.test;

import jdk.internal.vm.compiler.collections.EconomicMap;
import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.debug.DebugContext.Scope;
import org.graalvm.compiler.debug.DebugOptions;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.options.OptionKey;
import org.graalvm.compiler.options.OptionValues;
import org.junit.Assert;
import org.junit.Test;

public class GraphResetDebugTest extends GraalCompilerTest {

    public static void testSnippet() {
    }

    @SuppressWarnings("try")
    @Test
    public void test1() {
        EconomicMap<OptionKey<?>, Object> map = EconomicMap.create();
        // Configure with an option that enables scopes
        map.put(DebugOptions.DumpOnError, true);
        DebugContext debug = getDebugContext(new OptionValues(map));
        StructuredGraph graph = parseEager("testSnippet", AllowAssumptions.YES, debug);
        boolean resetSucceeded = false;
        try (Scope scope = debug.scope("some scope")) {
            graph.resetDebug(DebugContext.DISABLED);
            resetSucceeded = true;
        } catch (AssertionError expected) {
        }
        Assert.assertFalse(resetSucceeded);
    }
}
