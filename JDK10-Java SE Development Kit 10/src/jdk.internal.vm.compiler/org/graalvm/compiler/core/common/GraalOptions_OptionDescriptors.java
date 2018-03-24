// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: GraalOptions.java
package org.graalvm.compiler.core.common;

import java.util.*;
import org.graalvm.compiler.options.*;

public class GraalOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "AlwaysInlineVTableStubs": {
            return OptionDescriptor.create(
                /*name*/ "AlwaysInlineVTableStubs",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "AlwaysInlineVTableStubs",
                /*option*/ GraalOptions.AlwaysInlineVTableStubs);
        }
        case "CallArrayCopy": {
            return OptionDescriptor.create(
                /*name*/ "CallArrayCopy",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "CallArrayCopy",
                /*option*/ GraalOptions.CallArrayCopy);
        }
        case "CanOmitFrame": {
            return OptionDescriptor.create(
                /*name*/ "CanOmitFrame",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "CanOmitFrame",
                /*option*/ GraalOptions.CanOmitFrame);
        }
        case "ConditionalElimination": {
            return OptionDescriptor.create(
                /*name*/ "ConditionalElimination",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "ConditionalElimination",
                /*option*/ GraalOptions.ConditionalElimination);
        }
        case "DeoptALot": {
            return OptionDescriptor.create(
                /*name*/ "DeoptALot",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "DeoptALot",
                /*option*/ GraalOptions.DeoptALot);
        }
        case "DeoptsToDisableOptimisticOptimization": {
            return OptionDescriptor.create(
                /*name*/ "DeoptsToDisableOptimisticOptimization",
                /*type*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "DeoptsToDisableOptimisticOptimization",
                /*option*/ GraalOptions.DeoptsToDisableOptimisticOptimization);
        }
        case "EagerSnippets": {
            return OptionDescriptor.create(
                /*name*/ "EagerSnippets",
                /*type*/ Boolean.class,
                /*help*/ "Eagerly construct extra snippet info.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "EagerSnippets",
                /*option*/ GraalOptions.EagerSnippets);
        }
        case "EscapeAnalysisIterations": {
            return OptionDescriptor.create(
                /*name*/ "EscapeAnalysisIterations",
                /*type*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "EscapeAnalysisIterations",
                /*option*/ GraalOptions.EscapeAnalysisIterations);
        }
        case "EscapeAnalysisLoopCutoff": {
            return OptionDescriptor.create(
                /*name*/ "EscapeAnalysisLoopCutoff",
                /*type*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "EscapeAnalysisLoopCutoff",
                /*option*/ GraalOptions.EscapeAnalysisLoopCutoff);
        }
        case "EscapeAnalyzeOnly": {
            return OptionDescriptor.create(
                /*name*/ "EscapeAnalyzeOnly",
                /*type*/ String.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "EscapeAnalyzeOnly",
                /*option*/ GraalOptions.EscapeAnalyzeOnly);
        }
        case "FullUnroll": {
            return OptionDescriptor.create(
                /*name*/ "FullUnroll",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "FullUnroll",
                /*option*/ GraalOptions.FullUnroll);
        }
        case "GCDebugStartCycle": {
            return OptionDescriptor.create(
                /*name*/ "GCDebugStartCycle",
                /*type*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "GCDebugStartCycle",
                /*option*/ GraalOptions.GCDebugStartCycle);
        }
        case "GenLoopSafepoints": {
            return OptionDescriptor.create(
                /*name*/ "GenLoopSafepoints",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "GenLoopSafepoints",
                /*option*/ GraalOptions.GenLoopSafepoints);
        }
        case "GenSafepoints": {
            return OptionDescriptor.create(
                /*name*/ "GenSafepoints",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "GenSafepoints",
                /*option*/ GraalOptions.GenSafepoints);
        }
        case "GeneratePIC": {
            return OptionDescriptor.create(
                /*name*/ "GeneratePIC",
                /*type*/ Boolean.class,
                /*help*/ "Generate position independent code",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "GeneratePIC",
                /*option*/ GraalOptions.GeneratePIC);
        }
        case "HotSpotPrintInlining": {
            return OptionDescriptor.create(
                /*name*/ "HotSpotPrintInlining",
                /*type*/ Boolean.class,
                /*help*/ "Print inlining optimizations",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "HotSpotPrintInlining",
                /*option*/ GraalOptions.HotSpotPrintInlining);
        }
        case "ImmutableCode": {
            return OptionDescriptor.create(
                /*name*/ "ImmutableCode",
                /*type*/ Boolean.class,
                /*help*/ "Try to avoid emitting code where patching is required",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "ImmutableCode",
                /*option*/ GraalOptions.ImmutableCode);
        }
        case "InlineEverything": {
            return OptionDescriptor.create(
                /*name*/ "InlineEverything",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "InlineEverything",
                /*option*/ GraalOptions.InlineEverything);
        }
        case "InlineMegamorphicCalls": {
            return OptionDescriptor.create(
                /*name*/ "InlineMegamorphicCalls",
                /*type*/ Boolean.class,
                /*help*/ "Inline calls with megamorphic type profile (i.e., not all types could be recorded).",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "InlineMegamorphicCalls",
                /*option*/ GraalOptions.InlineMegamorphicCalls);
        }
        case "InlineMonomorphicCalls": {
            return OptionDescriptor.create(
                /*name*/ "InlineMonomorphicCalls",
                /*type*/ Boolean.class,
                /*help*/ "Inline calls with monomorphic type profile.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "InlineMonomorphicCalls",
                /*option*/ GraalOptions.InlineMonomorphicCalls);
        }
        case "InlinePolymorphicCalls": {
            return OptionDescriptor.create(
                /*name*/ "InlinePolymorphicCalls",
                /*type*/ Boolean.class,
                /*help*/ "Inline calls with polymorphic type profile.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "InlinePolymorphicCalls",
                /*option*/ GraalOptions.InlinePolymorphicCalls);
        }
        case "InlineVTableStubs": {
            return OptionDescriptor.create(
                /*name*/ "InlineVTableStubs",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "InlineVTableStubs",
                /*option*/ GraalOptions.InlineVTableStubs);
        }
        case "Intrinsify": {
            return OptionDescriptor.create(
                /*name*/ "Intrinsify",
                /*type*/ Boolean.class,
                /*help*/ "Use compiler intrinsifications.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "Intrinsify",
                /*option*/ GraalOptions.Intrinsify);
        }
        case "LimitInlinedInvokes": {
            return OptionDescriptor.create(
                /*name*/ "LimitInlinedInvokes",
                /*type*/ Double.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "LimitInlinedInvokes",
                /*option*/ GraalOptions.LimitInlinedInvokes);
        }
        case "LoopMaxUnswitch": {
            return OptionDescriptor.create(
                /*name*/ "LoopMaxUnswitch",
                /*type*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "LoopMaxUnswitch",
                /*option*/ GraalOptions.LoopMaxUnswitch);
        }
        case "LoopPeeling": {
            return OptionDescriptor.create(
                /*name*/ "LoopPeeling",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "LoopPeeling",
                /*option*/ GraalOptions.LoopPeeling);
        }
        case "LoopUnswitch": {
            return OptionDescriptor.create(
                /*name*/ "LoopUnswitch",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "LoopUnswitch",
                /*option*/ GraalOptions.LoopUnswitch);
        }
        case "MatchExpressions": {
            return OptionDescriptor.create(
                /*name*/ "MatchExpressions",
                /*type*/ Boolean.class,
                /*help*/ "Allow backend to match complex expressions.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "MatchExpressions",
                /*option*/ GraalOptions.MatchExpressions);
        }
        case "MaximumDesiredSize": {
            return OptionDescriptor.create(
                /*name*/ "MaximumDesiredSize",
                /*type*/ Integer.class,
                /*help*/ "Maximum desired size of the compiler graph in nodes.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "MaximumDesiredSize",
                /*option*/ GraalOptions.MaximumDesiredSize);
        }
        case "MaximumEscapeAnalysisArrayLength": {
            return OptionDescriptor.create(
                /*name*/ "MaximumEscapeAnalysisArrayLength",
                /*type*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "MaximumEscapeAnalysisArrayLength",
                /*option*/ GraalOptions.MaximumEscapeAnalysisArrayLength);
        }
        case "MaximumInliningSize": {
            return OptionDescriptor.create(
                /*name*/ "MaximumInliningSize",
                /*type*/ Integer.class,
                /*help*/ "Inlining is explored up to this number of nodes in the graph for each call site.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "MaximumInliningSize",
                /*option*/ GraalOptions.MaximumInliningSize);
        }
        case "MaximumRecursiveInlining": {
            return OptionDescriptor.create(
                /*name*/ "MaximumRecursiveInlining",
                /*type*/ Integer.class,
                /*help*/ "Maximum level of recursive inlining.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "MaximumRecursiveInlining",
                /*option*/ GraalOptions.MaximumRecursiveInlining);
        }
        case "MegamorphicInliningMinMethodProbability": {
            return OptionDescriptor.create(
                /*name*/ "MegamorphicInliningMinMethodProbability",
                /*type*/ Double.class,
                /*help*/ "Minimum probability for methods to be inlined for megamorphic type profiles.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "MegamorphicInliningMinMethodProbability",
                /*option*/ GraalOptions.MegamorphicInliningMinMethodProbability);
        }
        case "MinimumPeelProbability": {
            return OptionDescriptor.create(
                /*name*/ "MinimumPeelProbability",
                /*type*/ Float.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "MinimumPeelProbability",
                /*option*/ GraalOptions.MinimumPeelProbability);
        }
        case "OmitHotExceptionStacktrace": {
            return OptionDescriptor.create(
                /*name*/ "OmitHotExceptionStacktrace",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OmitHotExceptionStacktrace",
                /*option*/ GraalOptions.OmitHotExceptionStacktrace);
        }
        case "OptAssumptions": {
            return OptionDescriptor.create(
                /*name*/ "OptAssumptions",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptAssumptions",
                /*option*/ GraalOptions.OptAssumptions);
        }
        case "OptClearNonLiveLocals": {
            return OptionDescriptor.create(
                /*name*/ "OptClearNonLiveLocals",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptClearNonLiveLocals",
                /*option*/ GraalOptions.OptClearNonLiveLocals);
        }
        case "OptConvertDeoptsToGuards": {
            return OptionDescriptor.create(
                /*name*/ "OptConvertDeoptsToGuards",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptConvertDeoptsToGuards",
                /*option*/ GraalOptions.OptConvertDeoptsToGuards);
        }
        case "OptDeoptimizationGrouping": {
            return OptionDescriptor.create(
                /*name*/ "OptDeoptimizationGrouping",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptDeoptimizationGrouping",
                /*option*/ GraalOptions.OptDeoptimizationGrouping);
        }
        case "OptDevirtualizeInvokesOptimistically": {
            return OptionDescriptor.create(
                /*name*/ "OptDevirtualizeInvokesOptimistically",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptDevirtualizeInvokesOptimistically",
                /*option*/ GraalOptions.OptDevirtualizeInvokesOptimistically);
        }
        case "OptEliminateGuards": {
            return OptionDescriptor.create(
                /*name*/ "OptEliminateGuards",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptEliminateGuards",
                /*option*/ GraalOptions.OptEliminateGuards);
        }
        case "OptEliminatePartiallyRedundantGuards": {
            return OptionDescriptor.create(
                /*name*/ "OptEliminatePartiallyRedundantGuards",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptEliminatePartiallyRedundantGuards",
                /*option*/ GraalOptions.OptEliminatePartiallyRedundantGuards);
        }
        case "OptFilterProfiledTypes": {
            return OptionDescriptor.create(
                /*name*/ "OptFilterProfiledTypes",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptFilterProfiledTypes",
                /*option*/ GraalOptions.OptFilterProfiledTypes);
        }
        case "OptFloatingReads": {
            return OptionDescriptor.create(
                /*name*/ "OptFloatingReads",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptFloatingReads",
                /*option*/ GraalOptions.OptFloatingReads);
        }
        case "OptImplicitNullChecks": {
            return OptionDescriptor.create(
                /*name*/ "OptImplicitNullChecks",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptImplicitNullChecks",
                /*option*/ GraalOptions.OptImplicitNullChecks);
        }
        case "OptLoopTransform": {
            return OptionDescriptor.create(
                /*name*/ "OptLoopTransform",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptLoopTransform",
                /*option*/ GraalOptions.OptLoopTransform);
        }
        case "OptReadElimination": {
            return OptionDescriptor.create(
                /*name*/ "OptReadElimination",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptReadElimination",
                /*option*/ GraalOptions.OptReadElimination);
        }
        case "OptScheduleOutOfLoops": {
            return OptionDescriptor.create(
                /*name*/ "OptScheduleOutOfLoops",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "OptScheduleOutOfLoops",
                /*option*/ GraalOptions.OptScheduleOutOfLoops);
        }
        case "PEAInliningHints": {
            return OptionDescriptor.create(
                /*name*/ "PEAInliningHints",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "PEAInliningHints",
                /*option*/ GraalOptions.PEAInliningHints);
        }
        case "PartialEscapeAnalysis": {
            return OptionDescriptor.create(
                /*name*/ "PartialEscapeAnalysis",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "PartialEscapeAnalysis",
                /*option*/ GraalOptions.PartialEscapeAnalysis);
        }
        case "PartialUnroll": {
            return OptionDescriptor.create(
                /*name*/ "PartialUnroll",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "PartialUnroll",
                /*option*/ GraalOptions.PartialUnroll);
        }
        case "PrintProfilingInformation": {
            return OptionDescriptor.create(
                /*name*/ "PrintProfilingInformation",
                /*type*/ Boolean.class,
                /*help*/ "Print profiling information when parsing a method's bytecode",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "PrintProfilingInformation",
                /*option*/ GraalOptions.PrintProfilingInformation);
        }
        case "RawConditionalElimination": {
            return OptionDescriptor.create(
                /*name*/ "RawConditionalElimination",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "RawConditionalElimination",
                /*option*/ GraalOptions.RawConditionalElimination);
        }
        case "ReadEliminationMaxLoopVisits": {
            return OptionDescriptor.create(
                /*name*/ "ReadEliminationMaxLoopVisits",
                /*type*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "ReadEliminationMaxLoopVisits",
                /*option*/ GraalOptions.ReadEliminationMaxLoopVisits);
        }
        case "ReassociateInvariants": {
            return OptionDescriptor.create(
                /*name*/ "ReassociateInvariants",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "ReassociateInvariants",
                /*option*/ GraalOptions.ReassociateInvariants);
        }
        case "RegisterPressure": {
            return OptionDescriptor.create(
                /*name*/ "RegisterPressure",
                /*type*/ String.class,
                /*help*/ "Comma separated list of registers that register allocation is limited to.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "RegisterPressure",
                /*option*/ GraalOptions.RegisterPressure);
        }
        case "RemoveNeverExecutedCode": {
            return OptionDescriptor.create(
                /*name*/ "RemoveNeverExecutedCode",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "RemoveNeverExecutedCode",
                /*option*/ GraalOptions.RemoveNeverExecutedCode);
        }
        case "ReplaceInputsWithConstantsBasedOnStamps": {
            return OptionDescriptor.create(
                /*name*/ "ReplaceInputsWithConstantsBasedOnStamps",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "ReplaceInputsWithConstantsBasedOnStamps",
                /*option*/ GraalOptions.ReplaceInputsWithConstantsBasedOnStamps);
        }
        case "ResolveClassBeforeStaticInvoke": {
            return OptionDescriptor.create(
                /*name*/ "ResolveClassBeforeStaticInvoke",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "ResolveClassBeforeStaticInvoke",
                /*option*/ GraalOptions.ResolveClassBeforeStaticInvoke);
        }
        case "SmallCompiledLowLevelGraphSize": {
            return OptionDescriptor.create(
                /*name*/ "SmallCompiledLowLevelGraphSize",
                /*type*/ Integer.class,
                /*help*/ "If the previous low-level graph size of the method exceeds the threshold, it is not inlined.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "SmallCompiledLowLevelGraphSize",
                /*option*/ GraalOptions.SmallCompiledLowLevelGraphSize);
        }
        case "SnippetCounters": {
            return OptionDescriptor.create(
                /*name*/ "SnippetCounters",
                /*type*/ Boolean.class,
                /*help*/ "Enable counters for various paths in snippets.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "SnippetCounters",
                /*option*/ GraalOptions.SnippetCounters);
        }
        case "StressExplicitExceptionCode": {
            return OptionDescriptor.create(
                /*name*/ "StressExplicitExceptionCode",
                /*type*/ Boolean.class,
                /*help*/ "Stress the code emitting explicit exception throwing code.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "StressExplicitExceptionCode",
                /*option*/ GraalOptions.StressExplicitExceptionCode);
        }
        case "StressInvokeWithExceptionNode": {
            return OptionDescriptor.create(
                /*name*/ "StressInvokeWithExceptionNode",
                /*type*/ Boolean.class,
                /*help*/ "Stress the code emitting invokes with explicit exception edges.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "StressInvokeWithExceptionNode",
                /*option*/ GraalOptions.StressInvokeWithExceptionNode);
        }
        case "StressTestEarlyReads": {
            return OptionDescriptor.create(
                /*name*/ "StressTestEarlyReads",
                /*type*/ Boolean.class,
                /*help*/ "Stress the code by emitting reads at earliest instead of latest point.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "StressTestEarlyReads",
                /*option*/ GraalOptions.StressTestEarlyReads);
        }
        case "SupportJsrBytecodes": {
            return OptionDescriptor.create(
                /*name*/ "SupportJsrBytecodes",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "SupportJsrBytecodes",
                /*option*/ GraalOptions.SupportJsrBytecodes);
        }
        case "TailDuplicationProbability": {
            return OptionDescriptor.create(
                /*name*/ "TailDuplicationProbability",
                /*type*/ Double.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "TailDuplicationProbability",
                /*option*/ GraalOptions.TailDuplicationProbability);
        }
        case "TailDuplicationTrivialSize": {
            return OptionDescriptor.create(
                /*name*/ "TailDuplicationTrivialSize",
                /*type*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "TailDuplicationTrivialSize",
                /*option*/ GraalOptions.TailDuplicationTrivialSize);
        }
        case "TraceEscapeAnalysis": {
            return OptionDescriptor.create(
                /*name*/ "TraceEscapeAnalysis",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "TraceEscapeAnalysis",
                /*option*/ GraalOptions.TraceEscapeAnalysis);
        }
        case "TraceRA": {
            return OptionDescriptor.create(
                /*name*/ "TraceRA",
                /*type*/ Boolean.class,
                /*help*/ "Enable experimental Trace Register Allocation.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "TraceRA",
                /*option*/ GraalOptions.TraceRA);
        }
        case "TrivialInliningSize": {
            return OptionDescriptor.create(
                /*name*/ "TrivialInliningSize",
                /*type*/ Integer.class,
                /*help*/ "Graphs with less than this number of nodes are trivial and therefore always inlined.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "TrivialInliningSize",
                /*option*/ GraalOptions.TrivialInliningSize);
        }
        case "UseExceptionProbability": {
            return OptionDescriptor.create(
                /*name*/ "UseExceptionProbability",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "UseExceptionProbability",
                /*option*/ GraalOptions.UseExceptionProbability);
        }
        case "UseLoopLimitChecks": {
            return OptionDescriptor.create(
                /*name*/ "UseLoopLimitChecks",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "UseLoopLimitChecks",
                /*option*/ GraalOptions.UseLoopLimitChecks);
        }
        case "UseSnippetGraphCache": {
            return OptionDescriptor.create(
                /*name*/ "UseSnippetGraphCache",
                /*type*/ Boolean.class,
                /*help*/ "Use a cache for snippet graphs.",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "UseSnippetGraphCache",
                /*option*/ GraalOptions.UseSnippetGraphCache);
        }
        case "UseTypeCheckHints": {
            return OptionDescriptor.create(
                /*name*/ "UseTypeCheckHints",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "UseTypeCheckHints",
                /*option*/ GraalOptions.UseTypeCheckHints);
        }
        case "VerifyHeapAtReturn": {
            return OptionDescriptor.create(
                /*name*/ "VerifyHeapAtReturn",
                /*type*/ Boolean.class,
                /*help*/ "Perform platform dependent validation of the Java heap at returns",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "VerifyHeapAtReturn",
                /*option*/ GraalOptions.VerifyHeapAtReturn);
        }
        case "VerifyPhases": {
            return OptionDescriptor.create(
                /*name*/ "VerifyPhases",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "VerifyPhases",
                /*option*/ GraalOptions.VerifyPhases);
        }
        case "ZapStackOnMethodEntry": {
            return OptionDescriptor.create(
                /*name*/ "ZapStackOnMethodEntry",
                /*type*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ GraalOptions.class,
                /*fieldName*/ "ZapStackOnMethodEntry",
                /*option*/ GraalOptions.ZapStackOnMethodEntry);
        }
        // CheckStyle: resume line length check
        }
        return null;
    }

    @Override
    public Iterator<OptionDescriptor> iterator() {
        return new Iterator<OptionDescriptor>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < 77;
            }
            @Override
            public OptionDescriptor next() {
                switch (i++) {
                    case 0: return get("AlwaysInlineVTableStubs");
                    case 1: return get("CallArrayCopy");
                    case 2: return get("CanOmitFrame");
                    case 3: return get("ConditionalElimination");
                    case 4: return get("DeoptALot");
                    case 5: return get("DeoptsToDisableOptimisticOptimization");
                    case 6: return get("EagerSnippets");
                    case 7: return get("EscapeAnalysisIterations");
                    case 8: return get("EscapeAnalysisLoopCutoff");
                    case 9: return get("EscapeAnalyzeOnly");
                    case 10: return get("FullUnroll");
                    case 11: return get("GCDebugStartCycle");
                    case 12: return get("GenLoopSafepoints");
                    case 13: return get("GenSafepoints");
                    case 14: return get("GeneratePIC");
                    case 15: return get("HotSpotPrintInlining");
                    case 16: return get("ImmutableCode");
                    case 17: return get("InlineEverything");
                    case 18: return get("InlineMegamorphicCalls");
                    case 19: return get("InlineMonomorphicCalls");
                    case 20: return get("InlinePolymorphicCalls");
                    case 21: return get("InlineVTableStubs");
                    case 22: return get("Intrinsify");
                    case 23: return get("LimitInlinedInvokes");
                    case 24: return get("LoopMaxUnswitch");
                    case 25: return get("LoopPeeling");
                    case 26: return get("LoopUnswitch");
                    case 27: return get("MatchExpressions");
                    case 28: return get("MaximumDesiredSize");
                    case 29: return get("MaximumEscapeAnalysisArrayLength");
                    case 30: return get("MaximumInliningSize");
                    case 31: return get("MaximumRecursiveInlining");
                    case 32: return get("MegamorphicInliningMinMethodProbability");
                    case 33: return get("MinimumPeelProbability");
                    case 34: return get("OmitHotExceptionStacktrace");
                    case 35: return get("OptAssumptions");
                    case 36: return get("OptClearNonLiveLocals");
                    case 37: return get("OptConvertDeoptsToGuards");
                    case 38: return get("OptDeoptimizationGrouping");
                    case 39: return get("OptDevirtualizeInvokesOptimistically");
                    case 40: return get("OptEliminateGuards");
                    case 41: return get("OptEliminatePartiallyRedundantGuards");
                    case 42: return get("OptFilterProfiledTypes");
                    case 43: return get("OptFloatingReads");
                    case 44: return get("OptImplicitNullChecks");
                    case 45: return get("OptLoopTransform");
                    case 46: return get("OptReadElimination");
                    case 47: return get("OptScheduleOutOfLoops");
                    case 48: return get("PEAInliningHints");
                    case 49: return get("PartialEscapeAnalysis");
                    case 50: return get("PartialUnroll");
                    case 51: return get("PrintProfilingInformation");
                    case 52: return get("RawConditionalElimination");
                    case 53: return get("ReadEliminationMaxLoopVisits");
                    case 54: return get("ReassociateInvariants");
                    case 55: return get("RegisterPressure");
                    case 56: return get("RemoveNeverExecutedCode");
                    case 57: return get("ReplaceInputsWithConstantsBasedOnStamps");
                    case 58: return get("ResolveClassBeforeStaticInvoke");
                    case 59: return get("SmallCompiledLowLevelGraphSize");
                    case 60: return get("SnippetCounters");
                    case 61: return get("StressExplicitExceptionCode");
                    case 62: return get("StressInvokeWithExceptionNode");
                    case 63: return get("StressTestEarlyReads");
                    case 64: return get("SupportJsrBytecodes");
                    case 65: return get("TailDuplicationProbability");
                    case 66: return get("TailDuplicationTrivialSize");
                    case 67: return get("TraceEscapeAnalysis");
                    case 68: return get("TraceRA");
                    case 69: return get("TrivialInliningSize");
                    case 70: return get("UseExceptionProbability");
                    case 71: return get("UseLoopLimitChecks");
                    case 72: return get("UseSnippetGraphCache");
                    case 73: return get("UseTypeCheckHints");
                    case 74: return get("VerifyHeapAtReturn");
                    case 75: return get("VerifyPhases");
                    case 76: return get("ZapStackOnMethodEntry");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
