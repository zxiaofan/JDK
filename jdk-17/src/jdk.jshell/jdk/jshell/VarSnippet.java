/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package jdk.jshell;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import jdk.jshell.Key.VarKey;

/**
 * Snippet for a variable definition.
 * The Kind is {@link jdk.jshell.Snippet.Kind#VAR}.
 * <p>
 * <code>VarSnippet</code> is immutable: an access to
 * any of its methods will always return the same result.
 * and thus is thread-safe.
 *
 * @since 9
 * @jls 8.3 Field Declarations
 */
public class VarSnippet extends DeclarationSnippet {

    /**A human readable type of the variable. May include intersection types
     * and human readable description of anonymous classes.
     */
    final String typeName;

    /**The full type inferred for "var" variables. May include intersection types
     * and inaccessible types. {@literal null} if enhancing the type is not necessary.
     */
    final String fullTypeName;

    /**The anonymous class declared in the initializer of the "var" variable.
     * These are automatically statically imported when the field is imported.
     */
    final Set<String> anonymousClasses;

     VarSnippet(VarKey key, String userSource, Wrap guts,
            String name, SubKind subkind, String typeName, String fullTypeName,
            Set<String> anonymousClasses, Collection<String> declareReferences,
            DiagList syntheticDiags) {
        super(key, userSource, guts, name, subkind, null, declareReferences,
                null, syntheticDiags);
        this.typeName = typeName;
        this.fullTypeName = fullTypeName;
        this.anonymousClasses = anonymousClasses;
    }

    /**
     * A String representation of the type of the variable.
     * @return the variable type as a String.
     */
    public String typeName() {
        return typeName;
    }

    @Override
    String importLine(JShell state) {
        return "import static " + classFullName() + "." + name() + ";   " +
               anonymousClasses.stream()
                               .map(c -> "import static " + classFullName() + "." + c + ";   ")
                               .collect(Collectors.joining());
    }

}
