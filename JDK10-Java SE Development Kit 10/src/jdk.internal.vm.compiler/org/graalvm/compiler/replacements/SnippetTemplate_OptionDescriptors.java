// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: SnippetTemplate.java
package org.graalvm.compiler.replacements;

import java.util.*;
import org.graalvm.compiler.options.*;

public class SnippetTemplate_OptionDescriptors implements OptionDescriptors {
    @Override
    public OptionDescriptor get(String value) {
        switch (value) {
        // CheckStyle: stop line length check
        case "MaxTemplatesPerSnippet": {
            return OptionDescriptor.create(
                /*name*/ "MaxTemplatesPerSnippet",
                /*type*/ Integer.class,
                /*help*/ "",
                /*declaringClass*/ SnippetTemplate.Options.class,
                /*fieldName*/ "MaxTemplatesPerSnippet",
                /*option*/ SnippetTemplate.Options.MaxTemplatesPerSnippet);
        }
        case "UseSnippetTemplateCache": {
            return OptionDescriptor.create(
                /*name*/ "UseSnippetTemplateCache",
                /*type*/ Boolean.class,
                /*help*/ "Use a LRU cache for snippet templates.",
                /*declaringClass*/ SnippetTemplate.Options.class,
                /*fieldName*/ "UseSnippetTemplateCache",
                /*option*/ SnippetTemplate.Options.UseSnippetTemplateCache);
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
                    case 0: return get("MaxTemplatesPerSnippet");
                    case 1: return get("UseSnippetTemplateCache");
                }
                throw new NoSuchElementException();
            }
        };
    }
}
