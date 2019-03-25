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


package org.graalvm.compiler.hotspot.replacements;

import org.graalvm.compiler.hotspot.replacements.NewObjectSnippets.ProfileContext;
import org.graalvm.compiler.options.EnumOptionKey;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionKey;

/**
 * Options related to HotSpot snippets in this package.
 *
 * Note: This must be a top level class to work around for
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=477597">Eclipse bug 477597</a>.
 */
public class HotspotSnippetsOptions {

    // @formatter:off
    @Option(help = "If the probability that a type check will hit one the profiled types (up to " +
                   "TypeCheckMaxHints) is below this value, the type check will be compiled without profiling info", type = OptionType.Expert)
    public static final OptionKey<Double> TypeCheckMinProfileHitProbability = new OptionKey<>(0.5);

    @Option(help = "The maximum number of profiled types that will be used when compiling a profiled type check. " +
                    "Note that TypeCheckMinProfileHitProbability also influences whether profiling info is used in compiled type checks.", type = OptionType.Expert)
    public static final OptionKey<Integer> TypeCheckMaxHints = new OptionKey<>(2);

    @Option(help = "Use a VM runtime call to load and clear the exception object from the thread at the start of a compiled exception handler.", type = OptionType.Debug)
    public static final OptionKey<Boolean> LoadExceptionObjectInVM = new OptionKey<>(false);

    @Option(help = "Enable profiling of allocation sites.", type = OptionType.Debug)
    public static final OptionKey<Boolean> ProfileAllocations = new OptionKey<>(false);

    @Option(help = "file:doc-files/ProfileAllocationsContextHelp.txt", type = OptionType.Debug)
    public static final EnumOptionKey<ProfileContext> ProfileAllocationsContext = new EnumOptionKey<>(ProfileContext.AllocatingMethod);

    @Option(help = "Enable profiling of monitor operations.", type = OptionType.Debug)
    public static final OptionKey<Boolean> ProfileMonitors = new OptionKey<>(false);

    @Option(help = "Handle simple cases for inflated monitors in the fast-path.", type = OptionType.Expert)
    public static final OptionKey<Boolean> SimpleFastInflatedLocking = new OptionKey<>(true);

    @Option(help = "Trace monitor operations on objects whose type contains this substring.", type = OptionType.Debug)
    public static final OptionKey<String> TraceMonitorsTypeFilter = new OptionKey<>(null);

    @Option(help = "Trace monitor operations in methods whose fully qualified name contains this substring.", type = OptionType.Debug)
    public static final OptionKey<String> TraceMonitorsMethodFilter = new OptionKey<>(null);

    @Option(help = "Emit extra code to dynamically check monitor operations are balanced.", type = OptionType.Debug)
    public static final OptionKey<Boolean> VerifyBalancedMonitors = new OptionKey<>(false);
    //@formatter:on
}
