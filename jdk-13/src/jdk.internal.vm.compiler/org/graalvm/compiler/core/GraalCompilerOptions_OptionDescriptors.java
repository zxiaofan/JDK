// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: GraalCompilerOptions.java
package org.graalvm.compiler.core;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class GraalCompilerOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "CompilationBailoutAsFailure": {
            return OptionDescriptor.create(
                /*name*/ "CompilationBailoutAsFailure",
                /*optionType*/ OptionType.User,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Treat compilation bailouts like compilation failures.",
                /*declaringClass*/ GraalCompilerOptions.class,
                /*fieldName*/ "CompilationBailoutAsFailure",
                /*option*/ GraalCompilerOptions.CompilationBailoutAsFailure);
        }
        case "CompilationFailureAction": {
            return OptionDescriptor.create(
                /*name*/ "CompilationFailureAction",
                /*optionType*/ OptionType.User,
                /*optionValueType*/ org.graalvm.compiler.core.CompilationWrapper.ExceptionAction.class,
                /*help*/ "Specifies the action to take when compilation fails.",
                /*extraHelp*/ new String[] {
                         "The accepted values are:",
                         "    Silent - Print nothing to the console.",
                         "     Print - Print a stack trace to the console.",
                         "  Diagnose - Retry the compilation with extra diagnostics.",
                         "    ExitVM - Same as Diagnose except that the VM process exits after retrying.",
                              },
                /*declaringClass*/ GraalCompilerOptions.class,
                /*fieldName*/ "CompilationFailureAction",
                /*option*/ GraalCompilerOptions.CompilationFailureAction);
        }
        case "CrashAt": {
            return OptionDescriptor.create(
                /*name*/ "CrashAt",
                /*optionType*/ OptionType.Debug,
                /*optionValueType*/ String.class,
                /*help*/ "Pattern for method(s) that will trigger an exception when compiled. This option exists to test handling compilation crashes gracefully. See the MethodFilter option for the pattern syntax. A ':Bailout' suffix will raise a bailout exception and a ':PermanentBailout' suffix will raise a permanent bailout exception.",
                /*declaringClass*/ GraalCompilerOptions.class,
                /*fieldName*/ "CrashAt",
                /*option*/ GraalCompilerOptions.CrashAt);
        }
        case "ExitVMOnException": {
            return OptionDescriptor.create(
                /*name*/ "ExitVMOnException",
                /*optionType*/ OptionType.User,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Alias for CompilationFailureAction=ExitVM.",
                /*declaringClass*/ GraalCompilerOptions.class,
                /*fieldName*/ "ExitVMOnException",
                /*option*/ GraalCompilerOptions.ExitVMOnException);
        }
        case "MaxCompilationProblemsPerAction": {
            return OptionDescriptor.create(
                /*name*/ "MaxCompilationProblemsPerAction",
                /*optionType*/ OptionType.User,
                /*optionValueType*/ Integer.class,
                /*help*/ "The maximum number of compilation failures to handle with the action specified by CompilationFailureAction before changing to a less verbose action. This does not apply to the ExitVM action.",
                /*declaringClass*/ GraalCompilerOptions.class,
                /*fieldName*/ "MaxCompilationProblemsPerAction",
                /*option*/ GraalCompilerOptions.MaxCompilationProblemsPerAction);
        }
        case "PrintCompilation": {
            return OptionDescriptor.create(
                /*name*/ "PrintCompilation",
                /*optionType*/ OptionType.Debug,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Print an informational line to the console for each completed compilation.",
                /*declaringClass*/ GraalCompilerOptions.class,
                /*fieldName*/ "PrintCompilation",
                /*option*/ GraalCompilerOptions.PrintCompilation);
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
                return i < 6;
            }
            @Override
            public OptionDescriptor next() {
                switch (i++) {
                    case 0: return get("CompilationBailoutAsFailure");
                    case 1: return get("CompilationFailureAction");
                    case 2: return get("CrashAt");
                    case 3: return get("ExitVMOnException");
                    case 4: return get("MaxCompilationProblemsPerAction");
                    case 5: return get("PrintCompilation");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
