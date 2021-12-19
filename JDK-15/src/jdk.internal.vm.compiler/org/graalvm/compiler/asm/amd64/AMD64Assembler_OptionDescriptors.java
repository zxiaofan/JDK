// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: AMD64Assembler.java
package org.graalvm.compiler.asm.amd64;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class AMD64Assembler_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "UseBranchesWithin32ByteBoundary": {
            return OptionDescriptor.create(
                /*name*/ "UseBranchesWithin32ByteBoundary",
                /*optionType*/ OptionType.User,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Force branch instructions to align with 32-bytes boundary, to mitigate the jcc erratum. See https://www.intel.com/content/dam/support/us/en/documents/processors/mitigations-jump-conditional-code-erratum.pdf for more details. If not set explicitly, the default value will be determined according to the CPU model.",
                /*declaringClass*/ AMD64Assembler.Options.class,
                /*fieldName*/ "UseBranchesWithin32ByteBoundary",
                /*option*/ AMD64Assembler.Options.UseBranchesWithin32ByteBoundary);
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
                    case 0: return get("UseBranchesWithin32ByteBoundary");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
