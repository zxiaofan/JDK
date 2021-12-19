// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: LoopPolicies.java
package org.graalvm.compiler.loop;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class LoopPolicies_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "PeelALot": {
            return OptionDescriptor.create(
                /*name*/ "PeelALot",
                /*optionType*/ OptionType.Expert,
                /*optionValueType*/ Boolean.class,
                /*help*/ "",
                /*declaringClass*/ LoopPolicies.Options.class,
                /*fieldName*/ "PeelALot",
                /*option*/ LoopPolicies.Options.PeelALot);
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
                return i < 1;
            }
            @Override
            public OptionDescriptor next() {
                switch (i++) {
                    case 0: return get("PeelALot");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
