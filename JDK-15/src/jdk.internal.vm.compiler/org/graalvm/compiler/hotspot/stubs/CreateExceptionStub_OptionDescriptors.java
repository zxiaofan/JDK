// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: CreateExceptionStub.java
package org.graalvm.compiler.hotspot.stubs;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class CreateExceptionStub_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "HotSpotDeoptExplicitExceptions": {
            return OptionDescriptor.create(
                /*name*/ "HotSpotDeoptExplicitExceptions",
                /*optionType*/ OptionType.Expert,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Testing only option that forces deopts for exception throws",
                /*declaringClass*/ CreateExceptionStub.Options.class,
                /*fieldName*/ "HotSpotDeoptExplicitExceptions",
                /*option*/ CreateExceptionStub.Options.HotSpotDeoptExplicitExceptions);
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
                    case 0: return get("HotSpotDeoptExplicitExceptions");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
