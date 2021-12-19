// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HotSpotNodePlugin.java
package org.graalvm.compiler.hotspot.meta;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class HotSpotNodePlugin_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "HotSpotPostOnExceptions": {
            return OptionDescriptor.create(
                /*name*/ "HotSpotPostOnExceptions",
                /*optionType*/ OptionType.Expert,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Testing only option that forces deopts for exception throws",
                /*declaringClass*/ HotSpotNodePlugin.Options.class,
                /*fieldName*/ "HotSpotPostOnExceptions",
                /*option*/ HotSpotNodePlugin.Options.HotSpotPostOnExceptions);
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
                    case 0: return get("HotSpotPostOnExceptions");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
