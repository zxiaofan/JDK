/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
 * Exception reported on attempting to execute a
 * {@link jdk.jshell.Snippet.Status#RECOVERABLE_DEFINED RECOVERABLE_DEFINED}
 * snippet.
 * <p>
 * The stack can be queried by methods on <code>Exception</code>.
 * Note that in stack trace frames representing JShell Snippets,
 * <code>StackTraceElement.getFileName()</code> will return "#" followed by
 * the Snippet id and for snippets without a method name (for example an
 * expression) <code>StackTraceElement.getName()</code> will be the
 * empty string.
 *
 * @since 9
 */
@SuppressWarnings("serial")             // serialVersionUID intentionally omitted
public class UnresolvedReferenceException extends JShellException {

    final DeclarationSnippet snippet;

    UnresolvedReferenceException(DeclarationSnippet snippet, StackTraceElement[] stackElements) {
        super("Attempt to use definition snippet with unresolved references in " + snippet);
        this.snippet = snippet;
        this.setStackTrace(stackElements);
    }

    /**
     * Return the Snippet which has the unresolved reference(s).
     * @return the <code>Snippet</code> of the
     * {@link jdk.jshell.Snippet.Status#RECOVERABLE_DEFINED RECOVERABLE_DEFINED}
     * definition snippet.
     */
    public DeclarationSnippet getSnippet() {
        return snippet;
    }
}
