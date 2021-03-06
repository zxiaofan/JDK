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


package org.graalvm.compiler.core;

import org.graalvm.compiler.core.CompilationWrapper.ExceptionAction;
import org.graalvm.compiler.options.EnumOptionKey;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionKey;
import org.graalvm.compiler.options.OptionType;

/**
 * Options related to {@link GraalCompiler}.
 */
public class GraalCompilerOptions {

    // @formatter:off
    @Option(help = "Print an informational line to the console for each completed compilation.", type = OptionType.Debug)
    public static final OptionKey<Boolean> PrintCompilation = new OptionKey<>(false);
    @Option(help = "Pattern for method(s) that will trigger an exception when compiled. " +
                   "This option exists to test handling compilation crashes gracefully. " +
                   "See the MethodFilter option for the pattern syntax. A ':Bailout' " +
                   "suffix will raise a bailout exception and a ':PermanentBailout' " +
                   "suffix will raise a permanent bailout exception.", type = OptionType.Debug)
    public static final OptionKey<String> CrashAt = new OptionKey<>(null);
    @Option(help = "file:doc-files/CompilationBailoutActionHelp.txt", type = OptionType.User)
    public static final EnumOptionKey<ExceptionAction> CompilationBailoutAction = new EnumOptionKey<>(ExceptionAction.Silent);
    @Option(help = "Specifies the action to take when compilation fails with a bailout exception. " +
                   "The accepted values are the same as for CompilationBailoutAction.", type = OptionType.User)
     public static final EnumOptionKey<ExceptionAction> CompilationFailureAction = new EnumOptionKey<>(ExceptionAction.Diagnose);
    @Option(help = "The maximum number of compilation failures or bailouts to handle with the action specified " +
                   "by CompilationFailureAction or CompilationBailoutAction before changing to a less verbose action.", type = OptionType.User)
    public static final OptionKey<Integer> MaxCompilationProblemsPerAction = new OptionKey<>(2);
    @Option(help = "Alias for CompilationFailureAction=ExitVM.", type = OptionType.User)
    public static final OptionKey<Boolean> ExitVMOnException = new OptionKey<>(false);
    // @formatter:on
}
