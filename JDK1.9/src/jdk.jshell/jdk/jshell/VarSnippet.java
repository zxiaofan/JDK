/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
 * @jls 8.3: FieldDeclaration.
 */
public class VarSnippet extends DeclarationSnippet {

    final String typeName;

     VarSnippet(VarKey key, String userSource, Wrap guts,
            String name, SubKind subkind, String typeName,
            Collection<String> declareReferences,
            DiagList syntheticDiags) {
        super(key, userSource, guts, name, subkind, null, declareReferences,
                null, syntheticDiags);
        this.typeName = typeName;
    }

    /**
     * A String representation of the type of the variable.
     * @return the variable type as a String.
     */
    public String typeName() {
        return typeName;
    }
}
