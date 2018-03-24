// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: HotSpotGraalCompilerFactory.java
package org.graalvm.compiler.hotspot;

import java.util.*;
import org.graalvm.compiler.options.*;

public class HotSpotGraalCompilerFactory_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "CompileGraalWithC1Only": {
            return OptionDescriptor.create(
                /*name*/ "CompileGraalWithC1Only",
                /*type*/ Boolean.class,
                /*help*/ "In tiered mode compile Graal and JVMCI using optimized first tier code.",
                /*declaringClass*/ HotSpotGraalCompilerFactory.Options.class,
                /*fieldName*/ "CompileGraalWithC1Only",
                /*option*/ HotSpotGraalCompilerFactory.Options.CompileGraalWithC1Only);
        }
        case "GraalCompileOnly": {
            return OptionDescriptor.create(
                /*name*/ "GraalCompileOnly",
                /*type*/ String.class,
                /*help*/ "A method filter selecting what should be compiled by Graal.  All other requests will be reduced to CompilationLevel.Simple.",
                /*declaringClass*/ HotSpotGraalCompilerFactory.Options.class,
                /*fieldName*/ "GraalCompileOnly",
                /*option*/ HotSpotGraalCompilerFactory.Options.GraalCompileOnly);
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
                    case 0: return get("CompileGraalWithC1Only");
                    case 1: return get("GraalCompileOnly");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
