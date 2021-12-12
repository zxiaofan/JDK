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
import jdk.jshell.Key.TypeDeclKey;

/**
 * Snippet for a type definition (a class, interface, enum, or annotation
 * interface definition).
 * The Kind is {@link jdk.jshell.Snippet.Kind#TYPE_DECL}.
 * <p>
 * <code>TypeDeclSnippet</code> is immutable: an access to
 * any of its methods will always return the same result.
 * and thus is thread-safe.
 *
 * @since 9
 */
public class TypeDeclSnippet extends DeclarationSnippet {

    TypeDeclSnippet(TypeDeclKey key, String userSource, Wrap guts,
            String unitName, SubKind subkind, Wrap corralled,
            Collection<String> declareReferences,
            Collection<String> bodyReferences,
            DiagList syntheticDiags) {
        super(key, userSource, guts, unitName, subkind, corralled,
                declareReferences, bodyReferences, syntheticDiags);
    }

    /**** internal access ****/

    @Override
    TypeDeclKey key() {
        return (TypeDeclKey) super.key();
    }
}
