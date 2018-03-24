// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: FinalizeProfileNodesPhase.java
package org.graalvm.compiler.hotspot.phases.profiling;

import java.util.*;
import org.graalvm.compiler.options.*;

public class FinalizeProfileNodesPhase_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "ProfileSimpleMethods": {
            return OptionDescriptor.create(
                /*name*/ "ProfileSimpleMethods",
                /*type*/ Boolean.class,
                /*help*/ "Profile simple methods",
                /*declaringClass*/ FinalizeProfileNodesPhase.Options.class,
                /*fieldName*/ "ProfileSimpleMethods",
                /*option*/ FinalizeProfileNodesPhase.Options.ProfileSimpleMethods);
        }
        case "SimpleMethodCalls": {
            return OptionDescriptor.create(
                /*name*/ "SimpleMethodCalls",
                /*type*/ Integer.class,
                /*help*/ "Maximum number of calls in a simple method",
                /*declaringClass*/ FinalizeProfileNodesPhase.Options.class,
                /*fieldName*/ "SimpleMethodCalls",
                /*option*/ FinalizeProfileNodesPhase.Options.SimpleMethodCalls);
        }
        case "SimpleMethodGraphSize": {
            return OptionDescriptor.create(
                /*name*/ "SimpleMethodGraphSize",
                /*type*/ Integer.class,
                /*help*/ "Maximum number of nodes in a graph for a simple method",
                /*declaringClass*/ FinalizeProfileNodesPhase.Options.class,
                /*fieldName*/ "SimpleMethodGraphSize",
                /*option*/ FinalizeProfileNodesPhase.Options.SimpleMethodGraphSize);
        }
        case "SimpleMethodIndirectCalls": {
            return OptionDescriptor.create(
                /*name*/ "SimpleMethodIndirectCalls",
                /*type*/ Integer.class,
                /*help*/ "Maximum number of indirect calls in a simple moethod",
                /*declaringClass*/ FinalizeProfileNodesPhase.Options.class,
                /*fieldName*/ "SimpleMethodIndirectCalls",
                /*option*/ FinalizeProfileNodesPhase.Options.SimpleMethodIndirectCalls);
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
                return i < 4;
            }
            @Override
            public OptionDescriptor next() {
                switch (i++) {
                    case 0: return get("ProfileSimpleMethods");
                    case 1: return get("SimpleMethodCalls");
                    case 2: return get("SimpleMethodGraphSize");
                    case 3: return get("SimpleMethodIndirectCalls");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
