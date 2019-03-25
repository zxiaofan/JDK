/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.microbenchmarks.lir.trace;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.microbenchmarks.lir.GraalCompilerState;
import org.graalvm.compiler.nodes.cfg.ControlFlowGraph;

/**
 * State class for working with {@link ControlFlowGraph} and {@link LIR}.
 */
public abstract class ControlFlowGraphState extends GraalCompilerState {

    public ControlFlowGraph cfg;

    @Setup(Level.Trial)
    public void beforeBenchmark() {
        // setup graph
        initializeMethod();
        prepareRequest();
        emitFrontEnd();
        generateLIR();
        // compute cfg
        this.cfg = (ControlFlowGraph) getLIR().getControlFlowGraph();
    }

    @Override
    public LIR getLIR() {
        return super.getLIR();
    }

}
