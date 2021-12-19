// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: LoopFullUnrollPhase.java
package org.graalvm.compiler.loop.phases;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class LoopFullUnrollPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "FullUnrollMaxApplication": {
            return OptionDescriptor.create(
                /*name*/ "FullUnrollMaxApplication",
                /*optionType*/ OptionType.Expert,
                /*optionValueType*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ LoopFullUnrollPhase.Options.class,
                /*fieldName*/ "FullUnrollMaxApplication",
                /*option*/ LoopFullUnrollPhase.Options.FullUnrollMaxApplication);
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
                    case 0: return get("FullUnrollMaxApplication");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
