// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: CompilerConfigurationFactory.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class CompilerConfigurationFactory_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "CompilerConfiguration": {
            return OptionDescriptor.create(
                /*name*/ "CompilerConfiguration",
                /*type*/ String.class,
                /*help*/ "Names the Graal compiler configuration to use. If ommitted, the compiler configuration with the highest auto-selection priority is used. To see the set of available configurations, supply the value 'help' to this option.",
                /*declaringClass*/ CompilerConfigurationFactory.Options.class,
                /*fieldName*/ "CompilerConfiguration",
                /*option*/ CompilerConfigurationFactory.Options.CompilerConfiguration);
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
                    case 0: return get("CompilerConfiguration");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
