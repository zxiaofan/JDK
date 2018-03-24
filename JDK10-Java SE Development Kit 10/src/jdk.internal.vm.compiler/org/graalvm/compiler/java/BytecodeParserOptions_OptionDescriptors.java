// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: BytecodeParserOptions.java
package org.graalvm.compiler.java;

import java.util.*;
import org.graalvm.compiler.options.*;

public class BytecodeParserOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "HideSubstitutionStates": {
            return OptionDescriptor.create(
                /*name*/ "HideSubstitutionStates",
                /*type*/ Boolean.class,
                /*help*/ "When creating info points hide the methods of the substitutions.",
                /*declaringClass*/ BytecodeParserOptions.class,
                /*fieldName*/ "HideSubstitutionStates",
                /*option*/ BytecodeParserOptions.HideSubstitutionStates);
        }
        case "InlineDuringParsing": {
            return OptionDescriptor.create(
                /*name*/ "InlineDuringParsing",
                /*type*/ Boolean.class,
                /*help*/ "Inlines trivial methods during bytecode parsing.",
                /*declaringClass*/ BytecodeParserOptions.class,
                /*fieldName*/ "InlineDuringParsing",
                /*option*/ BytecodeParserOptions.InlineDuringParsing);
        }
        case "InlineDuringParsingMaxDepth": {
            return OptionDescriptor.create(
                /*name*/ "InlineDuringParsingMaxDepth",
                /*type*/ Integer.class,
                /*help*/ "Maximum depth when inlining during bytecode parsing.",
                /*declaringClass*/ BytecodeParserOptions.class,
                /*fieldName*/ "InlineDuringParsingMaxDepth",
                /*option*/ BytecodeParserOptions.InlineDuringParsingMaxDepth);
        }
        case "InlineIntrinsicsDuringParsing": {
            return OptionDescriptor.create(
                /*name*/ "InlineIntrinsicsDuringParsing",
                /*type*/ Boolean.class,
                /*help*/ "Inlines intrinsic methods during bytecode parsing.",
                /*declaringClass*/ BytecodeParserOptions.class,
                /*fieldName*/ "InlineIntrinsicsDuringParsing",
                /*option*/ BytecodeParserOptions.InlineIntrinsicsDuringParsing);
        }
        case "InlinePartialIntrinsicExitDuringParsing": {
            return OptionDescriptor.create(
                /*name*/ "InlinePartialIntrinsicExitDuringParsing",
                /*type*/ Boolean.class,
                /*help*/ "Inlines partial intrinsic exits during bytecode parsing when possible. A partial intrinsic exit is a call within an intrinsic to the method being intrinsified and denotes semantics of the original method that the intrinsic does not support.",
                /*declaringClass*/ BytecodeParserOptions.class,
                /*fieldName*/ "InlinePartialIntrinsicExitDuringParsing",
                /*option*/ BytecodeParserOptions.InlinePartialIntrinsicExitDuringParsing);
        }
        case "TraceBytecodeParserLevel": {
            return OptionDescriptor.create(
                /*name*/ "TraceBytecodeParserLevel",
                /*type*/ Integer.class,
                /*help*/ "The trace level for the bytecode parser used when building a graph from bytecode",
                /*declaringClass*/ BytecodeParserOptions.class,
                /*fieldName*/ "TraceBytecodeParserLevel",
                /*option*/ BytecodeParserOptions.TraceBytecodeParserLevel);
        }
        case "TraceInlineDuringParsing": {
            return OptionDescriptor.create(
                /*name*/ "TraceInlineDuringParsing",
                /*type*/ Boolean.class,
                /*help*/ "Traces inlining performed during bytecode parsing.",
                /*declaringClass*/ BytecodeParserOptions.class,
                /*fieldName*/ "TraceInlineDuringParsing",
                /*option*/ BytecodeParserOptions.TraceInlineDuringParsing);
        }
        case "TraceParserPlugins": {
            return OptionDescriptor.create(
                /*name*/ "TraceParserPlugins",
                /*type*/ Boolean.class,
                /*help*/ "Traces use of plugins during bytecode parsing.",
                /*declaringClass*/ BytecodeParserOptions.class,
                /*fieldName*/ "TraceParserPlugins",
                /*option*/ BytecodeParserOptions.TraceParserPlugins);
        }
        case "UseGuardedIntrinsics": {
            return OptionDescriptor.create(
                /*name*/ "UseGuardedIntrinsics",
                /*type*/ Boolean.class,
                /*help*/ "Use intrinsics guarded by a virtual dispatch test at indirect call sites.",
                /*declaringClass*/ BytecodeParserOptions.class,
                /*fieldName*/ "UseGuardedIntrinsics",
                /*option*/ BytecodeParserOptions.UseGuardedIntrinsics);
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
                return i < 9;
            }
            @Override
            public OptionDescriptor next() {
                switch (i++) {
                    case 0: return get("HideSubstitutionStates");
                    case 1: return get("InlineDuringParsing");
                    case 2: return get("InlineDuringParsingMaxDepth");
                    case 3: return get("InlineIntrinsicsDuringParsing");
                    case 4: return get("InlinePartialIntrinsicExitDuringParsing");
                    case 5: return get("TraceBytecodeParserLevel");
                    case 6: return get("TraceInlineDuringParsing");
                    case 7: return get("TraceParserPlugins");
                    case 8: return get("UseGuardedIntrinsics");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
