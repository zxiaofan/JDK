// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: StubOptions.java
package org.graalvm.compiler.hotspot.stubs;

import java.util.*;
import org.graalvm.compiler.options.*;
import org.graalvm.compiler.options.OptionType;

public class StubOptions_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "TraceExceptionHandlerStub": {
            return OptionDescriptor.create(
                /*name*/ "TraceExceptionHandlerStub",
                /*optionType*/ OptionType.Debug,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Trace execution of stub used to handle an exception thrown by a callee.",
                /*declaringClass*/ StubOptions.class,
                /*fieldName*/ "TraceExceptionHandlerStub",
                /*option*/ StubOptions.TraceExceptionHandlerStub);
        }
        case "TraceUnwindStub": {
            return OptionDescriptor.create(
                /*name*/ "TraceUnwindStub",
                /*optionType*/ OptionType.Debug,
                /*optionValueType*/ Boolean.class,
                /*help*/ "Trace execution of the stub that routes an exception to a handler in the calling frame.",
                /*declaringClass*/ StubOptions.class,
                /*fieldName*/ "TraceUnwindStub",
                /*option*/ StubOptions.TraceUnwindStub);
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
                    case 0: return get("TraceExceptionHandlerStub");
                    case 1: return get("TraceUnwindStub");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
