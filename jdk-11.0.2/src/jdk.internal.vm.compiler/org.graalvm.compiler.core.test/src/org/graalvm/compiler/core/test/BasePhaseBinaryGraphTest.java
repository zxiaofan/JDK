/*
 * Copyright (c) 2011, 2018, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.BasePhase;
import org.graalvm.compiler.printer.BinaryGraphPrinter;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BasePhaseBinaryGraphTest {
    private MyPhase phase;
    private BinaryGraphPrinter printer;

    @Before
    public void createPhase() {
        phase = new MyPhase();
    }

    @Before
    public void createPrinter() throws Exception {
        printer = new BinaryGraphPrinter(DebugContext.DISABLED, null);
    }

    @Test
    public void phaseNameIsRecognizedAsType() {
        String res = printer.typeName(phase.getName());
        assertEquals(MyPhase.class.getName(), res);
    }

    private static final class MyPhase extends BasePhase<Void> {
        @Override
        protected void run(StructuredGraph graph, Void context) {
        }

        @Override
        protected CharSequence getName() {
            return super.getName();
        }
    }
}
