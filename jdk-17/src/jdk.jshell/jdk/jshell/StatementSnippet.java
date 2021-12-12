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

import jdk.jshell.Key.StatementKey;

/**
 * Snippet for a statement.
 * The Kind is {@link jdk.jshell.Snippet.Kind#STATEMENT}.
 * <p>
 * <code>StatementSnippet</code> is immutable: an access to
 * any of its methods will always return the same result.
 * and thus is thread-safe.
 *
 * @since 9
 * @jls 14.5 Statements
 */
public class StatementSnippet extends Snippet {

    StatementSnippet(StatementKey key, String userSource, Wrap guts) {
        super(key, userSource, guts, null, SubKind.STATEMENT_SUBKIND, null);
    }
}
