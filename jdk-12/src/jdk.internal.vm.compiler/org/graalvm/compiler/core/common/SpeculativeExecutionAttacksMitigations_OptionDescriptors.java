// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: SpeculativeExecutionAttacksMitigations.java
package org.graalvm.compiler.core.common;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class SpeculativeExecutionAttacksMitigations_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "MitigateSpeculativeExecutionAttacks": {
            return OptionDescriptor.create(
                /*name*/ "MitigateSpeculativeExecutionAttacks",
                /*optionType*/ OptionType.User,
                /*optionValueType*/ org.graalvm.compiler.core.common.SpeculativeExecutionAttacksMitigations.class,
                /*help*/ "Select a strategy to mitigate speculative execution attacks (e.g., SPECTRE)",
                /*declaringClass*/ SpeculativeExecutionAttacksMitigations.Options.class,
                /*fieldName*/ "MitigateSpeculativeExecutionAttacks",
                /*option*/ SpeculativeExecutionAttacksMitigations.Options.MitigateSpeculativeExecutionAttacks);
        }
        case "UseIndexMasking": {
            return OptionDescriptor.create(
                /*name*/ "UseIndexMasking",
                /*optionType*/ OptionType.User,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Use index masking after bounds check to mitigate speculative execution attacks",
                /*declaringClass*/ SpeculativeExecutionAttacksMitigations.Options.class,
                /*fieldName*/ "UseIndexMasking",
                /*option*/ SpeculativeExecutionAttacksMitigations.Options.UseIndexMasking);
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
                return i < 2;
            }
            @Override
            public OptionDescriptor next() {
                switch (i++) {
                    case 0: return get("MitigateSpeculativeExecutionAttacks");
                    case 1: return get("UseIndexMasking");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
