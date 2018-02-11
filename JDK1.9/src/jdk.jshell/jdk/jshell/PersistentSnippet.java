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

/**
 * Grouping for Snippets which persist and influence future code.
 * A persistent snippet can be
 * {@linkplain jdk.jshell.Snippet.Status#OVERWRITTEN overwritten}
 * with new input.
 * <p>
 * <code>PersistentSnippet</code> is immutable: an access to
 * any of its methods will always return the same result.
 * and thus is thread-safe.
 *
 * @since 9
 */
public abstract class PersistentSnippet extends Snippet {

    PersistentSnippet(Key key, String userSource, Wrap guts, String unitName,
            SubKind subkind, DiagList syntheticDiags) {
        super(key, userSource, guts, unitName, subkind, syntheticDiags);
    }

    /**
     * Name of the Snippet.
     *
     * @return the name of the snippet.
     */
    @Override
    public String name() {
        return unitName;
    }
}
