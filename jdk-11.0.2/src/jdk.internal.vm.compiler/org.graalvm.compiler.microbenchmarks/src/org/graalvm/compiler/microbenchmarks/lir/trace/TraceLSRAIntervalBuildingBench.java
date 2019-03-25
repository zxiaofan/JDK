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

import org.graalvm.compiler.core.common.alloc.RegisterAllocationConfig;
import org.graalvm.compiler.core.common.alloc.Trace;
import org.graalvm.compiler.core.common.alloc.TraceBuilderResult;
import org.graalvm.compiler.lir.alloc.trace.GlobalLivenessAnalysisPhase;
import org.graalvm.compiler.lir.alloc.trace.GlobalLivenessInfo;
import org.graalvm.compiler.lir.alloc.trace.TraceBuilderPhase;
import org.graalvm.compiler.lir.alloc.trace.TraceRegisterAllocationPhase;
import org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanLifetimeAnalysisPhase;
import org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanLifetimeAnalysisPhase.Analyser;
import org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanPhase;
import org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanPhase.TraceLinearScan;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool.MoveFactory;
import org.graalvm.compiler.lir.phases.AllocationPhase;
import org.graalvm.compiler.lir.phases.AllocationPhase.AllocationContext;
import org.graalvm.compiler.lir.phases.LIRPhaseSuite;
import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.microbenchmarks.graal.GraalBenchmark;
import org.graalvm.compiler.microbenchmarks.lir.GraalCompilerState;
import org.graalvm.compiler.options.OptionValues;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;

import jdk.vm.ci.code.TargetDescription;

/**
 * Benchmarks {@link TraceLinearScan TraceRA} {@link TraceLinearScanLifetimeAnalysisPhase lifetime
 * analysis phase}.
 */
public class TraceLSRAIntervalBuildingBench extends GraalBenchmark {

    private static class DummyTraceAllocatorPhase extends AllocationPhase {
        private TraceLinearScan allocator;

        @Override
        @SuppressWarnings("try")
        protected void run(TargetDescription target, LIRGenerationResult lirGenRes, AllocationContext context) {
            MoveFactory spillMoveFactory = context.spillMoveFactory;
            RegisterAllocationConfig registerAllocationConfig = context.registerAllocationConfig;
            TraceBuilderResult resultTraces = context.contextLookup(TraceBuilderResult.class);
            GlobalLivenessInfo livenessInfo = context.contextLookup(GlobalLivenessInfo.class);
            assert livenessInfo != null;
            TraceLinearScanPhase phase = new TraceLinearScanPhase(target, lirGenRes, spillMoveFactory, registerAllocationConfig, resultTraces, false, null, livenessInfo);
            for (Trace trace : resultTraces.getTraces()) {
                allocator = phase.createAllocator(trace);
                Analyser a = new TraceLinearScanLifetimeAnalysisPhase.Analyser(allocator, resultTraces);
                a.analyze();
            }
        }
    }

    public abstract static class AllocationState extends GraalCompilerState {

        private static final DummyTraceAllocatorPhase LTA_PHASE = new DummyTraceAllocatorPhase();
        private static final GlobalLivenessAnalysisPhase LIVENESS_ANALYSIS_PHASE = new GlobalLivenessAnalysisPhase();
        private static final TraceBuilderPhase TRACE_BUILDER_PHASE = new TraceBuilderPhase();

        private AllocationContext allocationContext;

        @Override
        protected LIRSuites getLIRSuites() {
            LIRSuites ls = super.getLIRSuites();
            LIRPhaseSuite<AllocationContext> allocationStage = new LIRPhaseSuite<>();
            allocationStage.appendPhase(TRACE_BUILDER_PHASE);
            allocationStage.appendPhase(LIVENESS_ANALYSIS_PHASE);
            return new LIRSuites(ls.getPreAllocationOptimizationStage(), allocationStage, ls.getPostAllocationOptimizationStage());
        }

        @Override
        protected OptionValues getGraphOptions() {
            return new OptionValues(super.getGraphOptions(), TraceRegisterAllocationPhase.Options.TraceRAuseInterTraceHints, false);
        }

        @Setup(Level.Trial)
        public void setup() {
            initializeMethod();
            prepareRequest();
            emitFrontEnd();
            generateLIR();
            preAllocationStage();
            // context for all allocation phases
            allocationContext = createAllocationContext();
            applyLIRPhase(TRACE_BUILDER_PHASE, allocationContext);
            applyLIRPhase(LIVENESS_ANALYSIS_PHASE, allocationContext);
        }

        public TraceLinearScan compile() {
            applyLIRPhase(LTA_PHASE, allocationContext);
            return LTA_PHASE.allocator;
        }

    }

    public static class State extends AllocationState {
        @MethodDescString @Param({
                        "java.lang.String#equals",
                        "java.util.HashMap#computeIfAbsent"
        }) public String method;
    }

    @Benchmark
    public TraceLinearScan buildIntervals(State s) {
        return s.compile();
    }
}
