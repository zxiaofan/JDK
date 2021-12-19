// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: BciBlockMapping.java
package org.graalvm.compiler.java;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class BciBlockMapping_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "DuplicateIrreducibleLoops": {
            return OptionDescriptor.create(
                /*name*/ "DuplicateIrreducibleLoops",
                /*optionType*/ OptionType.Debug,
                /*optionValueType*/ Boolean.class,
                /*help*/ "When enabled, some limited amount of duplication will be performed in order compile code containing irreducible loops.",
                /*declaringClass*/ BciBlockMapping.Options.class,
                /*fieldName*/ "DuplicateIrreducibleLoops",
                /*option*/ BciBlockMapping.Options.DuplicateIrreducibleLoops);
        }
        case "MaxDuplicationFactor": {
            return OptionDescriptor.create(
                /*name*/ "MaxDuplicationFactor",
                /*optionType*/ OptionType.Expert,
                /*optionValueType*/ Double.class,
                /*help*/ "How much duplication can happen because of irreducible loops before bailing out.",
                /*declaringClass*/ BciBlockMapping.Options.class,
                /*fieldName*/ "MaxDuplicationFactor",
                /*option*/ BciBlockMapping.Options.MaxDuplicationFactor);
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
                    case 0: return get("DuplicateIrreducibleLoops");
                    case 1: return get("MaxDuplicationFactor");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
