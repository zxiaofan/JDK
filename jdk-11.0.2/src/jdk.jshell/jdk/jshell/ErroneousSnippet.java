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

import jdk.jshell.Key.ErroneousKey;

/**
 * A snippet of code that is not valid Java programming language code.
 * The Kind is {@link jdk.jshell.Snippet.Kind#ERRONEOUS ERRONEOUS}.
 * <p>
 * <code>ErroneousSnippet</code> is immutable: an access to
 * any of its methods will always return the same result.
 * and thus is thread-safe.
 *
 * @since 9
 */
public class ErroneousSnippet extends Snippet {

    private final Kind probableKind;

    ErroneousSnippet(ErroneousKey key, String userSource, Wrap guts,
            Kind probableKind, SubKind subkind) {
        super(key, userSource, guts, null, subkind, null);
        this.probableKind = probableKind;
    }

    /**
     * Returns what appears to be the intended Kind in this erroneous snippet.
     *
     * @return the probable Kind; or {@link Kind#ERRONEOUS} if that cannot be
     * determined.
     */
    public Kind probableKind() {
        return probableKind;
    }
}
