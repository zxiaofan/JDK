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
import jdk.jshell.Key.MethodKey;

/**
 * Snippet for a method definition.
 * The Kind is {@link jdk.jshell.Snippet.Kind#METHOD}.
 * <p>
 * <code>MethodSnippet</code> is immutable: an access to
 * any of its methods will always return the same result.
 * and thus is thread-safe.
 *
 * @since 9
 * @jls 8.4: MethodDeclaration.
 */
public class MethodSnippet extends DeclarationSnippet {

    final String signature;
    private String qualifiedParamaterTypes;

    MethodSnippet(MethodKey key, String userSource, Wrap guts,
            String name, String signature, Wrap corralled,
            Collection<String> declareReferences, Collection<String> bodyReferences,
            DiagList syntheticDiags) {
        super(key, userSource, guts, name, SubKind.METHOD_SUBKIND, corralled,
                declareReferences, bodyReferences, syntheticDiags);
        this.signature = signature;
    }

    /**
     * A String representation of the parameter types of the method.
     * @return a comma separated list of user entered parameter types for the
     * method.
     */
    public String parameterTypes() {
        return key().parameterTypes();
    }

    /**
     * The full type signature of the method, including return type.
     * @return A String representation of the parameter and return types
     */
    public String signature() {
        return signature;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MethodSnippet:");
        sb.append(name());
        sb.append('/');
        sb.append(signature());
        sb.append('-');
        sb.append(source());
        return sb.toString();
    }

    /**** internal access ****/

    @Override
    MethodKey key() {
        return (MethodKey) super.key();
    }

    String qualifiedParameterTypes() {
        return qualifiedParamaterTypes;
    }

    void setQualifiedParamaterTypes(String sig) {
        qualifiedParamaterTypes = sig;
    }
}
