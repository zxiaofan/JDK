// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HotSpotCompiledCodeBuilder.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class HotSpotCompiledCodeBuilder_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "ShowSubstitutionSourceInfo": {
            return OptionDescriptor.create(
                /*name*/ "ShowSubstitutionSourceInfo",
                /*optionType*/ OptionType.Debug,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Controls whether the source position information of snippets and method substitutions are exposed to HotSpot.  Can be useful when profiling to get more precise position information.",
                /*declaringClass*/ HotSpotCompiledCodeBuilder.Options.class,
                /*fieldName*/ "ShowSubstitutionSourceInfo",
                /*option*/ HotSpotCompiledCodeBuilder.Options.ShowSubstitutionSourceInfo);
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
                    case 0: return get("ShowSubstitutionSourceInfo");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
